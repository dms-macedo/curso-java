# GUIA DE CONVENÇÕES, ORIENTAÇÃO A OBJETOS E MODIFICADORES EM JAVA

---

## 1. CONVENÇÕES DE NOMENCLATURA (JAVA NAMING CONVENTIONS)

A comunidade Java, com base nas diretrizes oficiais da Oracle e no *Google Java Style Guide*, adota padrões de escrita rigorosos. O cumprimento desses padrões garante a legibilidade e a manutenibilidade do código por equipes globais.

---

### 1.1. Pacotes (`package`)

* **Padrão:** Letras estritamente minúsculas, sem acentuação, sem hífens ou sublinhados.
* **Regra:** Utiliza-se o domínio da organização invertido, seguido pelo nome do projeto e do módulo.
* **Exemplo:**

```java
package br.com.empresa.sistema.financeiro;

package com.devdojo.maratonajava.javacore.colecoes;
```

---

### 1.2. Classes e Interfaces

* **Padrão:** `PascalCase` (primeira letra de cada palavra em maiúsculo).
* **Classes:** Devem ser substantivos ou frases nominais.
* **Interfaces:** Devem ser substantivos ou adjetivos que descrevem capacidades (frequentemente terminadas em `-able` ou `-avel`).
* **Exemplo:**

```java
// Classe
public class ContaCorrente {
    // Conteúdo da classe
}

public class UsuarioRepository {
    // Conteúdo do repositório
}

// Interface
public interface Autenticavel {
    boolean autenticar(String senha);
}

public interface Renderizavel {
    void renderizar();
}
```

---

### 1.3. Métodos

* **Padrão:** `camelCase` (primeira letra minúscula e as palavras subsequentes com a primeira letra maiúscula).
* **Regra:** Devem ser verbos ou iniciar com verbos no infinitivo ou presente, indicando a ação executada.
* **Exemplo:**

```java
public double calcularRendimento(double valorBase) {
    return valorBase * 0.10;
}

public void enviarNotificacao(String mensagem) {
    // Lógica de envio
}

public boolean isValid() {
    return true;
}
```

---

### 1.4. Variáveis e Atributos de Instância

* **Padrão:** `camelCase`.
* **Regra:** Substantivos significativos que expressem claramente o propósito do dado na aplicação.
* **Restrição:** Evitar nomes genéricos de uma única letra (como `a`, `x`, `temp`), exceto em variáveis de escopo restrito em laços de repetição (como `i` ou `j`).
* **Exemplo:**

```java
public class Cliente {
    private String nomeTitular;
    private double saldoDisponivel;

    public void processar() {
        for (int i = 0; i < 10; i++) {
            // Laço com índice curto aceitável
        }
    }
}
```

---

### 1.5. Constantes (`static final`)

* **Padrão:** `UPPER_SNAKE_CASE` (todas as letras em maiúsculo, separadas por sublinhado `_`).
* **Regra:** Devem ser declaradas obrigatoriamente com os modificadores `static` e `final`.
* **Exemplo:**

```java
public class ConfiguracaoSistema {
    public static final double TAXA_LIQUIDA_SAQUE = 0.05;
    public static final int TIMEOUT_CONEXAO_MILISSEGUNDOS = 5000;
    public static final String NOME_SISTEMA = "Space Game Center";
}
```

---

### 1.6. Enumerações (`enum`)

* **Padrão:** A declaração da `enum` utiliza `PascalCase`. As constantes declaradas internamente utilizam `UPPER_SNAKE_CASE`.
* **Exemplo:**

```java
public enum StatusProcessamento {
    EM_ANDAMENTO,
    CONCLUIDO,
    FALHA_PROCESSAMENTO
}
```

---

### 1.7. Generics (`<T>`)

* **Padrão:** Letra única em maiúsculo representando o papel do tipo genérico.
  * `T` (*Type*): Tipo genérico geral.
  * `E` (*Element*): Utilizado em coleções (`List<E>`, `Set<E>`).
  * `K` (*Key*): Chave em estruturas de mapeamento (`Map<K, V>`).
  * `V` (*Value*): Valor em estruturas de mapeamento (`Map<K, V>`).
  * `N` (*Number*): Tipos numéricos.
* **Exemplo:**

```java
public class RepositorioGenerico<T> {
    private T elemento;

    public void salvar(T objeto) {
        this.elemento = objeto;
    }

    public T buscar() {
        return this.elemento;
    }
}
```

---

### 1.8. Padrão JavaBean (Acessores e Modificadores)

* Atributo convencional: `getAtributo()` e `setAtributo(Tipo valor)`.
* Atributo booleano primitivo (`boolean`): `isAtributo()` e `setAtributo(boolean valor)`.
* **Exemplo:**

```java
public class Usuario {
    private String nome;
    private boolean ativo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
```

---

## 2. MODIFICADORES DE ACESSO E COMPORTAMENTO

Os modificadores definem a visibilidade e as propriedades operacionais dos elementos da linguagem.

---

### 2.1. Modificadores de Acesso (Visibilidade)

Existem quatro níveis de restrição no Java:

