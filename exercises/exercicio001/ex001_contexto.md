# DESAFIO PRÁTICO: AUDITORIA DE PONTO (CATRACA)

---

## CONTEXTO DO PROBLEMA

O sistema de segurança da empresa exporta um arquivo de texto diário com as entradas e saídas dos funcionários nas catracas. Durante o envio de dados, falhas de conexão podem corromper algumas linhas do arquivo. 

Sua tarefa é criar um programa em Java capaz de ler o arquivo de log, ignorar linhas corrompidas notificando o erro no console (sem interromper o processamento), mapear os dados válidos, ordená-los da data/hora mais recente para a mais antiga e exibir o relatório final.

---

## ARQUIVO DE ENTRADA (`catraca.txt`)

Crie um arquivo chamado `catraca.txt` na raiz do seu projeto Java com a estrutura abaixo:

```text
1029;2026-09-30T08:15:30;ENTRADA
9931;2026-09-30T08:22:15;ENTRADA
ERRO_DE_LEITURA
1029;2026-09-30T12:00:00;SAIDA
5510;2026-09-30T08:05;ENTRADA_FALHA
```

---

## REQUISITOS DO EXERCÍCIO

### 1. Orientação a Objetos, Generics e Datas (`java.time`)
Crie a classe `RegistroAcesso<T>` com as seguintes especificações:
* **Generics (`<T>`):** Utilizado para o identificador do funcionário (`T idFuncionario`).
* **Atributos Privados:** `T idFuncionario`, `LocalDateTime dataHora`, `String tipoAcesso`.
* **Encapsulamento:** Construtor com todos os parâmetros, métodos getters para os atributos e um método `toString()` formatado para exibição do registro.

### 2. Exceção Customizada Checked
Crie a classe `LogCorrompidoException` estendendo `Exception` (*checked exception*).
* Deve receber no construtor uma mensagem detalhando o erro encontrado na linha processada.

### 3. Leitura com NIO (`java.nio`) e Tratamento de Exceções
Na classe principal `AuditoriaMain`, implemente a leitura do arquivo `catraca.txt`:
* Utilize a API NIO (`Files.readAllLines` e `Path.of`).
* Utilize **dois níveis de `try-catch`**:
  * **Try-Catch Externo:** Trata potenciais exceções de I/O na abertura do arquivo (`IOException`).
  * **Try-Catch Interno (dentro do laço de repetição):** Ao separar os campos com `String.split(";")`, verifique se a linha possui exatamente 3 colunas. Se não possuir (ex: linha `ERRO_DE_LEITURA`), lance a `LogCorrompidoException` e capture-a imediatamente dentro do loop, exibindo um aviso no console e prosseguindo para as próximas linhas sem interromper o processamento.

### 4. Coleções e Classe Anônima (Obrigatório)
* Armazene todos os registros processados com sucesso em uma coleção `List<RegistroAcesso<String>>`.
* **Regra de Ordenação:** Ordene a lista contendo os acessos por `dataHora` de forma **decrescente** (da mais recente para a mais antiga).
* **Restrição Técnica:** É **proibido** o uso de expressões Lambda (`->`) ou `Comparator.comparing()`. Você deve utilizar `Collections.sort()` (ou `list.sort()`) passando obrigatoriamente uma **Classe Anônima** implementando a interface `Comparator<RegistroAcesso<String>>`.

### 5. Exibição e Validação
Ao final da execução, percorra a lista já ordenada e exiba todos os registros no console para confirmar a correta extração, ordenação e manipulação dos dados.