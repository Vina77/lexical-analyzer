# Lexical Analyzer
---
The project consists of a lexical analyzer that identifies the language tokens and creates the symbol table. The main function simulates the syntactic analyzer, successively calling the lexical analyzer and displaying on the standard output the found token (code), its position in the table, and the type of the token.
---
## Example - 1
```
inicio
  inteiro:a;
  imprima (“digite um valor para a:”);
  leia(a);
  se a = 5
  então
    escreva (“igual a 5”);
  senão
    escreva (“diferente de 5”);
  fim_se
fim
```
---
## Example - 2
```
inicio
  inteiro:b;
  inteiro:c;
  imprima (“digite um valor para c:”);
  leia(c);
  para b=0 até c passo 2
    imprima(b);
  fim_para
fim
```
---
