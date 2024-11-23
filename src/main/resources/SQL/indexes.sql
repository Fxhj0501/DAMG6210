use DDMDProject;

--In the view TicketSalesReport, this column is used for grouping (GROUP BY).
--In multiple stored procedures, the column is used for filtering (WHERE).
--In triggers, the column is used for counting and validation.
CREATE NONCLUSTERED INDEX IX_Tickets_ExhibitionID ON Tickets (exhibition_id);

-- to accelerate the connection between Show_Performer and Performer tables
CREATE NONCLUSTERED INDEX IX_Show_Performer_PerformerID ON Show_Performer (performer_id);

--This column is used in stored procedures to connect to the Sponsor table.
-- In user-defined functions, this column is used for filtering and querying.
CREATE NONCLUSTERED INDEX IX_Contract_SponsorID ON Contract (sponsor_id);


