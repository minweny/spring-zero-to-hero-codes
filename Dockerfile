FROM maven:3.9.9-eclipse-temurin-17
WORKDIR /app

# Document the port that Spring Boot exposes by default
EXPOSE 8080

# The Maven wrapper and sources are provided at runtime via the bind mount
ENTRYPOINT ["./mvnw","spring-boot:run"]
