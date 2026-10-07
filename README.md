# SmartCart - E-Commerce Microservices Platform

SmartCart is a backend-focused e-commerce platform built using a microservices architecture.

## Technology Stack

- Java 21
- Spring Boot 4.1.1
- Spring Cloud 2025.1.3
- Spring Cloud Gateway
- Netflix Eureka
- MySQL 8.0.42
- Apache Kafka
- Maven
- AWS

## Services

| Service | Port | Purpose |
|---|---:|---|
| service-discovery | 8761 | Eureka service registry |
| api-gateway | 8080 | Central API gateway |
| product-service | 8081 | Product management |
| user-service | 8082 | User management |
| order-service | 8083 | Order processing |
| payment-service | 8084 | Payment event processing |
| notification-service | 8085 | Notification event processing |

## Architecture

Client -> API Gateway -> Eureka-discovered Microservices

Order flow:

Order Service -> Kafka (order-created) -> Payment Service -> Kafka (payment-completed) -> Notification Service

## Databases

- smartcart_product_db
- smartcart_user_db
- smartcart_order_db

## Running the Services

Start Eureka first, followed by API Gateway and the individual microservices.

MySQL must be running locally for the services that use persistence.

Kafka is configured for localhost:9092 for the event-driven services.

## Project Status

The Eureka service registry, API Gateway, Product Service, User Service, Order Service, Payment Service, and Notification Service are implemented.

The local validation completed successfully for the core Eureka, gateway, product, and user flows. Kafka runtime execution was not included in the final local validation environment.

## Repository

https://github.com/SagarPazare/SmartCart
