FROM maven:3.9.9-eclipse-temurin-17
WORKDIR /app

# Document the port that Spring Boot now exposes (see application.properties)
EXPOSE 9090

# The Maven wrapper and sources are provided at runtime via the bind mount
ENTRYPOINT ["./mvnw","spring-boot:run"]
