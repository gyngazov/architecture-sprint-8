FROM gradle:jdk17-alpine as builder
WORKDIR /app
COPY . /app
RUN gradle clean build -x test

FROM openjdk:17-jdk-slim
COPY --from=builder /app/build/quarkus-app/ /app
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "-Dquarkus.http.host=0.0.0.0", "-Djava.util.logging.manager=org.jboss.logmanager.LogManager", "/app/quarkus-run.jar"]
