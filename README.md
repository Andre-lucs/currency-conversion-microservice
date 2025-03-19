# Currency Microservices Project

This repository contains a set of microservices for currency conversion and exchange, developed following good practices and based on a course. The project includes the following components:

- **Currency Exchange Service**: Provides exchange rates between different currencies.
- **Currency Conversion Service**: Converts amounts between different currencies using the exchange rates provided by the Currency Exchange Service.
- **Naming Server**: Manages service discovery and registration.
- **API Gateway**: Acts as a bridge between the end user and the microservices, routing requests to the appropriate service.

## Project Structure

- `naming-server`: Eureka Naming Server for service discovery.
- `currency-exchange-service`: Service for providing currency exchange rates.
- `currency-conversion-service`: Service for converting currency amounts.
- `api-gateway`: API Gateway for routing requests to the appropriate microservice.

## Prerequisites

- Java 21
- Maven
- Spring Boot
- Docker (optional, for containerization)

## Getting Started

### Running the Services

1. **Build the project**:
    ```sh
    mvn clean install
    ```

2. **Start the Naming Server**:
    ```sh
    mvn -pl naming-server spring-boot:run
    ```

3. **Start the Currency Exchange Service**:
    ```sh
    mvn -pl currency-exchange-service spring-boot:run
    ```

4. **Start the Currency Conversion Service**:
    ```sh
    mvn -pl currency-conversion-service spring-boot:run
    ```

5. **Start the API Gateway**:
    ```sh
    mvn -pl api-gateway spring-boot:run
    ```

### Accessing the Services

- **Currency Exchange Service**: `http://localhost:8000/currency-exchange/from/{from}/to/{to}`
- **Currency Conversion Service**: `http://localhost:8100/currency-conversion/from/{from}/to/{to}/quantity/{quantity}`
- **API Gateway**: `http://localhost:8765/{service-name}/{endpoint}`

### Example Requests

- **Get Exchange Rate**:
    ```sh
    curl http://localhost:8000/currency-exchange/from/USD/to/INR
    ```

- **Convert Currency**:
    ```sh
    curl http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/100
    ```

- **Access via API Gateway**:
    ```sh
    curl http://localhost:8765/currency-exchange/from/USD/to/INR
    curl http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/100
    ```
- **Access via API Gateway with shorter paths**:
    ```sh
    curl http://localhost:8765/exchange/from/USD/to/INR
    curl http://localhost:8765/conversion/from/USD/to/INR/quantity/100
    ```

## Technologies Used

- Java
- Spring Boot
- Spring Cloud (Eureka, Gateway)
- Resilience4j (Circuit Breaker, Rate Limiter)
- Maven

## Acknowledgments

This project was developed following a course on microservices architecture and best practices.