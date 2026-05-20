package introduction.projetoSimples.dominios;

import java.text.NumberFormat;
import java.util.Locale;

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
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat formatNumber = NumberFormat.getCurrencyInstance(localeBR);
        String valorFormatado = formatNumber.format(valor);

        System.out.println("Sucesso! " +  valor + " adicionado ao saldo do Cliente.");
    }

    public void adicionarSaldo(double valor, String codigoPromocional){
        if(valor < 0) {
            System.out.println("ERRO: O valor não pode ser negativo.");
            return;
        }

        String codigo = "SPACE2026";
        if(codigo.equals(codigoPromocional)){
            double valorPercent = valor + (valor * 0.20);
            this.saldo += valorPercent;

            Locale localeBR = new Locale("pt", "BR");
            NumberFormat formatNumber = NumberFormat.getCurrencyInstance(localeBR);
            String valorFormatado = formatNumber.format(valorPercent);

            System.out.println("Sucesso! " +  valorFormatado + " adicionado ao saldo do Cliente.");
        } else {
            System.out.println("Código Promocional inválido. Adicionado valor normal atribuído.");
            this.saldo += valor;

            Locale localeBR = new Locale("pt", "BR");
            NumberFormat formatNumber = NumberFormat.getCurrencyInstance(localeBR);
            String valorFormatado = formatNumber.format(valor);

            System.out.println("Sucesso! " +  valor + " adicionado ao saldo do Cliente.");
        }
    }

    public void comprarJogo(Jogo jogo) {
        if (jogo == null) {
            System.out.println("ERRO: Jogo inválido.");
            return;
        }

        if (this.saldo >= jogo.getPreco()) {
            boolean adicionado = false;

            for (int i = 0; i < this.biblioteca.length; i++) {
                if (this.biblioteca[i] == jogo) {
                    System.out.println("ERRO: O cliente já adquiriu esse jogo. Está disponível na biblioteca.");
                    return;
                }

                if (this.biblioteca[i] == null) {
                    this.saldo -= jogo.getPreco();
                    this.biblioteca[i] = jogo;
                    adicionado = true;
                    System.out.println("=========================================================");
                    System.out.println("Compra realizada com sucesso!");
                    System.out.println("=> Jogo: " + jogo.getNome());
                    System.out.println("=> Preço: " + jogo.getPreco());
                    System.out.println("=========================================================");
                    break;
                }
            }

            if (!adicionado) {
                System.out.println("ERRO: A biblioteca do cliente está cheia. (100 Jogos)");
            }
        } else {
            System.out.println("ERRO: Saldo insuficiente.");
        }
    }

    public void imprimirPerfil(){
        System.out.println("=========================================================");
        System.out.println("=> Nome: " +  this.nickname);

        Locale localeBR = new Locale("pt", "BR");
        NumberFormat formater = NumberFormat.getCurrencyInstance(localeBR);
        String saldoFormatado = formater.format(this.saldo);
        System.out.println("=> Saldo da Conta: " + saldoFormatado);

        System.out.println("=> Biblioteca de Jogos: ");
        for (int i = 0; i < this.biblioteca.length; i++) {
            if (this.biblioteca[i] != null){
                int posicao = i + 1;
                System.out.println("    | Jogo " + posicao + ": " + this.biblioteca[i].getNome());
            }
        }
        System.out.println("=========================================================");
    }

    public String getNickname() {
        return this.nickname;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public Jogo[] getBiblioteca() {
        return this.biblioteca.clone();
    }
}
