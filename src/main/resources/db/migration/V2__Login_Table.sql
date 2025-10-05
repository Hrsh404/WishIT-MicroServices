CREATE TABLE UserLogin (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255),
    loginFlag varchar(255)NOT NULL,
    created_at TIMESTAMP DEFAULT now()
);