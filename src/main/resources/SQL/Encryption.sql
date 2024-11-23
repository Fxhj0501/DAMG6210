Use DDMDProject;

Create SYMMETRIC KEY encryptKey WITH ALGORITHM = AES_256
ENCRYPTION BY PASSWORD = 'DAMGGroup20';

OPEN SYMMETRIC KEY encryptKey DECRYPTION BY PASSWORD = 'DAMGGroup20';

UPDATE Customer set customer_email = EncryptByKey(Key_GUID('encryptKey'), customer_email);

-- relative use can watch the customer mapper and /resources/SQL/init.sql

