package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 {
    /*
     * =========================================================================================
     * CLASSES ANINHADAS ESTÁTICAS (STATIC NESTED CLASSES)
     * =========================================================================================
     *
     * O QUE É:
     * É uma classe declarada dentro de outra classe utilizando o modificador 'static'.
     *
     * PARA QUE SERVE E ONDE USAR:
     * Serve para agrupamento lógico de classes que possuem forte relação com a classe externa,
     * mas que NÃO dependem do estado ou de uma instância (objeto) da classe pai para funcionar.
     * Muito usada no padrão de projeto Builder (ex: Pessoa.Builder), em DTOs/ajudantes internos
     * e em estruturas como Map.Entry.
     *
     * REGRAS E FUNCIONAMENTO:
     * 1. Independência de Instância: Não necessita de um objeto da classe pai para existir na memória.
     *    Sintaxe de instanciação: new ClasseExterna.ClasseEstatica();
     * 2. Restrição de Acesso: NÃO pode acessar diretamente membros de instância (não-estáticos)
     *    da classe pai. Só acessa o que for 'static' na classe externa.
     * 3. Acesso a Membros Estáticos Privados: Acessa diretamente qualquer atributo ou método
     *    'static' da classe pai, mesmo que seja 'private'.
     * 4. Comportamento: Comporta-se na prática como uma classe externa comum (top-level),
     *    apenas encapsulada dentro do namespace (nome) da classe pai.
     * =========================================================================================
     */

    private String nome = "Davi";

    static class Nested {
        String lastName = "Macedo";

        void print(){
            System.out.println(new OuterClassesTest03().nome + " " + lastName);
        }
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
    }
}
