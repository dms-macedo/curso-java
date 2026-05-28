# 🌌 Space Game Center

> Um sistema de gerenciamento de loja de jogos digitais via console, construído com foco em UX, Arquitetura Limpa e Orientação a Objetos.
>
> 🌱 **Status:** Projeto contínuo e evolutivo. Este sistema é o meu laboratório prático principal e crescerá em complexidade ao longo de todo o meu aprendizado no curso de Java Puro.

---

## 📂 Localização no Repositório

Este README documenta o projeto **Space Game Center**, que é um submódulo do meu repositório geral de estudos de Java.

Para encontrar os códigos-fonte descritos aqui, navegue até a seguinte estrutura de pastas:
`📁 exercises ➔ 📁 introduction ➔ 📁 projetoSimples`

Lá você encontrará os pacotes `dominios` (com as entidades e regras de negócio) e `main` (com o menu de execução).

---

## 🛠️ Tecnologias Utilizadas (Até o Momento)

* **Java (JDK)**: Lógica principal e estruturação.
* **Paradigma Orientado a Objetos (POO)**: Encapsulamento, delegação de responsabilidades e interações entre entidades.
* **Estruturas de Dados**: Gerenciamento de estado através de Arrays (Vetores).

---

## ⚙️ Funcionalidades do Sistema

O menu principal atua como um *Gateway* para as sete operações principais do sistema:

1. **Cadastrar Desenvolvedora:** Registro de estúdios criadores de jogos, com opção de atribuir nacionalidade.
2. **Cadastrar Jogo:** Criação de novos títulos vinculados obrigatoriamente a uma Desenvolvedora existente no sistema.
3. **Cadastrar Cliente:** Criação de perfis de usuários para a loja.
4. **Adicionar Saldo:** Sistema de carteira virtual com suporte a depósitos e aplicação de códigos promocionais.
5. **Comprar Jogo:** Motor de transações que cruza o saldo do cliente com o valor do jogo e o adiciona à biblioteca pessoal.
6. **Listar Jogos:** Exibição do catálogo completo da loja em formato de tabela responsiva.
7. **Ver Perfil:** Relatório detalhado do cliente, mostrando saldo atual e biblioteca de jogos adquiridos.

---

## 🧠 Regras de Negócio e UX (Experiência do Usuário)

O grande diferencial desta versão do projeto é a sua robustez. O sistema foi "blindado" contra comportamentos inesperados do usuário:

* **Validação de Inputs (Jaulas de Fluxo):** O uso estratégico de laços `while(true)` garante que o usuário seja retido na tela atual até fornecer um dado válido, impedindo que letras quebrem campos numéricos (evitando `InputMismatchException` e `NumberFormatException`).
* **Busca Híbrida (ID ou Nome):** Para agilizar a navegação, as buscas por Clientes e Jogos aceitam tanto o Nome Exato (String) quanto o ID/Índice (Inteiro) gerado nas tabelas do console.
* **Integridade Relacional:** Não é possível cadastrar um jogo sem vinculá-lo a uma desenvolvedora. Se a desenvolvedora não existir, o sistema abre um sub-menu permitindo a criação imediata dela sem perder o progresso do cadastro do jogo.
* **Limites de Memória:** O Banco de Dados possui limites restritos (10 Desenvolvedoras, 50 Jogos, 10 Clientes, 100 Jogos por Biblioteca), todos tratados para avisar o usuário antes de um `IndexOutOfBoundsException`.
* **Tratamento Financeiro:** Proibição de inserção de valores negativos para preços ou saldos.
* **Código Promocional:** Depósitos podem receber o código `SPACE2026`, garantindo um bônus de **20%** no valor inserido.

---

## 🏗️ Arquitetura das Classes

O projeto respeita o princípio da Responsabilidade Única (SRP):

* `Menu`: Contém o método `main`, servindo apenas para instanciar o loop principal e ler a primeira intenção do usuário.
* `MenuController`: O "cérebro" das operações. Responsável por lidar com o `Scanner`, capturar exceções, desenhar tabelas no console e orquestrar a comunicação entre o usuário e o banco de dados.
* `BancoDeDados`: Classe estática que simula a persistência de dados em memória utilizando Arrays. Responsável pelo CRUD (Create, Read) e pelas regras de limitação de armazenamento.
* Entidades (`Cliente`, `Desenvolvedora`, `Jogo`): Classes de domínio puras. Elas não interagem com o Scanner, focando apenas em gerenciar seus próprios estados (ex: O cliente tem a responsabilidade de processar a compra e imprimir seu próprio perfil).

---

## 📖 A Jornada de Desenvolvimento: Deep Dive de Lógica

Esta base não foi escrita do dia para a noite. Ela é o resultado de uma imersão de duas semanas focada em elevar o padrão de código de "funcional" para "profissional".

### O que eu construí:
* Desenvolvi a arquitetura inicial e a interligação complexa entre os loops de repetição.
* Idealizei a experiência do usuário, implementando lógicas avançadas como detectar se um cliente recém-criado precisava de saldo antes de continuar a compra, e resolvendo problemas de escopo de variáveis.
* Criei o design do console, implementando menus alinhados e tabelas via `printf`.

A maior lição extraída nesta etapa do curso foi: "A sintaxe a gente pesquisa, mas a lógica estrutural, a atenção à experiência de quem vai usar o sistema e a separação de responsabilidades são habilidades que ficam para sempre."

---

## 🚀 Como Executar

1. Clone o repositório principal para a sua máquina.
2. Certifique-se de ter o JDK (Java Development Kit) instalado (versão 8 ou superior).
3. Abra o terminal e navegue até a pasta `exercises` do repositório.
4. Compile e execute a classe `Menu.java` respeitando a estrutura do pacote:

```bash
javac introduction/projetoSimples/main/Menu.java
java introduction.projetoSimples.main.Menu