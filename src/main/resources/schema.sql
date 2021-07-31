CREATE TABLE IF NOT EXISTS kitteless.user
(
    id       VARCHAR(5) PRIMARY KEY NOT NULL,
    name     VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL
);
