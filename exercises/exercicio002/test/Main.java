package exercicio002.test;

import exercicio002.dominio.Pacote;
import exercicio002.exceptions.PacoteInvalidoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Path entregasFile = Paths.get("exercises/exercicio002/entregas.txt");
        Map<String, List<Pacote<String>>> mapPacotes = new HashMap<>();

        try {
            List<String> linesFile = Files.readAllLines(entregasFile);
            Set<Pacote<String>> pacotesFiltrados = new HashSet<>();

            System.out.println(">>>>>>> LOGS DE LEITURA:");
            for (int i = 0; i < linesFile.size(); i++){
                try {
                    String[] itensLine = linesFile.get(i).split(";");
                    int line = i + 1;

                    if (itensLine.length != 4){
                        throw new PacoteInvalidoException("A linha " + line + " tem parâmetros insuficientes ou está corrompido.");
                    }

                    LocalDateTime ldt = LocalDateTime.parse(itensLine[2]);
                    Pacote<String> pacote = new Pacote<>(itensLine[0], itensLine[1], ldt, itensLine[3]);
                    pacotesFiltrados.add(pacote);

                    System.out.println("  Linha " + line + " lida com sucesso.");
                } catch (PacoteInvalidoException e){
                    System.out.println("  ERRO: " + e.getMessage());
                }
            }

            for (Pacote<String> pacote : pacotesFiltrados){
                String regiao = pacote.getRegiao();

                if (!mapPacotes.containsKey(regiao)){
                    mapPacotes.put(regiao, new ArrayList<>());
                }

                mapPacotes.get(regiao).add(pacote);
            }

            for (String chave : mapPacotes.keySet()) {
                List<Pacote<String>> pacotes = mapPacotes.get(chave);

                pacotes.sort(new Comparator<Pacote<String>>() {
                    @Override
                    public int compare(Pacote<String> o1, Pacote<String> o2) {
                        return o1.getDataDespacho().compareTo(o2.getDataDespacho());
                    }
                });
            }

        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        System.out.println("\n----------------------------------------------\n");
        System.out.println(">>>>>>> ENTREGAS:");
        DateTimeFormatter patternBR = DateTimeFormatter.ofPattern("dd/MM/yyyy '-' HH:mm");
        for (Map.Entry<String, List<Pacote<String>>> entry : mapPacotes.entrySet()){
            System.out.println("  > REGIÃO " + entry.getKey().toUpperCase() + ": ");

            for (Pacote<String> pacote : entry.getValue()) {
                String codigoRastreio = pacote.getCodigo();
                String dataHoraFormatada = pacote.getDataDespacho().format(patternBR);
                String status = pacote.getStatus();

                System.out.println("      Código de Rastreio: " + codigoRastreio + " | Data de Despacho: " + dataHoraFormatada + " | Status: " + status);
            }
            System.out.println();
        }
    }
}