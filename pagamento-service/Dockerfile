# Etapa 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
#RUN mvn -pl pagamento-service -am clean package -DskipTests
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/pagamento-service/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
