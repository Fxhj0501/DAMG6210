INSERT INTO Sponsor (sponsor_name, description, contact_person, sponsorship_level, logo_url, contract_start_date, contract_end_date)
VALUES 
('Tech Corp', 'Leading provider of tech solutions', 'Alice Smith', 'Gold', 'http://techcorp.com/logo.png', '2023-01-01', '2023-12-31'),
('Green Solutions', 'Eco-friendly products and services', 'Bob Johnson', 'Silver', 'http://greensolutions.com/logo.png', '2023-02-01', '2023-11-30'),
('Future Innovations', 'R&D for cutting-edge tech', 'Chris White', 'Gold', 'http://futureinnovations.com/logo.png', '2023-03-01', '2023-10-31'),
('Smart Corp', 'Smart devices and IoT solutions', 'Diane King', 'Bronze', 'http://smartcorp.com/logo.png', '2023-04-01', '2023-09-30'),
('Bright Ideas', 'Innovative energy solutions', 'Evan Green', 'Gold', 'http://brightideas.com/logo.png', '2023-05-01', '2023-08-31'),
('NextGen', 'AI and machine learning', 'Fiona Blue', 'Silver', 'http://nextgen.com/logo.png', '2023-06-01', '2023-07-31'),
('Clean Earth', 'Sustainable products', 'George Black', 'Bronze', 'http://cleanearth.com/logo.png', '2023-07-01', '2023-12-31'),
('Innovators Inc.', 'Consultancy in R&D', 'Helen Brown', 'Silver', 'http://innovatorsinc.com/logo.png', '2023-08-01', '2023-10-31'),
('Eco Tech', 'Green tech for a better future', 'Ian Pink', 'Gold', 'http://ecotech.com/logo.png', '2023-09-01', '2023-11-30'),
('Blue Sky', 'Renewable energy solutions', 'Jake Silver', 'Bronze', 'http://bluesky.com/logo.png', '2023-10-01', '2023-12-31');

INSERT INTO Exhibition (exhibition_name, location_name, start_time, end_time, description, max_capacity, registration_deadline)
VALUES 
('Tech Expo 2023', 'Main Hall', '2023-06-01 09:00', '2023-06-01 17:00', 'Annual technology exhibition', 500, '2023-05-15 23:59'),
('Eco Fair 2023', 'Green Hall', '2023-07-01 10:00', '2023-07-01 18:00', 'Eco-friendly products fair', 300, '2023-06-15 23:59'),
('Innovation Summit', 'Convention Center', '2023-08-01 09:00', '2023-08-01 19:00', 'R&D summit for innovators', 400, '2023-07-15 23:59'),
('Smart Tech Fest', 'Tech Hall', '2023-09-01 08:00', '2023-09-01 16:00', 'Smart tech devices exhibition', 600, '2023-08-15 23:59'),
('Energy Fair', 'Energy Hall', '2023-10-01 10:00', '2023-10-01 18:00', 'Renewable energy solutions', 450, '2023-09-15 23:59'),
('AI & ML Conference', 'AI Hall', '2023-11-01 09:00', '2023-11-01 17:00', 'AI and ML innovation conference', 500, '2023-10-15 23:59'),
('Green Innovations', 'Green Hall', '2023-12-01 10:00', '2023-12-01 18:00', 'Green tech expo', 350, '2023-11-15 23:59'),
('Startup Fest', 'Startup Hall', '2023-06-15 09:00', '2023-06-15 17:00', 'Startup showcase', 200, '2023-05-31 23:59'),
('Renewable Expo', 'Eco Hall', '2023-07-15 10:00', '2023-07-15 18:00', 'Renewable energy expo', 300, '2023-06-30 23:59'),
('Digital Future', 'Digital Hall', '2023-08-15 09:00', '2023-08-15 17:00', 'Exploring the future of digital tech', 400, '2023-07-31 23:59');

INSERT INTO Contract (sponsor_id, exhibition_id, contract_start_date, contract_end_date)
VALUES 
(1, 1, '2023-01-01', '2023-12-31'),
(2, 2, '2023-02-01', '2023-11-30'),
(3, 3, '2023-03-01', '2023-10-31'),
(4, 4, '2023-04-01', '2023-09-30'),
(5, 5, '2023-05-01', '2023-08-31'),
(6, 6, '2023-06-01', '2023-07-31'),
(7, 7, '2023-07-01', '2023-12-31'),
(8, 8, '2023-08-01', '2023-10-31'),
(9, 9, '2023-09-01', '2023-11-30'),
(10, 10, '2023-10-01', '2023-12-31');

