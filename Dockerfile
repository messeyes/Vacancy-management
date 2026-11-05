FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

RUN apt-get update && apt-get install -y maven

COPY . .

RUN mvn clean install

FROM eclipse-temurin:17-jre
WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/gestaovagas-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]