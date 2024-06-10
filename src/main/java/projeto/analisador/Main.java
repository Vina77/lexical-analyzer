package projeto.analisador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("Entrada.txt"))) {
            StringBuilder codigo = new StringBuilder();
            String linha;
            while ((linha = br.readLine())!= null) {
                codigo.append(linha).append("\n");
            }

            AnalisadorLexico lexico = new AnalisadorLexico(codigo.toString());
            Token token;

            // "|Posicao|",  %-10s
            System.out.printf("%-15s %-10s %-20s\n", "|Lexema|",  "|Codigo|", "|Descricao|");
            System.out.println("-----------------------------------------------------------");

            //token.getPosicao(),  %-10d
            do {
                token = lexico.proximoToken();
                if (token!= null) {
                    String descricao = Descricao.getDescricao(token);
                    System.out.printf("%-15s %-10d %-20s\n", token.getLexema(), token.getCodigo(), descricao);
                    System.out.println("-----------------------------------------------------------");
                }
            } while (token == null || token.getCodigo()!= 0);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo 'entrada.txt'");
            e.printStackTrace();
        }
    }
}
