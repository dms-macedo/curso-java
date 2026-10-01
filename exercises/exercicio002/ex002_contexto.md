# DESAFIO PRÁTICO: SISTEMA DE LOGÍSTICA E ROTEAMENTO

---

## 1. CENÁRIO: PROCESSAMENTO DE FRETES
O centro de distribuição de uma transportadora gera diariamente um arquivo de texto contendo os pacotes despachados. Devido a uma falha no sistema legado, o arquivo está vindo com registros duplicados (mesmo código de rastreio) e linhas malformatadas.

Seu objetivo é ler este arquivo, ignorar os pacotes duplicados, agrupar os pacotes válidos por região de destino e ordenar cada grupo pela data e hora de despacho.

---

## 2. ARQUIVO DE ENTRADA (entregas.txt)
Crie um arquivo chamado `entregas.txt` na raiz do seu projeto com o seguinte conteúdo para testes:

```text
BR-991;SUDESTE;2026-10-01T08:30:00;DESPACHADO
BR-102;SUL;2026-10-01T09:15:00;EM_TRANSITO
BR-991;SUDESTE;2026-10-01T08:30:00;DESPACHADO
FALHA_COMUNICACAO_SISTEMA
BR-405;NORDESTE;2026-10-01T14:00;AGUARDANDO
BR-333;SUL;2026-10-01T07:45:00;DESPACHADO
BR-888;SUDESTE;2026-10-01T10:20:00;CANCELADO
BR-102;SUL;2026-10-01T09:15:00;EM_TRANSITO
```

---

## 3. REQUISITOS TÉCNICOS

### 3.1. POO, Generics e Regras de Hashing (Set)
Crie uma classe `Pacote<T>`.
* Utilize o tipo genérico `<T>` para o código de rastreio.
* Atributos privados: `T codigo`, `String regiao`, `LocalDateTime dataDespacho` e `String status`.
* Implemente obrigatoriamente os métodos `equals()` e `hashCode()` utilizando **apenas o código de rastreio** como critério de igualdade. Isso é fundamental para a etapa de filtragem.

### 3.2. Exceptions Customizadas
Crie uma exceção checked chamada `PacoteInvalidoException`.
* Deve receber uma mensagem informando a linha defeituosa, para que o sistema de auditoria saiba exatamente onde ocorreu a falha.

### 3.3. NIO e Processamento de Linhas
Crie a classe principal `LogisticaMain`.
* Utilize `Files.readAllLines` para carregar o arquivo.
* Itere sobre as linhas. Se a linha não possuir exatamente 4 parâmetros (separados por `;`), lance a `PacoteInvalidoException`, capture-a no mesmo instante (para não parar o loop) e imprima um log de erro.
* Trate a `IOException` para falhas globais de leitura.

### 3.4. Collections: Set (Filtro) e Map (Agrupamento)
O processamento dos pacotes válidos deve ocorrer em duas etapas estruturais:
1. **Deduplicação (Set):** Adicione todos os objetos `Pacote` criados com sucesso em um `Set<Pacote<String>>`. Se o seu `equals` e `hashCode` estiverem corretos, o Set descartará automaticamente as linhas duplicadas.
2. **Agrupamento (Map):** Crie um `Map<String, List<Pacote<String>>>`. Itere sobre o seu `Set` e popule este mapa, onde a **chave** (Key) será a Região e o **valor** (Value) será uma lista contendo todos os pacotes daquela respectiva região.

### 3.5. Classes Anônimas e Datas
* Após popular o Mapa, itere sobre as chaves dele.
* Para cada lista de pacotes obtida, utilize `Collections.sort()` passando um `Comparator` via **Classe Anônima**.
* A ordenação deve ser **cronológica** (da data/hora mais antiga para a mais recente). Dica: utilize o método natural de comparação do `LocalDateTime`.

---

## 4. RESULTADO ESPERADO
Ao final da execução do `main`, você deve iterar sobre o Mapa impresso no console. A saída final deve ser semelhante a esta estrutura:

```text
[ERRO] Linha 4 corrompida ou incompleta.

--- RELATÓRIO DE ENTREGAS POR REGIÃO ---

REGIÃO: SUDESTE
 - [BR-991] Data: 01/10/2026 08:30 | Status: DESPACHADO
 - [BR-888] Data: 01/10/2026 10:20 | Status: CANCELADO

REGIÃO: SUL
 - [BR-333] Data: 01/10/2026 07:45 | Status: DESPACHADO
 - [BR-102] Data: 01/10/2026 09:15 | Status: EM_TRANSITO

REGIÃO: NORDESTE
 - [BR-405] Data: 01/10/2026 14:00 | Status: AGUARDANDO
```