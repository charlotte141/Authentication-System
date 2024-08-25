CREATE SEQUENCE user_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE "user"
(
    id       BIGINT       NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    roles    SMALLINT     NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);