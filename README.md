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

### 2. Execute o script de automação

```bash
bash start.sh
```

### 3. Teste a API

Use o Swagger:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

## 🔒 Autenticação

Para acessar os endpoints protegidos, utilize o token JWT obtido ao fazer login em:

```
POST /api/auth/login
```

Exemplo de token:

```json
{
  "token": "Bearer eyJhbGciOiJIUzI1NiJ9..."
}
```

Utilize este token no botão "Authorize" do Swagger ou no header:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
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

## 📚 Endpoints da API

| Método | Endpoint                                   | Descrição                                      | Corpo da Requisição                                                    | Resposta de Sucesso                        |
| ------ | ------------------------------------------ | ---------------------------------------------- | ---------------------------------------------------------------------- | ------------------------------------------ |
| POST   | `/api/auth/login`                          | Autentica o usuário e retorna o token JWT      | `{ "email": "user@email.com", "senha": "123456" }`                     | `{ "token": "Bearer eyJhbGci..." }`        |
| POST   | `/api/usuarios`                            | Cadastra um novo usuário                       | `{ "nome": "Luigi", "email": "...", "senha": "...", "cidade": "..." }` | JSON do usuário criado (sem senha)         |
| GET    | `/api/usuarios`                            | Lista todos os usuários com paginação e filtro | (query params: `page`, `size`, `sort`, `cidade`)                       | Lista paginada de `UsuarioDTO`             |
| GET    | `/api/usuarios/{id}`                       | Retorna um usuário por ID                      | N/A                                                                    | JSON de `UsuarioDTO`                       |
| PUT    | `/api/usuarios/{id}`                       | Atualiza os dados de um usuário                | Mesma estrutura do POST `/usuarios`                                    | JSON atualizado do usuário                 |
| DELETE | `/api/usuarios/{id}`                       | Deleta um usuário                              | N/A                                                                    | Status `204 No Content`                    |
| GET    | `/api/usuarios/me`                         | Retorna os dados do usuário logado             | Header: `Authorization: Bearer <token>`                                | JSON com `UsuarioDTO`                      |
| GET    | `/api/usuario-alertas/usuario/{usuarioId}` | Lista os alertas recebidos por um usuário      | Header: JWT                                                            | Lista de `AlertaDTO`                       |
| POST   | `/api/alertas`                             | Cria um novo alerta manualmente                | `{ "tipo": "Vendaval", "descricao": "...", "cidade": "..." }`          | JSON do alerta criado                      |
| GET    | `/api/alertas`                             | Lista todos os alertas                         | N/A                                                                    | Lista de `Alerta`                          |
| GET    | `/api/alertas/{id}`                        | Retorna um alerta por ID                       | N/A                                                                    | JSON de `Alerta`                           |
| DELETE | `/api/alertas/{id}`                        | Deleta um alerta                               | N/A                                                                    | Status `204 No Content`                    |
| GET    | `/api/alertas/cidade/{cidade}`             | Lista alertas por cidade                       | N/A                                                                    | Lista de `Alerta`                          |
| GET    | `/api/clima/analisar?lat=...&lon=...`      | Analisa o clima da localização e gera alertas  | Query params: `lat`, `lon`                                             | "Análise climática concluída com sucesso." |

---


## 🖼️ Prints e Demonstrações

![docker ps](docs/docker-ps.png)
![CRUD funcionando](docs/postman-alerta.png)

---

## 📹 Demonstração em Vídeo

Assista ao funcionamento completo no YouTube:
🔗 [Vídeo Demonstração](https://youtube.com/...)

---

## 👨‍💻 Autores

**Luigi Berzaghi** - RM555516

**Guilherme Pelissari** - RM558445

**Cauã dos Santos** - RM559093

---
