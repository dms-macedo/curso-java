package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest01 {
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
