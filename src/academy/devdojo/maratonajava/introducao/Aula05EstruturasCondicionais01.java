package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais01 {
    public static void main(String[] args) {
        int idade = 15;
        boolean isAutorizadoComprarBebida = idade >= 18;

        if(isAutorizadoComprarBebida){
            System.out.println("Venda autorizada de bebida alcólica.");
        } else {
            System.out.println("Venda Negada! Menor de Idade detectado.");
        }

        if (!isAutorizadoComprarBebida){ // Podemos usar ! antes da variavel para inverter o valor booleano
            System.out.println("Venda Negada! Menor de Idade detectado.");
        } // basicamente um else do primeiro if

        // Nunca fazer
        boolean c = false;
        if(c = true) {
            System.out.println("Nunca fazer este modelo de condição!");
        }


    }
}
