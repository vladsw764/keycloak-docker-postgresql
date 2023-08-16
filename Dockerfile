FROM openjdk:17
ADD /target/keycloak-docker-postgresql-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]