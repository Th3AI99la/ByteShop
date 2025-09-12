# ByteShop

Projeto de uma loja de informática online.

## Tecnologias
- **Back-end:** Java, Spring Boot, Maven  
- **Front-end:** Angular  
- **Banco de Dados:** PostgreSQL  
- **Gerenciamento do BD:** PgAdmin4  

## Funcionalidades
- Cadastro e autenticação de usuários (clientes e administradores)  
- Gerenciamento de produtos (CRUD para administradores)  
- Exibição de produtos para clientes  
- Carrinho de compras e finalização de pedidos  
- Histórico de pedidos  

## Estrutura do Projeto
- **/backend** → API em Spring Boot  
- **/frontend** → Aplicação Angular  
- **PostgreSQL** → Banco de dados relacional  

## Como rodar

### Back-end
1. Clonar este repositório  
2. Configurar o banco no arquivo `application.properties`  
3. Executar o back-end:  
   ```bash
   ./mvnw spring-boot:run
