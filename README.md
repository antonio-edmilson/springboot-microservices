# SPRING BOOT MICROCSERVICE USANDO SPRING CLOUD, EUREKA, AND ZUUL

Este projeto foi criado para exibir minhas habilidades no desenvolvimento de aplicações utilizando arquitetura de Microsserviços e as seguintes tecnologias abaixo.

- **Spring Boot**
- **Spring Cloud**
- **Discovery Eureka**
- **Zuul**
- **Java 11**
- **MySQL**
- **Maven**
- **Docker**
- **Dockerfile**
- **Docker Compose**,

## Contextualização

Construção de um marketplace de produtos cujo o número de acesso é alto.
Quando o comprador adquirir um novo produto, ele poderá fazer uma avaliação de 0 a 5. 


## Microservices:

- **discovery-eureka** : **discovery-eureka** : Microsserviço responsável por registrar as aplicações através de apelidos, o que torna todo roteamento dinâmico e balanciamento de carga por exemplo; [a link] *(https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html)* 
- **gateway-service** : Microsserviço responsável por gerenciar a entrada das chamadas e direcionar as chamadas para as aplicações registradas no Eureka. [a link](https://github.com/Netflix/zuul)
- **product-category-microservice**: Microsserviço é responsável por gerenciar categoria dos produtos, realiza integração com API News [a link] (https://newsapi.org/) por meio de agendamento no Schadule Spring. 
- **product-notes-microservice**: Microsserviço responsável gerenciar por gerenciar a avaliação dos produtos pelos clientes.
- **product-service-microservice**: Microsserviçor esponsável gerenciar por gerenciar o CRUD de produtos.
- **sale-microservice**: Microsserviçor responsável realizar o registro de vendas dos produtos.
- **salesman-microservice**: Microsserviçor responsável pelo gerenciamento dos vendedores.
- **customer-microservice** : Microsserviço responsável pelo gerenciamento de clientes.

# Application WEB
- **marketplace-frontend**: Aplicação Spring WEB criada para demonstrar os dados por interface gráfica. Atualmente está contemplando apenas o CRUD de Produtos.
URL: http://localhost:9099/index


### EndPoints ###

| Service       | EndPoint                     | Porta  |
| ------------- ----| ----------------------------------| 
| product       	| /api/v1/product            | 9090   |
| sale 	        	| /api/v1/sale               | 9091   | 
| Salasman      	| /api/v1/salesman           | 9092   |
| Customer      	| /api/v1/customer           | 9093   |
| Product-category| /api/v1/product-category   | 9094   |
| Notes Product   | /api/v1/product-note       | 9095   |                   


### Gateways ###

| Service       	| EndPoint                                  |
| ------------- 	| :---------------------------------------: |
| customer     		| **/customer**/api/v1/customer             | 
| product       	| **/product**/api/v1/product               |
| sale          	| **/sale**/api/v1/sale                     |
| salesman      	| **/salesman**/api/v1/salesman             |
| product_not   	| **/product_note**/api/v1/product_note     |
| product_category  | **/order**/api/v1/orders                |
| Backoffice    	| **/backoffice**/api/v1/backoffice/orders  |

URI for gateway : *http://localhost:8080*
URI for Eureka : *http://localhost:9080*

## Swagger Documentação APIs
	http://localhost:9090/swagger-ui/ (product-microservice)
	http://localhost:9091/swagger-ui/ (sale-microservice)
	http://localhost:9092/swagger-ui/ (salesman-microservice)
    http://localhost:9093/swagger-ui/ (customer-microservice)
	http://localhost:9094/swagger-ui/ (product-category-microservice)
	http://localhost:9095/swagger-ui/ (product-notes-microservice)


	
   
## Spring Eureka
	http://localhost:9080/

## Build & Run

Executando aplicação com docker (Dockerfile) utilizando Maven.

- *>mvn clean install* : Construindo aplicação(Obs: execute o comando dentro do diretoria de tosos os projetos.

- *>Criando Container dos bancos de dados mysql* 
	- *>	docker run -d --name mysqlserver-productdb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=productdb mysql:latest
    - *>	docker run -d --name mysqlserver-saledb -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=saledb mysql:latest
	- *>	docker run -d --name mysqlserver-customerdb -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=customerdb mysql:latest
	- *>	docker run -d --name mysqlserver-productcategorydb  -p 3309:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=product_categorydb mysql:latest
	- *>	docker run -d --name mysqlserver-salesmandb -p 3310:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=salesmandb mysql:latest
	- *>	docker run -d --name mysqlserver-productnotedb -p 3311:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=productnotedb mysql:latest

- *>Criando Container para os microservices* 
	- *>	docker run -d --name discovery-eureka --link discovery-eureka:discovery-eureka -p 9080:9080 discovery-eureka:0.0.1-SNAPSHOT
	- *>	docker run -d --name gateway-service --link discovery-eureka:discovery-eureka -p 8080:8080 gateway-service:0.0.1-SNAPSHOT
	- *>	docker run -d --name product-microservice --link mysqlserver-productdb:mysqlserver-productdb --link discovery-eureka:discovery-eureka -p 9090:9090 product-microservice:0.0.1-SNAPSHOT
	- *> 	docker run -d --name sale-microservice --link mysqlserver-saledb:mysqlserver-saledb --link discovery-eureka:discovery-eureka -p 9091:9091 sale-microservice:0.0.1-SNAPSHOT
	- *> 	docker run -d --name salesman-microservice --link mysqlserver-salesmandb:mysqlserver-salesmandb --link discovery-eureka:discovery-eureka -p 9092:9092 salesman-microservice:0.0.1-SNAPSHOT
	- *> 	docker run -d --name customer-microservice --link mysqlserver-customerdb:mysqlserver-customerdb --link discovery-eureka:discovery-eureka -p 9093:9093 customer-microservice:0.0.1-SNAPSHOT
	- *> 	docker run -d --name product-category-microservice --link mysqlserver-productcategorydb:mysqlserver-productcategorydb --link discovery-eureka:discovery-eureka -p 9094:9094 product-category-microservice:0.0.1-SNAPSHOT
	- *> 	docker run -d --name product-notes-microservice --link mysqlserver-productnotedb:mysqlserver-productnotedb --link discovery-eureka:discovery-eureka -p 9095:9095 product-notes-microservice:0.0.1-SNAPSHOT

- *>Criando Container para aplicação web* 	
	- *> 	docker run -d --name marketplace-frontend -link discovery-eureka:discovery-eureka -p 9099:9099 marketplace-frontend:0.0.1-SNAPSHOT
