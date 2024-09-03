CREATE TABLE users
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    login     VARCHAR(255)                            NOT NULL,
    pass_word VARCHAR(255)                            NOT NULL,
    roles     VARCHAR(255),
    CONSTRAINT pk_users PRIMARY KEY (id)
);