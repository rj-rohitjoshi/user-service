# User Service

Standalone Spring Boot microservice for user management and JWT authentication with PostgreSQL and Liquibase.

## Build and Run

mvn clean package
mvn spring-boot:run

or
docker build -t user-service .
docker run -p 8085:8085 user-service


## Features

- User registration and management
- JWT authentication and authorization
- Password encryption with BCrypt
- Role-based access control
- Liquibase database migrations
- Spring Security integration

## REST API

### Authentication
- `POST /auth/register` - register new user
- `POST /auth/login` - user login
- `POST /auth/logout` - user logout

### User Management
- `POST /users/register` - register user (public)
- `GET /users/{id}` - get user by ID
- `GET /users/username/{username}` - get user by username
- `GET /users` - list all users (admin only)
- `GET /users/active` - list active users (admin only)
- `PUT /users/{id}` - update user
- `DELETE /users/{id}` - delete user (admin only)
- `PATCH /users/{id}/deactivate` - deactivate user (admin only)

## Authentication

Include JWT token in requests:
Authorization: Bearer <token>


## Test

mvn test

Uses H2 for tests and Spring Security Test for authentication testing.

---

