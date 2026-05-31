package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Endereco;
import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Pessoa;

public class HerancaTest01 {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setRua("Rua dos Canudos");
        endereco.setCep("39495-000");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Davi");
        pessoa.setCpf("345919111-90");
        pessoa.setEndereco(endereco);
        pessoa.imprime();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Davi");
        funcionario.setCpf("119.112.998-80");
        funcionario.setEndereco(endereco);
        funcionario.setSalario(1512);
        System.out.println("-----------------------------------------------");
        funcionario.imprime();
    }
}
