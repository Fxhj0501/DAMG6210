USE DDMDProject;
CREATE TRIGGER trg_tickets_delete_orders
    ON Tickets
    AFTER DELETE
    AS
BEGIN
    -- delete orders that have no tickets
    DELETE FROM Orders
    WHERE order_id IN (
        SELECT o.order_id
        FROM Orders o
                 LEFT JOIN Tickets t ON o.order_id = t.order_id
        WHERE t.order_id IS NULL
    );
END;

CREATE TRIGGER trg_exhibition_delete_tickets
    ON Exhibition
    AFTER DELETE
    AS
BEGIN
    -- DELETE tickets for deleted exhibitions
    DELETE FROM Tickets
    WHERE exhibition_id IN (
        SELECT exhibition_id FROM Deleted
    );
END;
    DROP TRIGGER IF EXISTS trg_order_delete_tickets;

    CREATE TRIGGER trg_order_delete_tickets
        ON Orders
        INSTEAD OF DELETE
        AS
    BEGIN
        -- 删除与被删除订单相关的 Tickets
        DELETE FROM Tickets
        WHERE order_id IN (
            SELECT order_id FROM Deleted
        );

        -- 删除 Order 表中的记录
        DELETE FROM Orders
        WHERE order_id IN (
            SELECT order_id FROM Deleted
        );
    END;





