# 🌪️ WeatherGuard API

Sistema de Alerta Climático Inteligente - Backend em Java com Spring Boot

A API WeatherGuard monitora variáveis meteorológicas em tempo real (via OpenWeatherMap), identifica condições de risco (como vendavais, chuvas intensas ou calor extremo) e gera alertas automáticos para os usuários cadastrados conforme sua cidade. A aplicação contempla cadastro de usuários, autenticação com JWT, gerenciamento de alertas e consumo de API externa com análise inteligente.

---

## 📌 Tecnologias Utilizadas

* Java 17
* Spring Boot 3
* Spring Data JPA + Oracle DB
* Spring Security + JWT
* OpenWeatherMap API (clima em tempo real)
* Swagger (SpringDoc OpenAPI)
* Maven
* Docker (estrutura pronta para deploy)

---

## 🚀 Como executar localmente

1. Clone o repositório:

```bash
git clone https://github.com/LuigiBerzaghi/WeatherGuard.git
cd WeatherGuard
```

2. Configure as credenciais no `application.properties`:

```properties
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
openweather.api.key=SUA_CHAVE_AQUI
```

3. Rode o projeto:

```bash
./mvnw spring-boot:run
```

4. Acesse a documentação interativa:

```
http://localhost:8080/swagger-ui.html
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

## 📦 Funcionalidades implementadas

* [x] API REST com Spring Boot
* [x] CRUD completo de Usuário e Alertas
* [x] Autenticação segura com JWT
* [x] Integração com OpenWeatherMap
* [x] Lógica de risco climático automatizada
* [x] Agendamento com `@Scheduled`
* [x] Associação de alertas a usuários por cidade
* [x] Documentação Swagger/OpenAPI
* [x] Paginação, ordenação e filtro por cidade
* [ ] Dockerfile (em progresso)
* [ ] Deploy (em progresso)

---

## 👤 Autor

Luigi Berzaghi
FIAP - Análise e Desenvolvimento de Sistemas
Global Solution 2025/1
