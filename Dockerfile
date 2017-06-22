FROM openjdk:alpine

COPY target /app
WORKDIR /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "spring-session-0.0.1-SNAPSHOT.jar", "--spring.redis.host=redis"]