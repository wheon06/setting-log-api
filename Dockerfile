FROM gradle:8.14-jdk21 AS build

WORKDIR /app

COPY . /app

RUN chmod +x ./gradlew

RUN ./gradlew clean build -x test

FROM openjdk:21-slim

WORKDIR /app

COPY --from=build /app/build/libs/*SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]