# ---------- STAGE 1: Build the application ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Set working directory
WORKDIR /app

# Copy project files into container
COPY . .

# Build the JAR file
RUN mvn clean package -DskipTests

# ---------- STAGE 2: Run the application ----------
FROM openjdk:21-jdk

# Set working directory
WORKDIR /HartCircle-app

# Copy only the JAR from the first stage
COPY --from=build /app/target/BackEnd-0.0.1-SNAPSHOT.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
