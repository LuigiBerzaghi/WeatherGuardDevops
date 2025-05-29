# 🌪️ WeatherGuard - Sistema de Alerta Climático Inteligente

WeatherGuard é uma solução desenvolvida para proteger vidas em situações de risco causadas por eventos naturais extremos, como chuvas intensas, ventos fortes e temperaturas elevadas. Utilizando dados meteorológicos em tempo real e análise inteligente de condições climáticas, a aplicação gera alertas automáticos para usuários em regiões vulneráveis.

---

## 🚀 Tecnologias Utilizadas

### Backend

* **Java 17**
* **Spring Boot 3**
* **Spring Data JPA**
* **Spring Security com JWT**
* **PostgreSQL**
* **Hibernate**
* **OpenWeatherMap API** (dados externos)

### DevOps

* **Docker**
* **Docker Compose**
* **Volumes para persistência**
* **Ambiente isolado com containers para App e Banco**

---

## 🧱 Estrutura do Projeto

```bash
WeatherGuard/
├── docker/
│   ├── Dockerfile             # Dockerfile da aplicação Java
├── docker-compose.yml         # Orquestração dos containers
├── src/                       # Código-fonte Java (Spring Boot)
├── target/                    # Jar gerado pelo Maven
├── pom.xml                    # Dependências do projeto
└── README.md                  # Este arquivo
```

---

## ⚙️ Como Executar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/LuigiBerzaghi/WeatherGuardDevops.git
cd WeatherGuardDevops/WeatherGuard
```

### 2. Compile o projeto

```bash
mvn clean package -DskipTests
```

### 3. Suba os containers

```bash
docker-compose up -d --build
```

### 4. Verifique os containers

```bash
docker ps
```

### 5. Teste a API

Use o Swagger:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

## 🔐 Autenticação JWT (opcional)

Para endpoints protegidos, é necessário enviar o token JWT no cabeçalho:

```http
Authorization: Bearer <seu-token>
```

---

## 🐳 Detalhes da Conteinerização

### Docker Compose sobe dois containers:

* **App Java** (porta 8080)
* **Banco PostgreSQL** (porta 5432)

### Banco de dados:

* Nome: `weatherguard`
* Usuário: `postgres`
* Senha: `123456`

Volumes são usados para garantir a persistência dos dados.

---

## 🧪 Testes CRUD

1. **POST /alertas** → cria alerta
2. **GET /alertas** → lista alertas
3. **PUT /alertas/{id}** → atualiza
4. **DELETE /alertas/{id}** → remove

---

## 🖼️ Prints e Demonstrações

![docker ps](docs/docker-ps.png)
![CRUD funcionando](docs/postman-alerta.png)

---

## 📹 Demonstração em Vídeo

Assista ao funcionamento completo no YouTube:
🔗 [Vídeo Demonstração](https://youtube.com/...)

---

## 👤 Autor

* **Nome:** Luigi Berzaghi
* **RM:** 555516
* **Turma:** 2TDS - Análise e Desenvolvimento de Sistemas

---
