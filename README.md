# 🛒 Online Grocery Backend

A Spring Boot-based backend application for an online grocery ordering system. It allows customers to browse groceries, place orders, and manage user information.

---

## ✅ Features

- Customer CRUD operations
- Grocery item CRUD operations
- Place and fetch orders
- Model mapping with DTOs using ModelMapper
- JPA/Hibernate integration with MySQL
- Error handling with global exception handler
- Docker support

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- ModelMapper
- Docker
- JUnit + Mockito (for testing)

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/Online-Grocery.git](https://github.com/shyamcoder1123/Online-Grocery.git)
cd Online-Grocery
```

### 2. Set up MySQL using Docker (Recommended)
```bash
docker run --name mysql-grocery \
  -e MYSQL_ROOT_PASSWORD=root123 \
  -e MYSQL_DATABASE=onlinegrocery \
  -p 3307:3306 \
  -d mysql:8.0
```
This runs MySQL 8 in a container with:

Username: root

Password: root123

Database: onlinegrocery

### 3. Configure the application
Update src/main/resources/application.properties:

```properties

spring.datasource.url=jdbc:mysql://localhost:3306/onlinegrocery
spring.datasource.username=root
spring.datasource.password=root123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=8080
```
### 4. Build the application
```bash

./gradlew clean build
```
### 5. Run the application
```bash

./gradlew bootRun
```
Visit the app at: http://localhost:8080
