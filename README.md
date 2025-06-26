# Aquarium API - Deploy na Nuvem (Render)

Repositório contendo o código adaptado para **deploy na nuvem** da API RESTful de gerenciamento de aquários e animais.

Este projeto foi desenvolvido como parte da disciplina de Desenvolvimento de Sistemas no curso de Sistemas de Informação do Unilasalle-RJ.

## 👨‍🎓 Autor

**Breno Baroncelli**

**E-mail:.** breno.baroncelli@soulasalle.com.br

## 🧰 Tecnologias e Infraestrutura

- Java 17
- Spring Boot 3.4.6
- PostgreSQL (via Render)
- Docker (imagem criada via Dockerfile)
- Spring Data JPA
- SpringDoc OpenAPI (Swagger UI)
- Deploy: [Render.com](https://render.com)

## 🌍 Link da API

🔗 [https://aquarium-rest-api.onrender.com](https://aquarium-rest-api.onrender.com)  
Para acessar o Swagger diretamente:  
📘 [https://aquarium-rest-api.onrender.com/swagger-ui.html](https://aquarium-rest-api.onrender.com/swagger-ui.html)

## 🔄 Como foi feito o Deploy

- Projeto configurado com `Dockerfile` customizado.
- Conectado ao banco PostgreSQL gerenciado pelo Render.
- Variáveis de ambiente configuradas via `application.properties`.

## ⚙️ Funcionalidades da API

- CRUD completo de Aquários e Animais
- Relacionamento @OneToMany entre Aquário e Animal
- Documentação via Swagger disponível publicamente

---

Se quiser, posso gerar esses arquivos prontos para colar direto no GitHub. Deseja isso agora?
