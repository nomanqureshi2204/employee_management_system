FROM eclipse-temurin:17-jdk

WORKDIR /app

# Spring Boot jar copy (target folder se)
COPY target/*.jar app.jar

# App ke andar jo port use ho raha hai (usually 8080)
EXPOSE 8080

# Run command
ENTRYPOINT ["java","-jar","app.jar"]