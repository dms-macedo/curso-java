package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.ArrayList;
import java.util.List;

public class BarcoRentavelService {
    private List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Iate"), new Barco("Lancha"), new Barco("Cruzeiro")));

    public Barco buscarBarcoDisponivel() {
        System.out.println("Buscando Barco disponivel...");
        Barco barco = barcosDisponiveis.remove(0);
        System.out.println("Alugando Barco: " + barco);
        System.out.println("Barcos Disponíveis: ");
        System.out.println(barcosDisponiveis);
        return barco;
    }

    public void retornarBarcoALugado(Barco Barco){
        System.out.println("Devolvendo Barco: " + Barco);
        barcosDisponiveis.add(Barco);
        System.out.println("Barcos disponíveis ṕara alugar: ");
        System.out.println(barcosDisponiveis);
    }
}