INSERT INTO Customer (customer_email, registration_date, customer_name, customer_age, selected_genres)
VALUES 
('alice@example.com', '2023-01-01', 'Alice Brown', 30, 'Technology, AI'),
('bob@example.com', '2023-01-02', 'Bob Green', 25, 'Environment, Renewable'),
('chris@example.com', '2023-01-03', 'Chris White', 35, 'Innovation, Startups'),
('diane@example.com', '2023-01-04', 'Diane Black', 28, 'Technology, Smart Devices'),
('evan@example.com', '2023-01-05', 'Evan Grey', 32, 'Energy, Green Tech'),
('fiona@example.com', '2023-01-06', 'Fiona Blue', 27, 'AI, Machine Learning'),
('george@example.com', '2023-01-07', 'George Red', 29, 'Eco-friendly, Renewable'),
('helen@example.com', '2023-01-08', 'Helen Yellow', 26, 'R&D, Consultancy'),
('ian@example.com', '2023-01-09', 'Ian Pink', 31, 'Green Tech, Digital'),
('jake@example.com', '2023-01-10', 'Jake Violet', 33, 'Renewable, Sustainability');

INSERT INTO [Order] (customer_id, order_amount, billing_address, order_date, order_status, discount_applied)
VALUES 
(1, 100.00, '123 Main St', '2023-02-01', 'Completed', 10),
(2, 150.00, '456 Oak Ave', '2023-02-15', 'Pending', 5),
(3, 200.00, '789 Pine Rd', '2023-02-20', 'Completed', 15),
(4, 250.00, '101 Maple St', '2023-03-01', 'Completed', 20),
(5, 300.00, '202 Birch Rd', '2023-03-10', 'Pending', 10),
(6, 175.00, '303 Cedar Ln', '2023-03-15', 'Completed', 5),
(7, 225.00, '404 Walnut Dr', '2023-03-20', 'Cancelled', 0),
(8, 275.00, '505 Spruce St', '2023-04-01', 'Completed', 12),
(9, 325.00, '606 Elm St', '2023-04-10', 'Pending', 8),
(10, 350.00, '707 Fir Ave', '2023-04-15', 'Completed', 20);

INSERT INTO Tickets (exhibition_id, order_id, ticket_type, ticket_price, sale_start_date, sale_end_date, qr_code, max_tickets_per_order, refund_policy)
VALUES 
(1, 1, 'Super-fan', 75.00, '2023-01-01', '2023-05-31', 'QR12345', 5, 'Non-refundable'),
(2, 2, 'Single Day', 50.00, '2023-01-15', '2023-06-30', 'QR67890', 4, 'Refundable within 7 days'),
(3, 3, 'Double Day', 90.00, '2023-02-01', '2023-07-31', 'QR11223', 3, 'Non-refundable'),
(4, 4, 'Super-fan', 80.00, '2023-02-15', '2023-06-15', 'QR44556', 5, 'Non-refundable'),
(5, 5, 'Single Day', 55.00, '2023-03-01', '2023-07-01', 'QR77889', 4, 'Refundable within 5 days'),
(6, 6, 'Double Day', 95.00, '2023-03-10', '2023-08-15', 'QR99001', 3, 'Non-refundable'),
(7, 7, 'Super-fan', 85.00, '2023-04-01', '2023-09-01', 'QR22334', 5, 'Refundable within 3 days'),
(8, 8, 'Single Day', 60.00, '2023-04-15', '2023-09-30', 'QR55667', 4, 'Non-refundable'),
(9, 9, 'Double Day', 100.00, '2023-05-01', '2023-10-01', 'QR88900', 3, 'Refundable within 7 days'),
(10, 10, 'Super-fan', 70.00, '2023-05-15', '2023-10-31', 'QR00123', 5, 'Non-refundable');

INSERT INTO Exhibition_Game (game_name, game_publisher, game_type, description, age_rating, booth_location)
VALUES 
('Game A', 'Publisher A', 'Action', 'High-intensity action game', 'E', 'Booth 101'),
('Game B', 'Publisher B', 'Adventure', 'Exciting adventure for all ages', 'E10+', 'Booth 102'),
('Game C', 'Publisher C', 'Puzzle', 'Challenging puzzles and brain teasers', 'T', 'Booth 103'),
('Game D', 'Publisher D', 'RPG', 'Role-playing game with fantasy elements', 'M', 'Booth 104'),
('Game E', 'Publisher E', 'Simulation', 'Life simulation game', 'E', 'Booth 105'),
('Game F', 'Publisher F', 'Strategy', 'Strategic gameplay with resource management', 'T', 'Booth 106'),
('Game G', 'Publisher G', 'Sports', 'Realistic sports simulation', 'E', 'Booth 107'),
('Game H', 'Publisher H', 'Racing', 'High-speed racing game', 'E10+', 'Booth 108'),
('Game I', 'Publisher I', 'Horror', 'Horror game with scary elements', 'M', 'Booth 109'),
('Game J', 'Publisher J', 'Platformer', 'Classic platformer game', 'E', 'Booth 110');

