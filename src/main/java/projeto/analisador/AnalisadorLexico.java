package projeto.analisador;

import java.util.HashMap;
import java.util.Map;

public class AnalisadorLexico {

    private static final int token_eof = 0;
    private static final int token_identificador = 1;
    private static final int token_inicio = 2;
    private static final int token_fim = 3;   
    private static final int token_leia = 4;
    private static final int token_imprima = 5;   
    private static final int token_se = 6;
    private static final int token_entao = 7;
    private static final int token_senao = 8;
    private static final int token_fim_se = 9;
    private static final int token_para = 10;
    private static final int token_ate = 11;
    private static final int token_passo = 12;
    private static final int token_fim_para = 13;
    private static final int token_inteiro = 14;
    private static final int token_numero = 15;
    private static final int token_string = 16;
    private static final int token_operador = 17;
    private static final int token_atribuicao = 18;
    private static final int token_definicao = 19;
    private static final int token_delimitador = 20;


    static final Map<String, Integer> palavrasReservadas = new HashMap<>();
    private static final Map<String, Integer> tabelaSimbolos = new HashMap<>();

    static {
        palavrasReservadas.put("inicio", token_inicio);
        palavrasReservadas.put("fim", token_fim);
        palavrasReservadas.put("leia", token_leia);
        palavrasReservadas.put("imprima", token_imprima);
        palavrasReservadas.put("se", token_se);
        palavrasReservadas.put("então", token_entao);
        palavrasReservadas.put("senão", token_senao);
        palavrasReservadas.put("fim_se", token_fim_se);
        palavrasReservadas.put("para", token_para);
        palavrasReservadas.put("até", token_ate);
        palavrasReservadas.put("passo", token_passo);
        palavrasReservadas.put("fim_para", token_fim_para);
        palavrasReservadas.put("inteiro", token_inteiro);    
    }

    private static String codigoFonte;
    private static int posicaoAtual;

    public AnalisadorLexico(String codigo) {
        codigoFonte = codigo;
        posicaoAtual = 0;
    }

    private char proxChar() {
        if (posicaoAtual < codigoFonte.length()) {
            return codigoFonte.charAt(posicaoAtual++);
        }
        return '\0'; // EOF
    }

    private void voltar() {
        if (posicaoAtual > 0) posicaoAtual--;
    }

    private boolean isLetra(char c) {
        return Character.isLetter(c);
    }

    private boolean isDigito(char c) {
        return Character.isDigit(c);
    }

    private boolean isEspaco(char c) {
        return Character.isWhitespace(c);
    }

    private boolean isIdentificadorChar(char c) {
        return isLetra(c) || isDigito(c) || c == '_';
    }

    private int buscarPalavraReservada(String palavra) {
        return palavrasReservadas.getOrDefault(palavra, -1);
    }

    public Token proximoToken() {
        StringBuilder lexema = new StringBuilder();
        char c;

        do {
            c = proxChar();
        } while (isEspaco(c));

        if (c == '\0') {
            return new Token(token_eof, "EOF", -1);
        }

        if (c == '\"') {
            c = proxChar();
            while (c!= '\"') {
                lexema.append(c);
                c = proxChar();
            }
            return new Token(token_string, lexema.toString(), -1);
        }

        if (isLetra(c)) {
            while (isIdentificadorChar(c)) {
                lexema.append(c);
                c = proxChar();
            }
            voltar();
            String palavra = lexema.toString();
            int codigo = buscarPalavraReservada(palavra);
            if (codigo == -1) {
                if (!tabelaSimbolos.containsKey(palavra)) {
                    tabelaSimbolos.put(palavra, tabelaSimbolos.size());
                }
                return new Token(token_identificador, palavra, tabelaSimbolos.get(palavra));
            }
            return new Token(codigo, palavra, -1);
        }

        if (isDigito(c)) {
            while (isDigito(c)) {
                lexema.append(c);
                c = proxChar();
            }
            voltar();
            return new Token(token_numero, lexema.toString(), -1);
        }

        if ("+-/*()<>:;=".indexOf(c)!= -1) {
            lexema.append(c);
            if (c == '<' && proxChar() == '-') {
                lexema.append('-');
                return new Token(token_atribuicao, lexema.toString(), -1);
            } else if (c == '<' || c == '>') {
                c = proxChar();
                if (c == '=') {
                    lexema.append(c);
                } else {
                    voltar();
                }
            } else if (c == ':') {
                return new Token(token_definicao, lexema.toString(), -1);
            } else if (c == ';') {
                return new Token(token_delimitador, lexema.toString(), -1);
            }
            return new Token(token_operador, lexema.toString(), -1);
        }

        return null;
    }
}
