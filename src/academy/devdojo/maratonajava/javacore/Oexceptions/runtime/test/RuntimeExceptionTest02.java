package academy.devdojo.maratonajava.javacore.Oexceptions.runtime.test;

public class RuntimeExceptionTest02 {
    public static void main(String[] args) {
        try{
            double divisao = divide(1, 2);
            System.out.println(divisao);
        } catch (RuntimeException e){
            e.printStackTrace();
        }

        System.out.println("Código finalizado.");
    }

    private static double divide(double a, double b) throws IllegalArgumentException {
        if (b == 0){
            throw new IllegalArgumentException("Argumento ilegal, não pode ser 0.");
        }
        return a / b;
    }
}
