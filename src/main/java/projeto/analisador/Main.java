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

            // Agora, 'codigo' contém todo o conteúdo do arquivo 'entrada.txt'
            // Você pode continuar com o restante do seu código aqui, usando 'codigo' como entrada

            AnalisadorLexico lexico = new AnalisadorLexico(codigo.toString());
            Token token;

            System.out.printf("%-10s %-15s %-10s %-20s\n", "|Código|", "|Lexema|", "|Posição|", "|Descrição|");
            System.out.println("-----------------------------------------------------------");

            do {
                token = lexico.proximoToken();
                if (token!= null) {
                    String descricao = Descricao.getDescricao(token);
                    System.out.printf("%-10d %-15s %-10d %-20s\n", token.getCodigo(), token.getLexema(), token.getPosicao(), descricao);
                    System.out.println("-----------------------------------------------------------");
                }
            } while (token == null || token.getCodigo()!= 0);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo 'entrada.txt'");
            e.printStackTrace();
        }
    }
}
