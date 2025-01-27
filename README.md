

Biscoito da Sorte API
Este projeto é uma API RESTful desenvolvida em Java utilizando Spring Boot. O objetivo da API é gerenciar biscoitos da sorte e suas frases inspiradoras. O projeto permite criar, atualizar, buscar e deletar biscoitos da sorte e frases, sendo possível associar cada biscoito a uma frase.

Funcionalidades
Frases
Criar uma nova frase
Buscar todas as frases ou uma frase específica por ID
Atualizar uma frase existente
Deletar uma frase
Biscoitos
Criar um novo biscoito da sorte associado a uma frase
Buscar todos os biscoitos ou um biscoito específico por ID
Atualizar um biscoito existente (nome e frase)
Deletar um biscoito da sorte
Tecnologias Utilizadas
Java 17
Spring Boot: Framework principal para a construção da API
Spring Data JPA: Utilizado para interação com o banco de dados
H2 Database: Banco de dados em memória para armazenamento das entidades (ideal para testes)
DTO (Data Transfer Object): Usado para transferir dados de forma estruturada entre as camadas da aplicação
Jackson: Para a serialização e desserialização de objetos JSON
Endpoints
Frases
POST /api/frases: Cria uma nova frase
GET /api/frases: Retorna todas as frases
GET /api/frases/{id}: Retorna uma frase específica pelo ID
PUT /api/frases/{id}: Atualiza uma frase existente
DELETE /api/frases/{id}: Deleta uma frase pelo ID
Biscoitos
POST /api/biscoitos: Cria um novo biscoito associado a uma frase
GET /api/biscoitos: Retorna todos os biscoitos
GET /api/biscoitos/{id}: Retorna um biscoito específico pelo ID
PUT /api/biscoitos/{id}: Atualiza um biscoito existente
DELETE /api/biscoitos/{id}: Deleta um biscoito pelo ID
Como Rodar o Projeto
Clone este repositório:

bash
Copiar
Editar
git clone https://github.com/seu-usuario/biscoitosorte-api.git
Navegue até o diretório do projeto:

bash
Copiar
Editar
cd biscoitosorte-api
Compile o projeto com o Maven:

bash
Copiar
Editar
./mvnw clean install
Rode o projeto:

bash
Copiar
Editar
./mvnw spring-boot:run
A API estará rodando em http://localhost:8080.

Frases:
Get: http://localhost:8080/api/frases
lista de criação
Post: http://localhost:8080/api/frases
{
  "conteudo": "Só se vive uma vez",
  "autor": "Enzho Pedro"
}

Put: http://localhost:8080/api/frases/(coloque o id)
{
  "conteudo": "Só sei que nada sei ",
  "autor": "Enzho Soares"
}
Delete:
http://localhost:8080/api/frases/(coloque o id)

Biscoitos:
Get: http://localhost:8080/api/biscoitos
lista de criação

Post: http://localhost:8080/api/biscoitos
{
  "nome": "Biscoito da chocolate",
  "phraseId": 8
}
Put:http://localhost:8080/api/biscoitos/(coloque o id)

{
  "nome": "Biscoito de banana",
  "phraseId": 8
}
Delete: http://localhost:8080/api/biscoitos/(coloque o id)
