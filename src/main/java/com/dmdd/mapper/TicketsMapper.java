package com.dmdd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dmdd.dao.Tickets;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TicketsMapper extends BaseMapper<Tickets> {
    @Insert({
            "SET IDENTITY_INSERT Tickets ON;",
            "INSERT INTO Tickets (ticket_id, exhibition_id, order_id, ticket_price, ticket_type, sale_start_date, sale_end_date, qr_code, max_tickets_per_order, refund_policy) ",
            "VALUES (#{ticketId}, #{exhibitionId}, #{orderId}, #{ticketPrice}, #{ticketType}, #{saleStartDate}, #{saleEndDate}, #{qrCode}, #{maxTicketsPerOrder}, #{refundPolicy})",
            "SET IDENTITY_INSERT Tickets OFF;"
    })
    int insertTicket(Tickets tickets);


}
