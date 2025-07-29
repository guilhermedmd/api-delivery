## api-delivery

A simple API made with Java, the framework Spring Boot and Maven based in the Ifood business model.
The main dependences used in this project are:
- Spring Web
- H2 database
- Swagger

## Entities
- Cliente
- Restaurante
- Entregador
- Pedido

## features:
All entity have the features:
- POST
- PUT
- GET all
- GET by id
- DELETE

## How to use the interfaces for tests?
To acess the database interface use this address:
```bash
http://localhost:8080/h2-console
````
<br>

To acess the endpoints you can use the address:
```bash
http://localhost:8080/swagger-ui/index.html#/
```
<br>

## Mermaid Diagram
  
```mermaid
erDiagram
    RESTAURANTE ||--o{ PEDIDO : "faz"
    ENTREGADOR ||--o{ PEDIDO : "entrega"
    CLIENTE ||--o{ PEDIDO : "realiza"

    RESTAURANTE {
        int id
        string cnpj
        string nome
        string telefone
        string endereco
    }

    ENTREGADOR {
        int id
        string cpf
        string nome
        string tipo_de_veiculo
        string telefone
    }

    CLIENTE {
        int id
        string cpf
        string nome
        string telefone
    }

    PEDIDO {
        int codProduto
        float valor
        string descricao
        int id_restaurante
        int id_entregador
        int id_cliente
    }
