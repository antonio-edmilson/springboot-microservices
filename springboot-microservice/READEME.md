# SPRING BOOT MICROCSERVICE USING SPRING CLOUD, EUREKA, AND ZUUL

Resultados de tradução
Este projeto foi criado para exibir as habilidades no desenvolvimento de aplicações utilizando arquitetura de Microsserviços e as seguintes tecnologias abaixo.

- **Spring Boot**
- **Spring Cloud**
- **Discovery Eureka**
- **Zuul**
- **Java 11**
- **MySQL**
- **Maven**
- **Docker**
- **Dockerfile**
- **Docker Compose**


## Microservices:

- **discovery-eureka** : **discovery-eureka** : Microsserviço responsável por registrar as aplicações através de apelidos, o que torna todo roteamento dinâmico e balanciamento de carga por exemplo; [a link] (https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html)Discovery Eureka
- **gateway-service** : Microsserviço responsável por gerenciar a entrada das chamadas e direcionar as chamadas para as aplicações registradas no Eureka. [a link](https://github.com/Netflix/zuul)
- **product-category-microservice**: Microsserviço é responsável por gerenciar categoria dos produtos, realiza integração com API News [a link] (https://newsapi.org/) por meio de agendamento no Schadule Spring. 
- **product-notes-microservice**: Microsserviço responsável gerenciar por gerenciar a avaliação dos produtos pelos clientes.
- **product-service-microservice**: Microsserviçor esponsável gerenciar por gerenciar o CRUD de produtos.
- **sale-microservice**: Microsserviçor responsável realizar o registro de vendas dos produtos.
- **salesman-microservice**: Microsserviçor responsável pelo gerenciamento dos vendedores.
- **customer-microservice** : Microsserviço responsável pelo gerenciamento de clientes.

# Application WEB
- **marketplace-frontend**: Aplicação Spring WEB criada para demonstrar os dados por interface gráfica. Atualmente está contemplando apenas o CRUD de Produtos.


### EndPoints ###

| Service       | EndPoint                      | Method | Description                                      |
| ------------- | ----------------------------- | :-----:| ------------------------------------------------ |
| Accounts      | /api/v1/accounts/{id}         | GET    | Return detail of specified account               |
| Accounts      | /api/v1/accounts              | GET    | Return details of all acounts                    |
| Products      | /api/v1/products/{id}         | GET    | Return detail of specified product               |
| Products      | /api/v1/products              | GET    | Return details of all products                   |
| Orders        | /api/v1/orders/{id}           | GET    | Return detail of order                           |
| Orders        | /api/v1/orders                | GET    | Return details of orders                         |
| Backoffice    | /api/v1/backoffice/orders     | GET    | Return orders with product name and account name |

### Gateways ###

| Service       | EndPoint                                  |
| ------------- | :---------------------------------------: |
| Accounts      | **/account**/api/v1/accounts/{id}         | 
| Accounts      | **/account**/api/v1/accounts              |
| Products      | **/product**/api/v1/products/{id}         |
| Products      | **/product**/api/v1/products              |
| Orders        | **/order**/api/v1/orders/{id}             |
| Orders        | **/order**/api/v1/orders                  |
| Backoffice    | **/backoffice**/api/v1/backoffice/orders  |

URI for gateway : *http://localhost:8762*

## Used Netflix OSS:

- **Netflix Eureka** is used for discovery service.
- **Netflix Ribbon** is used for client side load-balancing.
- **Netflix Zuul** is used for gateway.

## Used ELK STACK:

- **ElasticSearch** is on 6972 port
- **Logstash TCP** is on 5000 port
- **Kibana** is on 5601 port

## Build & Run

- *>mvn clean package* : to build
- *>docker-compose up* --build : build docker images and containers and run containers
- *>docker-compose stop* : stop the dockerized services
- Each maven module has a Dockerfile.

In docker-compose.yml file:

- Accounts Service : **__2222__** port is mapped to **__7500__** port of host
- Products Service : **__2222__** port is mapped to **__7501__** port of host
- Orders Service : **__2222__** port is mapped to **__7502__** port of host
- Backoffice Service : **__2222__** port is mapped to **__7503__** port of host
- Eureka Discovery Service : **__8761__** port is mapped to **__8761__** port of host
- Zuul Gateway Service : **__8762__** port is mapped to **__8762__** port of host 

## VERSIONS

### 1.1.0

- ElasticSearch, Kibana, Logstash integration

### 1.0.0 SNAPSHOT

- Spring-Boot 2.3.1.RELEASE
- Java 11
- Docker Image updated
- Spring-Cloud artifacts have been changed
- Open Feign integrated

### 0.0.1

- Spring-Boot 2.0.2.RELEASE
- Java 8