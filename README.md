# GaleriaDeArte

Autora: Esther Pessanha - 202304462291

API de Gerenciamento de Galeria de Arte
📜 Sobre o Projeto
Esta é uma API RESTful desenvolvida para gerenciar um sistema de galeria de arte. O projeto permite o cadastro e controle das entidades centrais de uma galeria: Artistas, suas Obras e as Exposições onde essas obras são apresentadas.

A aplicação foi construída com foco em boas práticas de desenvolvimento, escalabilidade e facilidade de implantação, utilizando uma stack de tecnologias robustas e modernas.

✨ Tecnologias Utilizadas
A seguinte stack de tecnologias foi utilizada na construção do projeto:

Backend:

Java 21: Versão LTS mais recente da linguagem Java.

Spring Boot: Framework para criação de aplicações Java de forma rápida e configurável.

Spring Data JPA: Para persistência de dados de forma simplificada.

Banco de Dados:

MySQL: Sistema de gerenciamento de banco de dados relacional.

Conteinerização:

Docker: Para criar um ambiente padronizado e isolado para a aplicação.

Cloud (Implantação):

Microsoft Azure: A aplicação é implantada como um contêiner utilizando serviços como Azure Container Apps, conectado a um banco de dados gerenciado (Azure Database for MySQL).

🚀 Como Executar o Projeto
Você pode executar este projeto localmente de duas maneiras: utilizando o Maven ou o Docker.

Pré-requisitos
Java 17+

Maven 3.8+

Docker e Docker Compose (para a opção com contêiner)

Um cliente de API (Postman, Insomnia, etc.) para testar os endpoints.

1. Clonando o Repositório
git clone https://SEU_LINK_PARA_O_REPOSITORIO.git
cd NOME_DO_SEU_PROJETO

2. Configuração do Banco de Dados
Crie um banco de dados MySQL chamado galeria_db.

No arquivo src/main/resources/application.properties, atualize as seguintes propriedades com suas credenciais do MySQL:

spring.datasource.url=jdbc:mysql://localhost:3306/galeria_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

3. Executando com Maven
Execute o comando a seguir na raiz do projeto para iniciar a aplicação:

mvn spring-boot:run

A API estará disponível em http://localhost:8080.

4. Executando com Docker
O projeto pode ser iniciado facilmente com Docker Compose, que subirá tanto a aplicação quanto o banco de dados MySQL em contêineres separados.

Na raiz do projeto, execute:

docker-compose up -d

A API estará disponível em http://localhost:8080.

Endpoints da API
A seguir, estão detalhados os endpoints disponíveis.

URL Base: http://localhost:8080

Recurso: Artista (/artista)
Método

Rota

Descrição

Exemplo de Corpo da Requisição

POST

/

Cadastra um novo artista.

{"nome": "Vincent van Gogh", "nacionalidade": "Holandesa"}

GET

/

Lista todos os artistas.

-

GET

/{id}

Busca um artista pelo ID.

-

GET

/buscar?nome={nome}

Busca artistas por nome.

-

PUT

/{id}

Atualiza um artista.

{"nome": "Van Gogh", "nacionalidade": "Holandesa"}

DELETE

/{id}

Remove um artista.

-

Recurso: Obra (/obra)
Método

Rota

Descrição

Exemplo de Corpo da Requisição

POST

/?artistaId={id}

Cadastra uma nova obra para um artista.

{"titulo": "A Noite Estrelada", "ano": 1889}

GET

/

Lista todas as obras.

-

GET

/{id}

Busca uma obra pelo ID.

-

GET

/buscar?titulo={titulo}

Busca obras por título.

-

GET

/artista/{artistaId}

Lista obras de um artista específico.

-

GET

/buscar-por-artista?nome={nome}

Busca obras pelo nome do artista.

-

DELETE

/{id}

Remove uma obra.

-

Recurso: Exposição (/exposicao)
Método

Rota

Descrição

Exemplo de Corpo da Requisição

POST

/

Cria uma nova exposição.

{"nome": "Impressionismo no MOMA", "dataInicio": "2025-01-10", "dataFim": "2025-05-15"}

GET

/

Lista todas as exposições.

-

GET

/{id}

Busca uma exposição pelo ID.

-

POST

/{exposicaoId}/obras/{obraId}

Adiciona uma obra a uma exposição.

-

DELETE

/{exposicaoId}/obras/{obraId}

Remove uma obra de uma exposição.

-

GET

/buscar?nome={nome}

Busca exposições por nome.

-

DELETE

/{id}

Remove uma exposição.

-
