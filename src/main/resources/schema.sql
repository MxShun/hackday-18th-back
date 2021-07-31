CREATE TABLE IF NOT EXISTS kitteless.user
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL
);
