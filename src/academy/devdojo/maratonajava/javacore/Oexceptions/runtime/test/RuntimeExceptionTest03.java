package academy.devdojo.maratonajava.javacore.Oexceptions.runtime.test;

public class RuntimeExceptionTest03 {
    public static void main(String[] args) {
        abreConexao2();
    }

    private static String abreConexao() {
        try{
            System.out.println("Abrindo arquivo...");
            System.out.println("Escrevendo dados no arquivo...");
            return "conexão feita";
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("Fechando o recurso...");
        }

        return null;
    }
    private static void abreConexao2() {
        try{
            System.out.println("Abrindo arquivo...");
            System.out.println("Escrevendo dados no arquivo...");
            throw new RuntimeException();
        } finally {
            System.out.println("Fechando o recurso...");
        }
    }

}
