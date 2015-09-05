create table USER(
    ID VARCHAR(32) PRIMARY KEY,
    NAME VARCHAR(20) NOT NULL,
    PASSWORD VARCHAR(128)  NOT NULL,
    USER_TYPE VARCHAR(20)  NOT NULL,
    CREATION_TIME TIMESTAMP
);

create table EXPENSES (
    ID VARCHAR(32) PRIMARY KEY,
    AMOUNT BIGINT,
    CURRENCY VARCHAR(3)  NOT NULL,
    DESCRIPTION VARCHAR(50)  NOT NULL,
    CREATION_TIME TIMESTAMP,
    OWNER_ID VARCHAR(32)  NOT NULL,
    COMMENT VARCHAR(50)  NOT NULL
);

ALTER TABLE EXPENSES ADD FOREIGN KEY (OWNER_ID) REFERENCES USER(ID);