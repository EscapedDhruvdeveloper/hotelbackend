-- Initialize hotel_db database
CREATE DATABASE IF NOT EXISTS hotel_db;
USE hotel_db;

-- Grant privileges to the application user
GRANT ALL PRIVILEGES ON hotel_db.* TO 'hotel_user'@'%';
FLUSH PRIVILEGES;