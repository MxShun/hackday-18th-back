CREATE TABLE IF NOT EXISTS kitteless.user
(
    id       VARCHAR(5) PRIMARY KEY NOT NULL,
    name     VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS kitteless.payment
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    userId   VARCHAR(30) NOT NULL,
    amount   INT NOT NULL
);