| Modificador | Própria Classe | Mesmo Pacote | Subclasse (Outro Pacote) | Todo o Projeto |
| :--- | :---: | :---: | :---: | :---: |
| `private` | SIM | NÃO | NÃO | NÃO |
| `default` (nenhum) | SIM | SIM | NÃO | NÃO |
| `protected` | SIM | SIM | SIM | NÃO |
| `public` | SIM | SIM | SIM | SIM |

#### Descrição e Aplicação:

1. **`private` (Restrição Máxima):**
   * **Visibilidade:** Estritamente limitado ao escopo interno da classe em que foi declarado.
   * **Aplicação:** Atributos de classe (fundamento do Encapsulamento).

2. **`default` / Package-Private (Ausência de palavra-chave):**
   * **Visibilidade:** Acessível por qualquer classe pertencente ao mesmo pacote.
   * **Aplicação:** Classes e métodos auxiliares que não devem ser expostos fora do módulo.

3. **`protected` (Acesso por Herança):**
   * **Visibilidade:** Acessível no mesmo pacote e por subclasses em outros pacotes (via `extends`).
   * **Aplicação:** Métodos da classe pai destinados à sobrescrita ou atributos compartilhados com filhas.

4. **`public` (Acesso Irrestrito):**
   * **Visibilidade:** Acessível por qualquer classe em todo o projeto.
   * **Aplicação:** Ponto de entrada da aplicação (`main`), interfaces públicas e serviços expostos.

* **Exemplo:**

```java
package br.com.empresa.modelo;

public class Conta {
    private double saldo;          // private: acesso apenas nesta classe
    String codigoInterno;          // default: acesso apenas no pacote modelo
    protected String titular;      // protected: acesso no pacote e em subclasses
    public String banco;           // public: acesso irrestrito

    public double getSaldo() {
        return this.saldo;
    }
}
```

---

### 2.2. Modificadores de Comportamento (Não-Acesso)

#### 1. `static` (Membro de Classe)
Vincula o atributo ou método à classe, e não a uma instância individual (`new`). Todos os objetos compartilham o mesmo espaço em memória.

```java
public class CalculadoraUtil {
    public static final double PI = 3.14159;

    public static double somar(double a, double b) {
        return a + b;
    }
}
```

#### 2. `final` (Imutabilidade e Restrição)
* **Variáveis:** Torna o valor atribuído imutável após a inicialização.
* **Métodos:** Impede a sobrescrita (`@Override`) por subclasses.
* **Classes:** Bloqueia a herança (a classe não pode ser estendida).

```java
public final class ImmutableToken {
    private final String valor;

    public ImmutableToken(String valor) {
        this.valor = valor;
    }

    public final void exibirAviso() {
        System.out.println("Este método não pode ser redefinido.");
    }
}
```

#### 3. `abstract` (Estrutura Incompleta)
* **Classes:** Impede a instanciação direta (`new`). Serve exclusivamente como base para herança.
* **Métodos:** Declara a assinatura sem implementação (sem corpo `{}`). A subclasse concreta é obrigada a implementar o método.

```java
public abstract class Forma {
    public abstract double calcularArea(); // Sem corpo
}

public class Quadrado extends Forma {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}
```

#### 4. `transient` (Omissão na Serialização)
Informa à JVM que o atributo marcado deve ser ignorado durante o processo de serialização de objetos (ex.: senhas ou dados temporários).

```java
import java.io.Serializable;

public class UsuarioSessao implements Serializable {
    private String login;
    private transient String senha; // Não será salvo na serialização
}
```

#### 5. `volatile` (Sincronização em Threads)
Garante que as operações de leitura e escrita na variável ocorram diretamente na memória principal (RAM), evitando inconsistências de cache de CPU em ambientes multithread.

```java
public class TaskRunner implements Runnable {
    private volatile boolean ativo = true;

    public void parar() {
        this.ativo = false; // Alteração visível imediatamente a todas as threads
    }

    @Override
    public void run() {
        while (ativo) {
            // Executar tarefa
        }
    }
}
```

---

## 3. REGRAS E PRINCÍPIOS DE ORIENTAÇÃO A OBJETOS

### 3.1. Os Quatro Pilares de POO

#### 1. Abstração
Modelagem do domínio isolando apenas as características essenciais para o contexto do sistema, omitindo detalhes irrelevantes.

#### 2. Encapsulamento
Proteção do estado interno do objeto. Os atributos devem ser mantidos privados (`private`), e o acesso deve ser controlado por métodos com validações de negócio.

#### 3. Herança
Mecanismo de reutilização de código onde uma subclasse herda atributos e comportamentos de uma superclasse (`extends`).

#### 4. Polimorfismo
Capacidade de referenciar um objeto concreto através de sua abstração (interface ou classe pai), permitindo que um mesmo método execute comportamentos distintos conforme a instância real.

* **Exemplo dos Pilares Integrados:**

```java
// 1. Abstração
public abstract class Funcionario {
    private String nome;
    protected double salarioBase; // 2. Encapsulamento (protegido)

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario(); // Abstração do cálculo
}

// 3. Herança
public class Gerente extends Funcionario {
    private double bonus;

    public Gerente(String nome, double salarioBase, double bonus) {
        super(nome, salarioBase);
        this.bonus = bonus;
    }

    // 4. Polimorfismo
    @Override
    public double calcularSalario() {
        return salarioBase + bonus;
    }
}
```

