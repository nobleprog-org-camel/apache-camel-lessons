DROP TABLE TRADE IF EXISTS;
CREATE TABLE TRADE
(
ID NUMBER(10),
ORDER_ID VARCHAR2(10),
QUANTITY  NUMBER(10),
BUY_SELL VARCHAR2(10),
TRADE_DATE DATE
);