# MagicTrade_back
MagicTrade

MagicTrade is an application designed for Magic: The Gathering players, allowing them to manage their personal card collections and easily trade cards with other users. The platform is secured using Spring Security and JWT to ensure safe authentication and data protection. The project is built following Clean Architecture principles to provide a clear separation of concerns, improved maintainability, and scalable design.

🚀 Features

📚 Card Collection Management
Add, update, delete, and view cards in your personal Magic: The Gathering collection.

🔄 User-to-User Trades
Propose, accept, or decline trades with other players.

🔐 Secure Authentication
Powered by Spring Security and JWT tokens for reliable and safe access control.

🧱 Clean Architecture
Structured around use cases, entities, controllers, and repositories for maintainability and testability.

🏛️ Architecture Overview

MagicTrade follows Clean Architecture, divided into several layers:

Domain – Entities and business rules

Use Cases – Application-specific logic, independent of frameworks

Infrastructure – Data persistence, external APIs, configuration

Adapters – Controllers, repository implementations, API interfaces

Application – Dependency injection and bootstrapping

This structure ensures:

Low coupling

High testability

Clear separation of concerns

Easy scalability

🛡️ Security

MagicTrade uses:

Spring Security for authentication and authorization

JWT (JSON Web Tokens) for stateless, scalable session management

Each protected endpoint requires a valid token, ensuring users' data and interactions remain secure.

🛠️ Tech Stack

Java / Spring Boot

Spring Security + JWT

Clean Architecture principles

Maven 

Database: MySql

📦 Installation & Setup
Prerequisites

Java 17+

Maven 

Clone the repository
git clone https://github.com/your-username/magictrade.git
cd magictrade

Run the application
./mvnw spring-boot:run

🔧 Configuration

Update your application properties (e.g., application.yml) with your database and JWT settings:

jwt:
  secret: your-secret-key
  expiration: 3600000
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/magictrade
    username: user
    password: pass
