package exercicio003.main;

import exercicio003.dominio.Transacao;
import exercicio003.exceptions.TransacaoInvalidaException;

import java.io.IOException;
import java.nio.file.*;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Path transacoesFile = Paths.get("exercises/exercicio003/transacoes.txt");

        System.out.println(">>>>>>>> LOGS DE LEITURA: ");
        try {
            List<String> listLines = Files.readAllLines(transacoesFile);

            Set<Transacao<String>> setTransacoes = new HashSet<>();
            for (int i = 0; i < listLines.size(); i++){
                try{
                    String[] itensLine = listLines.get(i).split(";");
                    int line = i + 1;

                    if (itensLine.length != 5){
                        throw new TransacaoInvalidaException("A linha de leitura " + line + " está sem a quantidade de parâmetros necessários (5) ou está corrompido.");
                    }

                    double value = 0;
                    try{
                        value = Double.parseDouble(itensLine[3]);
                    } catch (NumberFormatException e){
                        throw new TransacaoInvalidaException("A linha de leitura " + line + " está com seu valor contendo caracteres diferentes de números.");
                    }

                    if (value < 0){
                        throw new TransacaoInvalidaException("A linha de leitura " + line + " tem valor de transação negativo.");
                    }

                    String id = itensLine[0];
                    String conta  = itensLine[1];
                    LocalDateTime dataHora = LocalDateTime.parse(itensLine[2]);
                    String categoria = itensLine[4];

                    Transacao<String> transacao = new Transacao<>(id, conta, dataHora, value, categoria);
                    setTransacoes.add(transacao);

                    System.out.println("  Sucesso! Linha " + line + " lida com sucesso.");
                } catch (TransacaoInvalidaException e) {
                    System.out.println("  ERRO: " + e.getMessage());
                }
            }

            Map<String, List<Transacao<String>>> mapTransacoes = new HashMap<>();
            for (Transacao<String> transacao : setTransacoes){
                if (!mapTransacoes.containsKey(transacao.getCategoria())){
                    mapTransacoes.put(transacao.getCategoria(), new ArrayList<>());
                }

                mapTransacoes.get(transacao.getCategoria()).add(transacao);
            }

            for (String key : mapTransacoes.keySet()) {
                List<Transacao<String>> transacoes = mapTransacoes.get(key);

                transacoes.sort(new Comparator<Transacao<String>>() {
                    @Override
                    public int compare(Transacao<String> o1, Transacao<String> o2) {
                        Double valueO1 = o1.getValor();
                        Double valueO2 = o2.getValor();

                        return valueO1.compareTo(valueO2);
                    }
                });
            }

            Path relatorioFile = Paths.get("exercises/exercicio003/relatorio_financeiro.txt");

            if(Files.notExists(relatorioFile)){
                Files.createFile(relatorioFile);
            }

            List<String> relatorio = new ArrayList<>();
            relatorio.add("============= RELATÓRIO DE TRANSAÇÕES AUDIDATAS =============\n");

            DateTimeFormatter patternBR = DateTimeFormatter.ofPattern("dd/MM/yyyy '-' HH:mm");
            Locale localeBR = new Locale("pt", "BR");
            NumberFormat currency = NumberFormat.getCurrencyInstance(localeBR);
            for (Map.Entry<String, List<Transacao<String>>> entry : mapTransacoes.entrySet()){
                relatorio.add("> CATEGORIA: " + entry.getKey().toUpperCase() + ": ");

                for (Transacao<String> transacao : entry.getValue()) {
                    String id = transacao.getId();
                    String conta = transacao.getConta();
                    String dataHoraFormatada = transacao.getDataHora().format(patternBR);
                    String valorFormatado = currency.format(transacao.getValor());
                    String categoria = transacao.getCategoria();

                    relatorio.add(" - [" + id + "] Valor: " + valorFormatado + " | Data: " + dataHoraFormatada + " | Conta: " + conta);
                }
                relatorio.add("");
            }

            Files.write(relatorioFile, relatorio);
            System.out.println("SUCESSO! Relatório criado com sucesso.");
        } catch (IOException e) {
            System.out.println(" ERRO: " + e.getMessage());
        }
    }
}