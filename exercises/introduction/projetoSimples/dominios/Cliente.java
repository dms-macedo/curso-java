package introduction.projetoSimples.dominios;

import java.util.Objects;

public class Cliente {
    private String nickname;
    private double saldo;
    private Jogo[] biblioteca = new Jogo[100];

    public Cliente(String nickname) {
        if (nickname == null || nickname.trim().isEmpty()){
            System.out.println("ERRO: O nome não pode ser nulo ou estar vazio. Atribuindo valor padrão.");
            this.nickname = "Nome Desconhecido";
        } else {
            this.nickname = nickname;
        }
    }

    public void adicionarSaldo(double valor) {
        if(valor < 0) {
            System.out.println("ERRO: O valor não pode ser negativo.");
            return;
        }

        this.saldo += valor;
    }

    public void adicionarSaldo(double valor, String codigoPromocional){
        if(valor < 0) {
            System.out.println("ERRO: O valor não pode ser negativo.");
            return;
        }

        String codigo = "SPACE2026";
        if(codigo.equals(codigoPromocional)){
            this.saldo += valor + (valor * 0.20);
        } else {
            System.out.println("Código Promocional inválido. Adicionado valor normal atribuído.");
            this.saldo += valor;
        }
    }
}
