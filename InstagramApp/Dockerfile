# build stage
FROM maven:3.8.5-openjdk-17 AS build

ENV HOME=/app
 
WORKDIR $HOME
# comment
COPY ./ $HOME
RUN --mount=type=cache,target=/root/.m2 mvn -f $HOME/pom.xml -DskipTests clean package 


# docker build stage
FROM openjdk:17

COPY --from=build /app/target/*.jar app.jar

ENV PORT=8080
EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "-Dserver.port=${PORT}", "app.jar"]
