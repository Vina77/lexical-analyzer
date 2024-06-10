package projeto.analisador;

public class Descricao {

    public static String getDescricao(Token token) {
        String lexema = token.getLexema();

        if ("+-*/= <> <= >= e ou xou nao".contains(lexema)) {
            return "Operador";
        }

        if (lexema.matches("\\d+(\\.\\d+)?")) {
            return "Numerico";
        }

        if (token.getCodigo() == 20) {
            return "Literal";
        }

        if (".,;:(){}[]".contains(lexema)) {
            return "Delimitador";
        }

        if (lexema.startsWith("//") || (lexema.startsWith("/*") && lexema.endsWith("*/"))) {
            return "Comentario";
        }

        if (AnalisadorLexico.palavrasReservadas.containsKey(lexema)) {
            return "Palavra Reservada";
        }

        return "Variavel/Identificador";
    }
}
