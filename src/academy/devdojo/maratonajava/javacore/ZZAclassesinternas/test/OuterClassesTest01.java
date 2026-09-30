package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest01 {
    /*
     * =========================================================================================
     * CLASSES INTERNAS DE MEMBRO (MEMBER INNER CLASSES)
     * =========================================================================================
     *
     * O QUE É:
     * É uma classe declarada no corpo da classe principal (fora de métodos), sem o modificador 'static'.
     *
     * PARA QUE SERVE E ONDE USAR:
     * Serve para representar estruturas intimamente ligadas à classe pai que não fazem sentido
     * existir isoladamente no sistema. É usada para agrupamento lógico e para permitir que a
     * classe interna acesse diretamente membros privados da classe externa sem expor getters/setters.
     *
     * REGRAS E FUNCIONAMENTO:
     * 1. Acesso Direto: Acessa todos os atributos e métodos 'private' da classe externa sem burocracia.
     * 2. Dependência de Instância: Exige obrigatoriamente um objeto da classe pai para existir na memória.
     *    Sintaxe de instanciação: outerObject.new InnerClass();
     * 3. Diferenciação de escopo ('this'):
     *    - 'this': Refere-se aos membros da própria classe interna.
     *    - 'OuterClass.this': Refere-se aos membros da instância da classe externa pai.
     * =========================================================================================
     */

    private final String NOME = "Davi";

    class Inner {
        public void printOuterClassAtributte(){
            System.out.println(NOME);
            System.out.println(this);
            System.out.println(OuterClassesTest01.this);
        }
    }

    public static void main(String[] args) {
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        OuterClassesTest01.Inner inner = outerClass.new Inner();
        Inner inner2 = new OuterClassesTest01().new Inner();

        inner.printOuterClassAtributte();
        System.out.println("-------------------");
        inner2.printOuterClassAtributte();
    }
}
