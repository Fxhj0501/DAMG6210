CREATE DATABASE DDMDProject;
GO

USE DDMDProject;
GO

-- Drop existing tables to make the script re-runnable
DROP TABLE IF EXISTS Show_Performer;
DROP TABLE IF EXISTS Virtual_Show;
DROP TABLE IF EXISTS Live_Show;
DROP TABLE IF EXISTS Performer;
DROP TABLE IF EXISTS Show;
DROP TABLE IF EXISTS Exhibition_Game;
DROP TABLE IF EXISTS Stall_Staff;
DROP TABLE IF EXISTS Stall;
DROP TABLE IF EXISTS Staff;
DROP TABLE IF EXISTS Tickets;
DROP TABLE IF EXISTS [Order];
DROP TABLE IF EXISTS Customer;
DROP TABLE IF EXISTS Contract;
DROP TABLE IF EXISTS Exhibition;
DROP TABLE IF EXISTS Sponsor;

-- Sponsor table
CREATE TABLE Sponsor (
     sponsor_id INT PRIMARY KEY IDENTITY(1,1),
     sponsor_name NVARCHAR(100) NOT NULL,
     description NVARCHAR(255),
     contact_person NVARCHAR(100),
     sponsorship_level NVARCHAR(50),
     logo_url NVARCHAR(255),
     contract_start_date DATE,
     contract_end_date DATE,
     CONSTRAINT chk_sponsor_description_length CHECK (LEN(description) <= 255)
);

-- Exhibition table
CREATE TABLE Exhibition (
    exhibition_id INT PRIMARY KEY IDENTITY(1,1),
    exhibition_name NVARCHAR(100) NOT NULL,
    location_name NVARCHAR(100) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL,
    description NVARCHAR(255),
    max_capacity INT CHECK (max_capacity > 0),
    registration_deadline DATETIME NOT NULL,
    CONSTRAINT chk_exhibition_end_after_start CHECK (end_time > start_time)
);

-- Contract table
CREATE TABLE Contract (
      sponsor_id INT NOT NULL,
      exhibition_id INT NOT NULL,
      contract_start_date DATE,
      contract_end_date DATE,
      PRIMARY KEY (sponsor_id, exhibition_id),
      FOREIGN KEY (sponsor_id) REFERENCES Sponsor(sponsor_id),
      FOREIGN KEY (exhibition_id) REFERENCES Exhibition(exhibition_id),
      CONSTRAINT chk_contract_end_after_start CHECK (contract_end_date >= contract_start_date)
);

-- Customer table
CREATE TABLE Customer (
      customer_id INT PRIMARY KEY IDENTITY(1,1),
      customer_email NVARCHAR(100) UNIQUE,
      registration_date DATE,
      customer_name NVARCHAR(100),
      customer_age INT CHECK (customer_age >= 0),
      selected_genres NVARCHAR(255)
);

