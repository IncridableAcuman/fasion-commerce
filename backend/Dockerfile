FROM gradle:8.5-jdk17 AS build

LABEL author="Izzatbek"

WORKDIR /app

COPY . .

RUN gradle clean bootJar -x test

FROM openjdk:17-buster-slim

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]