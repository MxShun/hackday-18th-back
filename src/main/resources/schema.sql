CREATE TABLE IF NOT EXISTS kitteless.user
(
    id       VARCHAR(5) PRIMARY KEY NOT NULL,
    name     VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS kitteless.payment
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    user_id   VARCHAR(5) NOT NULL,
    amount   INT NOT NULL,
    stamp_code VARCHAR(9),
    date_time DATE
);

CREATE TABLE IF NOT EXISTS kitteless.postal_charge
(
    id       INT PRIMARY KEY NOT NULL,
    amount   INT NOT NULL,
    standard VARCHAR(30)
);
