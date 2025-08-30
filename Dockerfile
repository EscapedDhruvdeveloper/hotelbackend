# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-21-jammy AS build

WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime image
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app
RUN groupadd -r spring && useradd -r -g spring spring
COPY --from=build /app/target/*-SNAPSHOT.jar app.jar
RUN chown -R spring:spring /app
USER spring

EXPOSE 4040

HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:4040/actuator/health || exit 1

ENV JAVA_OPTS="-Xmx512m -Xms256m -XX:MaxRAMPercentage=75.0"
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
