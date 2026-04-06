package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais02 {
    public static void main(String[] args) {
        // idade < 15 categoria infantil
        // idade >= 15 && idade < 18 categoria juvenil
        // idade >= 18 categoria adulto

        int idade = 17;
        String categoria;

        if(idade < 15){
            categoria = "Usuário encontrado. Categoria: Infatil";
        } else if(idade >= 15 && idade < 18) {
            categoria = "Usuário encontrado. Categoria: Juvenil";
        } else {
            categoria = "Usuário encontrado. Categoria: Adulto";
        } //Usando else if para casos de mais de 2 condições

        System.out.println(categoria);
    }
}
