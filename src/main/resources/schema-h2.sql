DROP TABLE IF EXISTS BEER;
CREATE TABLE BEER(
BEERNAME VARCHAR2,
BEERSTYLE VARCHAR2,
UPC INTEGER,
PRICE INTEGER,
MIN_ON_HAND INTEGER,
ID INTEGER,
CREATED_DATE DATE,
LAST_MODIFIED_DATE DATE,
VERSION VARCHAR2,

PRIMARY KEY (ID)
);