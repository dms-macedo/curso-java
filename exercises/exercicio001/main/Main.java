package exercicio001.main;

import exercicio001.exceptions.LogCorrompidoException;
import exercicio001.service.RegistroAcesso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path catracaFile = Paths.get("/home/dms_macedo/IdeaProjects/curso-java/exercises/exercicio001/catraca.txt");
        List<RegistroAcesso<String>> registrosValidos = new ArrayList<>();

        System.out.println("> Compilação: ");
        try {
            List<String> linesFile = Files.readAllLines(catracaFile);

            for (int i = 0; i < linesFile.size(); i++){
                String[] itensLine;
                try {
                    int linha = i + 1;
                    itensLine = linesFile.get(i).split(";");
                    if(itensLine.length != 3) {
                        throw new LogCorrompidoException("A linha " + linha + ", tem parâmetros insuficientes (3) ou é corrompido.");
                    }
                    System.out.println("Linha " + linha + " lida com sucesso.");
                    LocalDateTime dateTimeLog = LocalDateTime.parse(itensLine[1], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    RegistroAcesso<String> registro = new RegistroAcesso<>(itensLine[0], dateTimeLog, itensLine[2]);
                    registrosValidos.add(registro);
                } catch (LogCorrompidoException e) {
                    System.out.println("ERRO: " + e.getMessage());
                }


            }
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        registrosValidos.sort(new Comparator<>() {
            @Override
            public int compare(RegistroAcesso<String> o1, RegistroAcesso<String> o2) {
                return o2.getData_hora().compareTo(o1.getData_hora());
            }
        });

        System.out.println("\n--------------------------------------------------------\n");
        System.out.println("> Logs: ");
        for (RegistroAcesso<String> registro : registrosValidos){
            DateTimeFormatter patternBR = DateTimeFormatter.ofPattern("dd/MM/yyyy '-' HH:mm");
            String dataHoraFormatted = registro.getData_hora().format(patternBR);
            System.out.println("ID: " + registro.getId() + " | " + "DATA/HORA: " + dataHoraFormatted + " | " + "Tipo de Acesso: " + registro.getTipoAcesso());
        }
    }
}
