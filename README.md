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

### Installation Instructions
1. Java Development Kit (JDK): Ensure that the Java Development Kit (JDK) is installed on your system. You can check this by running java -version and javac -version in your terminal or command prompt. If Java is not installed, download and install it from the official Oracle website.

2. Clone the Repository: Clone the project repository to your local machine using Git. Run the following command in your terminal or command prompt:

3. Navigate to the Project Directory: Change your current directory to the cloned project directory:

##
### Execution Instructions
1. Compile the Java Application: Compile the Java source files into bytecode using the javac command. Assuming your main class is named Main, run:
```
  javac Main.java
```

2. Run the Java Application: Execute the compiled Java application using the java command:
```
  java Main
```
##
