# Furniture Drawing Application Backend

This project is a Spring Boot microservices backend for the furniture drawing application.

## Technologies

- Java 17
- Spring Boot 3.4.0
- Spring Security
- Spring Data JPA
- PostgreSQL
- Spring Modulith

## Project Structure

The project consists of two main microservices:

1. **Authentication Service**: Manages user authentication and authorization processes.
2. **Main App**: Contains the core application logic.

## Requirements

- Java 17 or higher
- Maven
- PostgreSQL

## Installation

1. Clone the project:
```bash
git clone https://github.com/Furniture-Draw/furniture-draw-backend
```

2. Set up PostgreSQL database and configure connection settings.

3. Build the project:
```bash
mvn clean install
```

4. Start the services:
```bash
# For Authentication Service
cd authentication-service
mvn spring-boot:run

# For Main App
cd main-app
mvn spring-boot:run
```

## License

This project is proprietary software. All rights reserved. Unauthorized copying, modification, distribution, or use of this software, via any medium, is strictly prohibited. 