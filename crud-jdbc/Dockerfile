FROM maven:3.9-eclipse-temurin-17 as MVN_BUILDER
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests -U
ENTRYPOINT ["top", "-b"]

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=MVN_BUILDER /app/target/*.jar .
ENTRYPOINT ["java","-jar","crud-jdbc-1.0-SNAPSHOT.jar"]