
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/*.jar app.jar

# Cria usuário e grupo e garante permissões no app.jar
RUN adduser --system --group weatherguard && \
    chown -R weatherguard:weatherguard /app

USER weatherguard

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
