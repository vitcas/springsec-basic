# Spring Boot Project

This is a basic Spring Boot application template ready for use. It includes all necessary configurations and dependencies to get started quickly.

## Requirements

- Java 17+
- Maven 3.6+
- Spring Boot 3.x

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/spring-boot-project.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd spring-boot-project
   ```

3. **Build the project:**
   ```bash
   mvn clean install
   ```

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the application:**
   By default, the application runs on `http://localhost:8080`.

## Database Configuration

The project is configured to use H2 as the in-memory database. You can access the H2 console at:
```
http://localhost:8080/h2-console
```
The default credentials for H2 are:
- **Username**: `sa`
- **Password**: `password`

## Project Structure

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── demo
│   │   └── resources
│   │       ├── application.properties
│   │       └── static
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── demo
├── pom.xml
└── README.md
```

## Useful Maven Commands

- **Clean the project**: `mvn clean`
- **Run tests**: `mvn test`
- **Package the application**: `mvn package`

## Contributing

Feel free to fork this repository and submit pull requests for any improvements or issues.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
