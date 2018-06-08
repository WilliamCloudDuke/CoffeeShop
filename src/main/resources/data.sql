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

INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE, PRODUCT_TYPE) VALUES (-1, 'ESPRESSO (Short Black)', 'The espresso (aka “short black”) is the foundation and the most important part to every espresso based drink', '10.00', 'BREAKFAST');

INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE, PRODUCT_TYPE) VALUES (-2, 'DOUBLE ESPRESSO (Doppio)', 'A double espresso (aka “Doppio”) is just that, two espresso shots in one cup. Therefore a double espresso consists of 2 shots of espresso in an espresso cup', '12.00', 'BREAKFAST');

INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE, PRODUCT_TYPE) VALUES (-3, 'SHORT MACCHIATO', 'A short macchiato is similar to an espresso but with a dollop of steamed milk and foam to mellow the harsh taste of an espresso.', '14.00', 'BREAKFAST');

INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE, PRODUCT_TYPE) VALUES (-4, 'LONG MACHIATO', 'A long macchiato is the same as a short macchiato but with a double shot of espresso. The same rule of thirds applies in the traditionally made long macchiato', '16.00', 'LUNCH');

INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE, PRODUCT_TYPE) VALUES (-5, 'RISTRETTO', 'A ristretto is an espresso shot that is extracted with the same amount of coffee but half the amount of water. The end result is a more concentrated and darker espresso extraction', '18.00', 'LUNCH');

INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE, PRODUCT_TYPE) VALUES (-6, 'LONG BLACK (Americano)', 'A long black (aka “americano”) is hot water with an espresso shot extracted on top of the hot water. It is made as follows', '20.00', 'LUNCH');

INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE, PRODUCT_TYPE) VALUES (-7, 'CAFE LATTE', 'A café latte, or “latte” for short, is an espresso based drink with steamed milk and micro-foam added to the coffee. This coffee is much sweeter compared to an espresso', '22.00', 'DINNER');

INSERT INTO PRODUCT(ID, NAME, DESCRIPTION, PRICE, PRODUCT_TYPE) VALUES (-8, 'CAPUCCINO', 'A cappuccino is similar to a latte. However the key difference between a latte and cappuccino is that a cappuccino has more foam and chocolate placed on top of the drink', '24.00', 'DINNER');