INSERT INTO Stall (exhibition_id, game_id, section_number, stall_description, no_of_employees, size_sqft, stall_location, rental_cost, equipment_provided)
VALUES 
(1, 1, 101, 'Main stall for Game A', 3, 150.00, 'Location A1', 200.00, 'Projector, Sound System'),
(2, 2, 102, 'Main stall for Game B', 4, 200.00, 'Location B2', 250.00, 'VR Headsets, Gaming Consoles'),
(3, 3, 103, 'Main stall for Game C', 2, 100.00, 'Location C3', 150.00, 'LCD Screens, Demo Setup'),
(4, 4, 104, 'Main stall for Game D', 5, 250.00, 'Location D4', 300.00, 'Sound System, Lighting'),
(5, 5, 105, 'Main stall for Game E', 3, 120.00, 'Location E5', 180.00, 'Computers, Consoles'),
(6, 6, 106, 'Main stall for Game F', 4, 220.00, 'Location F6', 270.00, 'Projection Screen, Consoles'),
(7, 7, 107, 'Main stall for Game G', 3, 130.00, 'Location G7', 190.00, 'Sound System, VR Setup'),
(8, 8, 108, 'Main stall for Game H', 4, 210.00, 'Location H8', 260.00, 'Gaming Consoles, Lighting'),
(9, 9, 109, 'Main stall for Game I', 2, 110.00, 'Location I9', 160.00, 'Consoles, Projector'),
(10, 10, 110, 'Main stall for Game J', 3, 140.00, 'Location J10', 230.00, 'LCD Screens, Consoles');

INSERT INTO Staff (staff_name, phone_no, joining_date, shift_schedule, salary, emergency_contact, position)
VALUES 
('John Doe', '123-456-7890', '2023-01-01', 'Day Shift', 50000.00, 'Emily Doe', 'Manager'),
('Jane Smith', '234-567-8901', '2023-02-01', 'Night Shift', 45000.00, 'Michael Smith', 'Assistant Manager'),
('Robert Brown', '345-678-9012', '2023-03-01', 'Day Shift', 40000.00, 'Sarah Brown', 'Technician'),
('Linda White', '456-789-0123', '2023-04-01', 'Night Shift', 42000.00, 'Paul White', 'Technician'),
('Michael Green', '567-890-1234', '2023-05-01', 'Day Shift', 46000.00, 'Susan Green', 'Supervisor'),
('Emily Black', '678-901-2345', '2023-06-01', 'Night Shift', 48000.00, 'David Black', 'Supervisor'),
('David Gray', '789-012-3456', '2023-07-01', 'Day Shift', 44000.00, 'Alice Gray', 'Technician'),
('Laura Blue', '890-123-4567', '2023-08-01', 'Night Shift', 43000.00, 'Tom Blue', 'Assistant Manager'),
('Peter Red', '901-234-5678', '2023-09-01', 'Day Shift', 47000.00, 'Nancy Red', 'Supervisor'),
('Nancy Yellow', '012-345-6789', '2023-10-01', 'Night Shift', 45000.00, 'Kevin Yellow', 'Technician');

INSERT INTO Stall_Staff (stall_id, staff_id, assignment_start_date, assignment_end_date)
VALUES 
(1, 1, '2023-06-01', '2023-06-30'),
(2, 2, '2023-07-01', '2023-07-31'),
(3, 3, '2023-08-01', '2023-08-31'),
(4, 4, '2023-09-01', '2023-09-30'),
(5, 5, '2023-10-01', '2023-10-31'),
(6, 6, '2023-11-01', '2023-11-30'),
(7, 7, '2023-12-01', '2023-12-31'),
(8, 8, '2024-01-01', '2024-01-31'),
(9, 9, '2024-02-01', '2024-02-28'),
(10, 10, '2024-03-01', '2024-03-31');

