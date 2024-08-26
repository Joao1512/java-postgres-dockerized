FROM maven:3.9-eclipse-temurin-17 as MVN_BUILDER
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package
ENTRYPOINT ["top", "-b"]

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=MVN_BUILDER /app/target/*.jar .
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8001", "-jar","java-1.jar"]