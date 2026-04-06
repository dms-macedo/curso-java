package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais {
    public static void main(String[] args) {
        int idade = 15;
        boolean isAutorizadoComprarBebida = idade >= 18;

        if(isAutorizadoComprarBebida){
            System.out.println("Venda autorizada de bebida alcólica.");
        }

        if (!isAutorizadoComprarBebida){ // Podemos usar ! antes da variavel para inverter o valor booleano
            System.out.println("Venda Negada! Menor de Idade detectado.");
        }

        // Nunca fazer
        boolean c = false;
        if(c = true) {
            System.out.println("Nunca fazer este modelo de condição!");
        }
    }
}
