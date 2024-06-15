# Lexical Analyzer

The project consists of a lexical analyzer that identifies the language tokens and creates the symbol table. The main function simulates the syntactic analyzer, successively calling the lexical analyzer and displaying on the standard output the found token (code), its position in the table, and the type of the token.

The input language is the Brazilian programming language “Portugol”. This language is often used in educational settings in Brazil to teach the basics of programming. It’s designed to be simple and easy to understand, making it a great starting point for beginners.

The input is made through the file "Entrada.txt".

### The tokens that will be identified by the lexical analyzer are:

## Reserved Words:
- "EOF"
- "inicio"
- "fim"
- "leia"
- "imprima"
- "se"
- "entao"
- "senao"
- "fim_se"
- "para"
- "ate"
- "passo"
- "fim_para"  
- "enquanto"
- "fim_enquanto"
- "faca"
- "pare"
- "inteiro"

## Data types: 
- "Numéricos"
- "Inteiros"
- Literais (string)"
  
## Operators: 
- **Arithmetic:** +, -, *, /
- **Relational:** <, >, <=, >=, =
- **Logical:** e, ou, xou, nao

## Delimiters: 
- ( )
- [ ]
- { }
- ;
- ,

## Comments:
- /* */
- //

## These are two examples of inputs:

### Example - 1
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
## 
### Example - 2
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
##
