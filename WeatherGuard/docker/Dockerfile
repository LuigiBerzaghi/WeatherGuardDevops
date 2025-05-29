FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080

# Adiciona usuário não-root
RUN adduser --system --group weatherguard
USER weatherguard

ENTRYPOINT ["java", "-jar", "app.jar"]