---

### 3.2. Princípios S.O.L.I.D.

Diretrizes arquiteturais para o desenvolvimento de sistemas escaláveis e de fácil manutenção:

* **S - Single Responsibility Principle (SRP):** Uma classe deve possuir uma única responsabilidade no sistema.
* **O - Open/Closed Principle (OCP):** Entidades do software devem estar abertas para extensão, mas fechadas para modificação.
* **L - Liskov Substitution Principle (LSP):** Subclasses devem poder substituir suas superclasses sem alterar a corretude do sistema.
* **I - Interface Segregation Principle (ISP):** É preferível criar interfaces pequenas e especializadas a criar uma única interface genérica.
* **D - Dependency Inversion Principle (DIP):** Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações.

* **Exemplo (DIP - Inversão de Dependência):**

```java
// Interface de abstração
public interface ServicoNotificacao {
    void enviar(String mensagem);
}

// Implementação concreta
public class EmailServico implements ServicoNotificacao {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando Email: " + mensagem);
    }
}

// Classe de alto nível depende da abstração
public class ProcessadorPedido {
    private final ServicoNotificacao notificacao;

    public ProcessadorPedido(ServicoNotificacao notificacao) {
        this.notificacao = notificacao; // Injeção de dependência
    }

    public void finalizar() {
        notificacao.enviar("Pedido processado com sucesso!");
    }
}
```

---

### 3.3. Boas Práticas de Código Limpo (Clean Code)

#### 1. Composição sobre Herança (*Favor composition over inheritance*)
Priorize incluir instâncias de outras classes como atributos em vez de estendê-las, reservando a herança apenas para relacionamentos estritos de "É UM".

```java
// Preferível: Composição
public class Carro {
    private Motor motor = new Motor();

    public void ligar() {
        motor.iniciar();
    }
}
```

#### 2. Lei de Demeter (Princípio do Menor Conhecimento)
Um método deve interagir apenas com seus colaboradores diretos. Evite cadeias longas de chamadas.

```java
// Incorreto (Viola Demeter)
cliente.getPedido().getPagamento().processar();

// Correto
cliente.processarPagamentoDoPedido();
```

#### 3. Diga, Não Pergunte (*Tell, Don't Ask*)
Em vez de extrair dados de um objeto para tomar decisões fora dele, solicite ao próprio objeto que execute a operação.

```java
// Incorreto
if (conta.getSaldo() >= valor) {
    conta.setSaldo(conta.getSaldo() - valor);
}

// Correto
conta.sacar(valor);
```

#### 4. DRY (*Don't Repeat Yourself*)
Evite duplicação de lógica e código.

#### 5. KISS (*Keep It Simple, Stupid*)
Opte sempre pela implementação mais simples e direta razoável.

#### 6. YAGNI (*You Ain't Gonna Need It*)
Não adicione código ou estruturas para requisitos hipotéticos futuros.

---

## 4. BOAS PRÁTICAS GERAIS NA LINGUAGEM JAVA

### 4.1. Tratamento de Exceções

Evite a captura de exceções genéricas sem tratamento (`catch (Exception e) {}`). Crie e lance exceções de negócio específicas estendendo `RuntimeException`.

```java
// Exceção de Negócio Customizada
public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

// Uso no código
public class ContaBancaria {
    private double saldo;

    public void sacar(double valor) {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
        }
        saldo -= valor;
    }
}
```

---

### 4.2. Uso de `Optional` (Java 8+)

Empregue `Optional<T>` exclusivamente como tipo de retorno de métodos onde a ausência de valor é um resultado válido. Evite utilizar `Optional` como atributos de classe ou parâmetros de métodos.

```java
import java.util.Optional;

public class ClienteRepository {
    public Optional<String> buscarNomePorId(Long id) {
        if (id.equals(1L)) {
            return Optional.of("João Silva");
        }
        return Optional.empty();
    }
}
```

---

### 4.3. Contrato entre `equals` e `hashCode`

Sempre que o método `equals()` for sobrescrito, o método `hashCode()` deve obrigatoriamente ser sobrescrito utilizando os mesmos atributos de comparação, garantindo o funcionamento correto em coleções como `HashSet` e `HashMap`.

```java
import java.util.Objects;

public class Produto {
    private Long id;
    private String codigoBarra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(codigoBarra, produto.codigoBarra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoBarra);
    }
}
```

---

### 4.4. Manipulação de CADEIAS DE CARACTERES (`StringBuilder`)

Em operações de concatenação contínua ou dentro de laços de repetição, utilize a classe `StringBuilder` para evitar o consumo excessivo de memória gerado pela imutabilidade da classe `String`.

```java
public class RelatorioUtil {
    public String gerarRelatorioTexto(String[] itens) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- RELATÓRIO ---\n");

        for (String item : itens) {
            sb.append("Item: ").append(item).append("\n");
        }

        return sb.toString();
    }
}