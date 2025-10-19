# Spring Zero to Hero Codes

A minimal Spring Boot starter project that you can use to experiment with building REST APIs or web applications. The project ships with Spring Boot 3.5, Maven wrapper scripts, and a simple application entry point.

## Prerequisites

- Java 17 or newer installed and available on your PATH
- No need to install Maven manually; the included wrapper (`mvnw`) downloads the right version on first use

To verify Java:

```bash
java -version
```

## Getting Started

Clone your repository and move into the project directory:

```bash
git clone https://github.com/<your-user>/spring-zero-to-hero-codes.git
cd spring-zero-to-hero-codes
```

### Run the application

Use the Maven wrapper to launch Spring Boot:

```bash
./mvnw spring-boot:run
```

Once the build finishes, the app starts on `http://localhost:8080/`. The sample project does not expose REST endpoints yet, but the application context loads successfully and is ready for you to add controllers or other beans.

### Run the tests

```bash
./mvnw test
```

### Build an executable jar

```bash
./mvnw clean package
```

The resulting jar is placed in `target/` (for example `target/demo-0.0.1-SNAPSHOT.jar`). You can run it with:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## Project Structure

```
.
├── HELP.md                  # Links to Spring Boot and Maven documentation
├── pom.xml                  # Maven build configuration and dependencies
├── mvnw / mvnw.cmd          # Maven wrapper scripts for Unix and Windows
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com/example/demo
│   │   │       └── DemoApplication.java   # Spring Boot entry point annotated with @SpringBootApplication
│   │   └── resources
│   │       ├── application.properties     # Externalized configuration; currently empty
│   │       ├── static/                    # Place static web assets (CSS, JS, images)
│   │       └── templates/                 # Place Thymeleaf templates or other view templates
│   └── test
│       └── java
│           └── com/example/demo
│               └── DemoApplicationTests.java  # Basic context load test using Spring Boot Test
└── target/                  # Generated build output (created after running Maven; usually not committed)
```

## Next Steps

- Add REST controllers under `src/main/java/com/example/demo` (or rename the package to your preferred domain)
- Update `pom.xml` to include additional Spring starters as needed (JPA, Security, etc.)
- Configure application settings in `src/main/resources/application.properties`

If you plan to distribute or deploy the project, consider updating the Maven coordinates (`groupId`, `artifactId`, `name`) to match your organization or domain.
