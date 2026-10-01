# DESAFIO PRÁTICO 3: AUDITORIA DE TRANSAÇÕES FINANCEIRAS

---

## 1. CENÁRIO: PROCESSAMENTO FINANCEIRO
A equipe de tecnologia de uma *fintech* precisa processar o log diário de transações efetuadas por clientes. Devido a instabilidades de rede na maquininha de cartão, o arquivo bruto contém registros duplicados (mesmo ID de transação retransmitido) e linhas corrompidas.

Seu objetivo é ler este arquivo, ignorar os registros duplicados e corrompidos, agrupar as transações válidas por categoria de estabelecimento (ex: ALIMENTACAO, TRANSPORTE, SAUDE), ordenar cada grupo pelo valor em ordem decrescente e salvar o resultado final em um novo arquivo físico de texto.

---

## 2. ARQUIVO DE ENTRADA (transacoes.txt)
Crie um arquivo chamado `transacoes.txt` na raiz do seu projeto com o seguinte conteúdo para testes:

```text
TX-1001;4532xxxx1122;2026-10-01T10:15:00;250.00;ALIMENTACAO
TX-1002;4532xxxx3344;2026-10-01T11:30:00;4500.00;ELETRONICOS
TX-1001;4532xxxx1122;2026-10-01T10:15:00;250.00;ALIMENTACAO
DADOS_CORROMPIDOS_SEMAPAS
TX-1003;4532xxxx5566;2026-10-01T12:00:00;120.50;TRANSPORTE
TX-1004;4532xxxx7788;2026-10-01T14:20:00;89.90;ALIMENTACAO
TX-1002;4532xxxx3344;2026-10-01T11:30:00;4500.00;ELETRONICOS
TX-1005;4532xxxx9900;2026-10-01T15:45:00;1200.00;ELETRONICOS
TX-1006;4532xxxx1234;2026-10-01T16:10:00;-50.00;SAUDE
TX-1007;4532xxxx5678;2026-10-01T17:00:00;45.00;TRANSPORTE
```

---

## 3. REQUISITOS TÉCNICOS

### 3.1. POO, Generics e Regras de Hashing (Set)
Crie uma classe `Transacao<T>`.
* Utilize o tipo genérico `<T>` para o ID da transação.
* Atributos privados: `T id`, `String conta`, `LocalDateTime dataHora`, `double valor` e `String categoria`.
* Implemente obrigatoriamente os métodos `equals()` e `hashCode()` utilizando **apenas o ID da transação** (`id`) como critério de igualdade.

### 3.2. Exceptions Customizadas
Crie uma exceção checked chamada `TransacaoInvalidaException`.
* A exceção deve ser disparada em dois cenários:
    1. Se a linha do arquivo não contiver exatamente 5 parâmetros.
    2. Se o valor da transação for menor ou igual a zero (ex: `TX-1006` no arquivo de teste).

### 3.3. NIO e Processamento de Leitura
Crie a classe principal `AuditoriaFinanceiraMain`.
* Utilize `Files.readAllLines` para carregar o arquivo `transacoes.txt`.
* Itere sobre as linhas. Se a linha for inválida ou possuir valor negativo, lance a `TransacaoInvalidaException`, capture-a no laço de leitura e exiba o log do erro no console.
* Trate a `IOException` para falhas globais de leitura.

### 3.4. Collections: Set (Deduplicação) e Map (Agrupamento)
1. **Deduplicação (Set):** Adicione todas as instâncias de `Transacao<String>` válidas em um `Set<Transacao<String>>`. O `Set` eliminará automaticamente transações com o mesmo ID (como `TX-1001` e `TX-1002`).
2. **Agrupamento (Map):** Crie um `Map<String, List<Transacao<String>>>`. Itere sobre o `Set` de transações filtradas e popule este mapa, onde a **chave** será a Categoria (ex: "ALIMENTACAO", "ELETRONICOS") e o **valor** será uma lista com as transações dessa categoria.

### 3.5. Classes Anônimas, Ordenação e Datas
* Itere sobre o Mapa de categorias.
* Para cada lista de transações, utilize `Collections.sort()` com um `Comparator` instanciado via **Classe Anônima**.
* A ordenação deve ser **decrescente por valor** (do maior valor para o menor valor).

### 3.6. Persistência em Arquivo (NIO Escrita)
* Formate os dados de saída e utilize as APIs do NIO (`Files.write` ou `Files.writeString` combinados com `Paths.get`) para salvar o resultado final em um arquivo chamado `relatorio_financeiro.txt` na pasta do exercício.

---

## 4. RESULTADO ESPERADO

### 4.1. Logs no Console (Execução)
```text
[LOGS DE PROCESSAMENTO]
Linha 4: ERRO - Registro corrompido ou com parâmetros insuficientes.
Linha 9: ERRO - Valor da transação invalido (menor ou igual a zero).

Relatório financeiro gerado com sucesso em relatorio_financeiro.txt!
```

### 4.2. Conteúdo do Arquivo Gerado (relatorio_financeiro.txt)
```text
=== RELATÓRIO DE TRANSAÇÕES AUDITADAS ===

CATEGORIA: ELETRONICOS
 - [TX-1002] Valor: R$ 4500,00 | Data: 01/10/2026 11:30 | Conta: 4532xxxx3344
 - [TX-1005] Valor: R$ 1200,00 | Data: 01/10/2026 15:45 | Conta: 4532xxxx9900

CATEGORIA: ALIMENTACAO
 - [TX-1001] Valor: R$ 250,00 | Data: 01/10/2026 10:15 | Conta: 4532xxxx1122
 - [TX-1004] Valor: R$ 89,90 | Data: 01/10/2026 14:20 | Conta: 4532xxxx7788

CATEGORIA: TRANSPORTE
 - [TX-1003] Valor: R$ 120,50 | Data: 01/10/2026 12:00 | Conta: 4532xxxx5566
 - [TX-1007] Valor: R$ 45,00 | Data: 01/10/2026 17:00 | Conta: 4532xxxx5678
```