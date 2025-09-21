--liquibase formatted sql

--changeset ai:1 labels:users
CREATE TABLE users (
                       id              BIGSERIAL PRIMARY KEY,
                       username        VARCHAR(50) NOT NULL UNIQUE,
                       email           VARCHAR(100) NOT NULL UNIQUE,
                       password        VARCHAR(255) NOT NULL,
                       first_name      VARCHAR(50),
                       last_name       VARCHAR(50),
                       phone_number    VARCHAR(20),
                       role            VARCHAR(20) NOT NULL DEFAULT 'CUSTOMER',
                       is_active       BOOLEAN NOT NULL DEFAULT true,
                       created_at      TIMESTAMP NOT NULL DEFAULT NOW(),
                       updated_at      TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_role ON users(role);

--rollback DROP TABLE users;

--changeset ai:2 labels:users
INSERT INTO users (username, email, password, first_name, last_name, role) VALUES
                                                                               ('admin', 'admin@ecommerce.com', '$2a$12$LQv3c1yqBWVHxkd0LHAkCOYz6TtxMQJqyPKnfBXq7SyPmLHSojsKG', 'Admin', 'User', 'ADMIN'),
                                                                               ('johndoe', 'john.doe@example.com', '$2a$12$LQv3c1yqBWVHxkd0LHAkCOYz6TtxMQJqyPKnfBXq7SyPmLHSojsKG', 'John', 'Doe', 'CUSTOMER');

--rollback DELETE FROM users WHERE username IN ('admin', 'johndoe');
