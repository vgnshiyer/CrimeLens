FROM gradle:7-jdk17 as build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:17-jdk
COPY --from=build /home/gradle/src/build/libs/*.jar /app.jar
EXPOSE 8080