INSERT INTO Show (exhibition_id, schedule, show_description, duration, age_restriction, capacity)
VALUES 
(1, '2023-06-01 10:00', 'Technology Innovations Showcase', 120, 'E', 300),
(2, '2023-07-01 11:00', 'Eco-friendly Products Display', 90, 'E10+', 250),
(3, '2023-08-01 13:00', 'Innovative Startups Panel', 150, 'T', 200),
(4, '2023-09-01 15:00', 'Smart Tech Products', 100, 'E', 350),
(5, '2023-10-01 10:30', 'Renewable Energy Solutions', 110, 'E', 400),
(6, '2023-11-01 14:00', 'AI & Machine Learning Discussion', 130, 'T', 450),
(7, '2023-12-01 12:00', 'Green Innovations for the Future', 140, 'E10+', 320),
(8, '2024-01-01 11:30', 'Startup Showcase', 90, 'E', 200),
(9, '2024-02-01 10:00', 'Renewable Expo Talks', 100, 'E10+', 270),
(10, '2024-03-01 13:30', 'Digital Future Conference', 150, 'T', 350);

INSERT INTO Performer (name, contact_info_phone_no, contact_info_email, performance_type, duration, social_media_handles)
VALUES 
('Alice Johnson', '123-456-7890', 'alice.j@example.com', 'Singer', 45, '@alicejohnson'),
('Bob Smith', '234-567-8901', 'bob.smith@example.com', 'Comedian', 30, '@bobsmith'),
('Catherine Lee', '345-678-9012', 'catherine.lee@example.com', 'Magician', 60, '@catherinelee'),
('David Brown', '456-789-0123', 'david.brown@example.com', 'Dancer', 50, '@davidbrown'),
('Emily White', '567-890-1234', 'emily.white@example.com', 'Speaker', 40, '@emilywhite'),
('Frank Green', '678-901-2345', 'frank.green@example.com', 'Pianist', 45, '@frankgreen'),
('Grace Black', '789-012-3456', 'grace.black@example.com', 'Violinist', 35, '@graceblack'),
('Henry Blue', '890-123-4567', 'henry.blue@example.com', 'Guitarist', 55, '@henryblue'),
('Isabel Yellow', '901-234-5678', 'isabel.yellow@example.com', 'Stand-up Comedian', 25, '@isabelyellow'),
('Jack Red', '012-345-6789', 'jack.red@example.com', 'Poet', 20, '@jackred');

INSERT INTO Live_Show (performer_id, equipment_needs)
VALUES 
(1, 'Microphone, Sound System'),
(2, 'Stage Lighting, Microphone'),
(3, 'Magic Props, Lighting'),
(4, 'Sound System, Stage Space'),
(5, 'Podium, Projector');

INSERT INTO Virtual_Show (performer_id, virtual_platform, internet_needs)
VALUES 
(6, 'Zoom', 'High-speed Internet, HD Webcam'),
(7, 'Microsoft Teams', 'Reliable Internet, High-quality Microphone'),
(8, 'Google Meet', 'High-speed Internet, HD Webcam'),
(9, 'Skype', 'Stable Connection, Good Lighting'),
(10, 'Webex', 'High-quality Camera, Reliable Internet');

INSERT INTO Show_Performer (show_id, performer_id, performance_time, performance_role)
VALUES 
(1, 1, '2023-06-01 10:00', 'Lead Singer'),
(2, 2, '2023-07-01 11:00', 'Stand-up Comedian'),
(3, 3, '2023-08-01 13:00', 'Magician'),
(4, 4, '2023-09-01 15:00', 'Lead Dancer'),
(5, 5, '2023-10-01 10:30', 'Keynote Speaker'),
(6, 6, '2023-11-01 14:00', 'Pianist'),
(7, 7, '2023-12-01 12:00', 'Violinist'),
(8, 8, '2024-01-01 11:30', 'Guitarist'),
(9, 9, '2024-02-01 10:00', 'Comedian'),
(10, 10, '2024-03-01 13:30', 'Poet');

-- Select all records from each table
SELECT * FROM Sponsor;
SELECT * FROM Exhibition;
SELECT * FROM Contract;
SELECT * FROM Customer;
SELECT * FROM [Order];
SELECT * FROM Tickets;
SELECT * FROM Exhibition_Game;
SELECT * FROM Stall;
SELECT * FROM Staff;
SELECT * FROM Stall_Staff;
SELECT * FROM Show;
SELECT * FROM Performer;
SELECT * FROM Live_Show;
SELECT * FROM Virtual_Show;
SELECT * FROM Show_Performer;
