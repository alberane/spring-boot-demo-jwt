# Demo JWT com Spring Boot

Este é um projeto simples desenvolvido para demonstrar a implementação de JSON Web Tokens (JWT) em uma aplicação Spring Boot. Ele serve como um exemplo prático para entender os conceitos básicos de autenticação e autorização utilizando JWT.

## Objetivos de Aprendizagem

Ao explorar este projeto, você poderá aprender sobre:

* **O que é JWT:** Entender a estrutura e o funcionamento dos JSON Web Tokens.
* **Autenticação com JWT:** Como utilizar JWT para autenticar usuários em uma aplicação Spring Boot.
* **Geração de Tokens:** Como gerar um JWT após a autenticação bem-sucedida.
* **Validação de Tokens:** Como verificar a validade de um JWT em requisições subsequentes.
* **Autorização com JWT:** Como usar as informações contidas no JWT para autorizar o acesso a recursos específicos.
* **Implementação em Spring Boot:** Como integrar a funcionalidade de JWT em uma aplicação Spring Boot utilizando o Spring Security.

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

* **Java Development Kit (JDK):** Versão 17 ou superior recomendada.
* **Maven:** Versão 3.6 ou superior. (Este projeto utiliza o Maven como ferramenta de build)
* **IDE (Integrated Development Environment):** Sua IDE preferida (IntelliJ IDEA, Eclipse, VS Code, etc.).
* **Docker + docker-compose:** Na rais do projeto execute `docker-compose up --buid`
* **Insomnia:** Para testar as APIs.

## Configuração e Execução

Siga estes passos para configurar e executar o projeto:

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/alberane/spring-boot-demo-jwt.git
    cd spring-boot-demo-jwt
    ```

2.  **Construa o projeto utilizando o Maven:**
    ```bash
    mvn clean install
    ```

3.  **Execute a aplicação Spring Boot:**
    Você pode executar a aplicação de diferentes maneiras:

    * **Pela linha de comando Maven:**
        ```bash
        mvn spring-boot:run
        ```
    * **Pela sua IDE:** Importe o projeto como um projeto Maven e execute a classe principal (`DemoJwtApplication.java`).

A aplicação estará disponível em `http://localhost:8080`.

## Utilização

O projeto demonstra um fluxo de autenticação básico. Aqui estão os endpoints principais para interagir:

1.  **`POST /api/auth/login`**: Este endpoint recebe um nome de usuário e senha no corpo da requisição (geralmente em formato JSON). Se as credenciais estiverem corretas, ele retorna um JWT no corpo da resposta.

2.  **`GET /api/admin/hello`**: Este é um endpoint protegido que requer um JWT válido para ser acessado. O JWT deve ser enviado no header da requisição com o prefixo `Bearer`.

    **Exemplo de requisição (com Postman ou curl):**

    ```bash
    curl -X GET -H "Authorization: Bearer SEU_JWT_AQUI" http://localhost:8080/api/admin/hello
    ```

    *(Substitua `SEU_JWT_AQUI` pelo token recebido no passo anterior.)*

    **Exemplo de resposta (se o token for válido):**

    ```
    Olá Administrador!
    ```

## Conceitos Chave Demonstrados

Este projeto ilustra os seguintes conceitos de JWT:

* **Geração de JWT:** A aplicação gera um JWT no endpoint de login após a autenticação. Este token contém informações sobre o usuário e é assinado para garantir sua integridade.
* **Envio do JWT:** O cliente (por exemplo, um navegador ou uma aplicação front-end) envia o JWT em requisições subsequentes no header `Authorization` com o esquema `Bearer`.
* **Validação do JWT:** O backend Spring Boot intercepta as requisições para endpoints protegidos e valida o JWT recebido. Ele verifica a assinatura do token e sua validade.
* **Acesso a Recursos Protegidos:** Apenas requisições com um JWT válido são autorizadas a acessar os recursos protegidos (como o endpoint `/api/admin/hello`).

## Próximos Passos e Exploração Adicional

* **Explore o código:** Examine as classes no pacote `com.example.demojwt` para entender como a autenticação e autorização com JWT estão implementadas. Preste atenção às configurações do Spring Security, aos filtros e ao serviço de geração e validação de tokens.
* **Modifique as configurações:** Tente alterar a chave secreta utilizada para assinar os tokens e observe como isso afeta a validação.
* **Adicione roles e permissões:** Expanda o projeto para incluir diferentes roles de usuário e implementar autorização baseada em roles utilizando as informações do JWT.
* **Implemente refresh tokens:** Explore como utilizar refresh tokens para renovar o acesso sem que o usuário precise fazer login novamente com frequência.
* **Integre com um banco de dados:** Conecte a aplicação a um banco de dados para armazenar informações dos usuários em vez de utilizar uma autenticação em memória.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests com melhorias e correções.

## Licença

Este projeto está licenciado sob a MIT.