-- Order table
CREATE TABLE [Order] (
     order_id INT IDENTITY(1,1) PRIMARY KEY,
     customer_id INT NOT NULL,
     order_amount DECIMAL(10, 2) CHECK (order_amount >= 0),
     billing_address NVARCHAR(255),
     order_date DATE,
     order_status NVARCHAR(50),
     discount_applied DECIMAL(5, 2) CHECK (discount_applied >= 0 AND discount_applied <= 100),
     FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

-- Tickets table
CREATE TABLE Tickets (
     ticket_id INT PRIMARY KEY IDENTITY(1,1),
     exhibition_id INT NOT NULL,
     order_id INT NOT NULL,
     ticket_type NVARCHAR(50) CHECK (ticket_type IN ('Super-fan', 'Single Day', 'Double Day')),
     ticket_price DECIMAL(10, 2) CHECK (ticket_price >= 0),
     sale_start_date DATE,
     sale_end_date DATE,
     qr_code NVARCHAR(255),
     max_tickets_per_order INT CHECK (max_tickets_per_order > 0),
     refund_policy NVARCHAR(255),
     FOREIGN KEY (exhibition_id) REFERENCES Exhibition(exhibition_id),
     FOREIGN KEY (order_id) REFERENCES [Order](order_id),
     CONSTRAINT chk_ticket_sale_end_after_start CHECK (sale_end_date >= sale_start_date)
);

-- Exhibition_Game table
CREATE TABLE Exhibition_Game (
     game_id INT PRIMARY KEY IDENTITY(1,1),
     game_name NVARCHAR(100) NOT NULL,
     game_publisher NVARCHAR(100),
     game_type NVARCHAR(50),
     description NVARCHAR(255),
     age_rating NVARCHAR(10),
     booth_location NVARCHAR(100)
);

-- Stall table with game_id as FK
CREATE TABLE Stall (
   stall_id INT PRIMARY KEY IDENTITY(1,1),
   exhibition_id INT NOT NULL,
   game_id INT NOT NULL,
   section_number INT,
   stall_description NVARCHAR(255),
   no_of_employees INT CHECK (no_of_employees >= 0),
   size_sqft DECIMAL(10, 2) CHECK (size_sqft > 0),
   stall_location NVARCHAR(100),
   rental_cost DECIMAL(10, 2),
   equipment_provided NVARCHAR(255),
   FOREIGN KEY (exhibition_id) REFERENCES Exhibition(exhibition_id),
   FOREIGN KEY (game_id) REFERENCES Exhibition_Game(game_id)
);

-- Staff table
CREATE TABLE Staff (
   staff_id INT PRIMARY KEY IDENTITY(1,1),
   staff_name NVARCHAR(100) NOT NULL,
   phone_no NVARCHAR(15),
   joining_date DATE,
   shift_schedule NVARCHAR(50),
   salary DECIMAL(10, 2) CHECK (salary >= 0),
   emergency_contact NVARCHAR(100),
   position NVARCHAR(50)
);

-- Stall_Staff table
CREATE TABLE Stall_Staff (
    stall_id INT NOT NULL,
    staff_id INT NOT NULL,
    assignment_start_date DATE,
    assignment_end_date DATE,
    PRIMARY KEY (stall_id, staff_id),
    FOREIGN KEY (stall_id) REFERENCES Stall(stall_id),
    FOREIGN KEY (staff_id) REFERENCES Staff(staff_id)
);

-- Show table
CREATE TABLE Show (
  show_id INT PRIMARY KEY IDENTITY(1,1),
  exhibition_id INT NOT NULL,
  schedule DATETIME,
  show_description NVARCHAR(255),
  duration INT CHECK (duration > 0),
  age_restriction NVARCHAR(10),
  capacity INT CHECK (capacity > 0),
  FOREIGN KEY (exhibition_id) REFERENCES Exhibition(exhibition_id)
);

-- Performer table
CREATE TABLE Performer (
   performer_id INT PRIMARY KEY IDENTITY(1,1),
   name NVARCHAR(100) NOT NULL,
   contact_info_phone_no NVARCHAR(15),
   contact_info_email NVARCHAR(100),
   performance_type NVARCHAR(50),
   duration INT CHECK (duration > 0),
   social_media_handles NVARCHAR(255)
);

-- Live_Show table
CREATE TABLE Live_Show (
   performer_id INT PRIMARY KEY,
   equipment_needs NVARCHAR(255),
   FOREIGN KEY (performer_id) REFERENCES Performer(performer_id)
);

-- Virtual_Show table
CREATE TABLE Virtual_Show (
    performer_id INT PRIMARY KEY,
    virtual_platform NVARCHAR(100),
    internet_needs NVARCHAR(255),
    FOREIGN KEY (performer_id) REFERENCES Performer(performer_id)
);

-- Show_Performer table
CREATE TABLE Show_Performer (
    show_id INT NOT NULL,
    performer_id INT NOT NULL,
    performance_time DATETIME,
    performance_role NVARCHAR(50),
    PRIMARY KEY (show_id, performer_id),
    FOREIGN KEY (show_id) REFERENCES Show(show_id),
    FOREIGN KEY (performer_id) REFERENCES Performer(performer_id)
);

