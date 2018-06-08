INSERT INTO ADDRESS (ID, CITY, STATE, COUNTRY, ZIP_CODE)
VALUES (-1, 'Chicago', 'Illinois', 'US', '60007');

INSERT INTO ADDRESS (ID, CITY, STATE, COUNTRY, ZIP_CODE)
VALUES (-2, 'Dallas', 'Texas', 'US', '75001');

INSERT INTO PERSON (ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS_ID, PHONE, ENABLED)
VALUES (-1, 'Admin', 'Admin', 'admin@mum.edu', -1, '+18567189399', 1);

INSERT INTO PERSON (ID, FIRST_NAME, LAST_NAME, EMAIL, ADDRESS_ID, PHONE, ENABLED)
VALUES (-2, 'Customer', 'Customer1', 'customer@mum.edu', -2, '+15179189395', 1);

INSERT INTO ROLE(ID, ROLE) VALUES(-1, 'ROLE_ADMIN');

INSERT INTO ROLE(ID, ROLE) VALUES(-2, 'ROLE_CUSTOMER');


