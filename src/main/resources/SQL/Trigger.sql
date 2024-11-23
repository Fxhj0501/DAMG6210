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

Create TRIGGER trg_exhibition_delete_tickets
    ON Exhibition
    INSTEAD OF DELETE
    AS
BEGIN
    DELETE FROM Tickets
    WHERE exhibition_id IN (
        SELECT exhibition_id FROM Deleted
    );

    DELETE FROM Exhibition
    WHERE exhibition_id IN (
        SELECT exhibition_id FROM Deleted
    );
END;


CREATE TRIGGER trg_order_delete_tickets
    ON Orders
    INSTEAD OF DELETE
    AS
BEGIN
    -- delete related tickets first
    DELETE FROM Tickets
    WHERE order_id IN (
        SELECT order_id FROM Deleted
    );

    -- delete related orders
    DELETE FROM Orders
    WHERE order_id IN (
        SELECT order_id FROM Deleted
    );
END;

Create TRIGGER trg_EncryptCustomerEmail
    ON Customer
    INSTEAD OF INSERT
    AS
BEGIN
    OPEN SYMMETRIC KEY encryptKey DECRYPTION BY PASSWORD = 'DAMGGroup20';
    SET IDENTITY_INSERT Customer ON;
    INSERT INTO Customer (customer_id, customer_email, registration_date, customer_name, customer_age,
                          selected_genres)
    SELECT customer_id,
           EncryptByKey(Key_GUID('encryptKey'), customer_email),
           registration_date,
           customer_name,
           customer_age,
           selected_genres
    FROM inserted;
    SET IDENTITY_INSERT Customer OFF;
END;



