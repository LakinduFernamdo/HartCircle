# Use official JDK 21 base image
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /HartCircle-app

# Copy the built JAR file into the container
COPY ./target/BackEnd-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on (default is 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
