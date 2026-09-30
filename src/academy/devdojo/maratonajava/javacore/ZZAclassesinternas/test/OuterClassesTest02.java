package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest02 {
    /*
     * =========================================================================================
     * CLASSES LOCAIS (LOCAL CLASSES)
     * =========================================================================================
     *
     * O QUE É:
     * É uma classe declarada dentro do corpo de um método ou bloco de código.
     *
     * PARA QUE SERVE E ONDE USAR:
     * Serve para isolar uma lógica temporária e específica que só é necessária durante a execução
     * daquele método. O restante da aplicação (e a própria classe externa fora do método) não
     * possui conhecimento da existência dessa classe.
     *
     * REGRAS E FUNCIONAMENTO:
     * 1. Escopo Restrito: Visível e utilizável apenas dentro do método onde foi declarada. Deve ser
     *    instanciada e executada dentro do próprio método.
     * 2. Sem Modificadores: Não pode receber modificadores de acesso (public, private, protected) nem 'static'.
     * 3. Regra do Effectively Final: Pode acessar variáveis locais do método APENAS se elas forem 'final'
     *    ou 'effectively final' (variáveis cujo valor nunca é alterado após a inicialização).
     * 4. Acesso ao Pai: Acessa normalmente atributos da classe externa.
     * =========================================================================================
     */

    private final String NOME = "Midoriya";

    void print(){
        String lastName = "Izuku";
        class LocalClass {
            void printLocal(){
                System.out.println(NOME + " " + lastName);
            }
        }

        new LocalClass().printLocal();
    }

    public static void main(String[] args) {
        OuterClassesTest02 outer = new OuterClassesTest02();
        outer.print();
    }
}
