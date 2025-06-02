#!/bin/bash

echo "🔧 Limpando e compilando o projeto com Maven..."
mvn clean package -DskipTests

echo "🐳 Subindo containers com Docker Compose..."
docker-compose down -v --remove-orphans
docker-compose up -d --build

echo "⏳ Aguardando 10 segundos para inicialização dos containers..."
sleep 10

echo "📦 Containers em execução:"
docker ps

echo "📜 Logs da aplicação (weatherguard-app):"
docker logs weatherguard-app

echo "📜 Logs do banco de dados (postgresdb):"
docker logs postgresdb

echo "🌐 Link para o Swagger da aplicação: http://localhost:8080/swagger-ui/index.html"
