package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.dominio.Carro;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro carro = new Carro();

        carro.nome = "Volkswagen";
        carro.modelo = "Gol";
        carro.ano = 2023;

        Carro carro2 = new Carro();

        carro2.nome = "Fiat";
        carro2.modelo = "Argo";
        carro2.ano = 2021;

        System.out.println("================================ Lista de Carros ================================");
        System.out.println("=> Nome: " + carro.nome + " |" + " Modelo: " + carro.modelo + " |" + " Ano: " + carro.ano);
        System.out.println("=> Nome: " + carro2.nome + " |" + " Modelo: " + carro2.modelo + " |" + " Ano: " + carro2.ano);

    }
}
