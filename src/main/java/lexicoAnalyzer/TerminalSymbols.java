package lexicoAnalyzer;

import java.util.HashMap;
import java.util.Map;

public class TerminalSymbols {

    public static final Map<String, Symbol> Symbols;

    static {

        Symbols = new HashMap<String, Symbol>();

        // Delimitadores
        Symbols.put("$", new Symbol(1, "$", "Fim de arquivo"));

        // Operadores
        Symbols.put("+", new Symbol(2, "+", "Operador de adição"));
        Symbols.put("-", new Symbol(3, "-", "Operador de subtração"));
        Symbols.put("*", new Symbol(4, "*", "Operador de multiplicação"));
        Symbols.put("/", new Symbol(5, "/", "Operador de divisão"));
        Symbols.put("=", new Symbol(6, "=", "Igual"));
        Symbols.put(">", new Symbol(7, ">", "Maior"));
        Symbols.put(">=", new Symbol(8, ">=", "Maior ou igual"));
        Symbols.put("<", new Symbol(9, "<", "Menor"));
        Symbols.put("<=", new Symbol(10, "<=", "Menor ou igual"));
        Symbols.put("<>", new Symbol(11, "<>", "Diferente"));

        // S�mbolos especiais
        Symbols.put(":=", new Symbol(12, ":=", "Atribuição"));
        Symbols.put(":", new Symbol(13, ":", "Dois Pontos"));
        Symbols.put(";", new Symbol(14, ";", "Ponto e Virgula"));
        Symbols.put(",", new Symbol(15, ",", "Virgula"));
        Symbols.put(".", new Symbol(16, ".", "Ponto"));
        Symbols.put("(", new Symbol(17, "(", "Abre Parentese"));
        Symbols.put(")", new Symbol(18, ")", "Fecha Parentese"));

        // Palavras reservadas
        Symbols.put("PROGRAM", new Symbol(22, "PROGRAM", "Palavra reservada"));
        Symbols.put("CONST", new Symbol(23, "CONST", "Palavra reservada"));
        Symbols.put("VAR", new Symbol(24, "VAR", "Palavra reservada"));
        Symbols.put("PROCEDURE", new Symbol(25, "PROCEDURE", "Palavra reservada"));
        Symbols.put("BEGIN", new Symbol(26, "BEGIN", "Palavra reservada"));
        Symbols.put("END", new Symbol(27, "END", "Palavra reservada"));
        Symbols.put("INTEGER", new Symbol(28, "INTEGER", "Palavra reservada"));
        Symbols.put("OF", new Symbol(29, "OF", "Palavra reservada"));
        Symbols.put("CALL", new Symbol(30, "CALL", "Palavra reservada"));
        Symbols.put("IF", new Symbol(31, "IF", "Palavra reservada"));
        Symbols.put("THEN", new Symbol(32, "THEN", "Palavra reservada"));
        Symbols.put("ELSE", new Symbol(33, "ELSE", "Palavra reservada"));
        Symbols.put("WHILE", new Symbol(34, "WHILE", "Palavra reservada"));
        Symbols.put("DO", new Symbol(35, "DO", "Palavra reservada"));
        Symbols.put("REPEAT", new Symbol(36, "REPEAT", "Palavra reservada"));
        Symbols.put("UNTIL", new Symbol(37, "UNTIL", "Palavra reservada"));
        Symbols.put("READLN", new Symbol(38, "READLN", "Palavra reservada"));
        Symbols.put("WRITELN", new Symbol(39, "WRITELN", "Palavra reservada"));
        Symbols.put("OR", new Symbol(40, "OR", "Palavra reservada"));
        Symbols.put("AND", new Symbol(41, "AND", "Palavra reservada"));
        Symbols.put("NOT", new Symbol(42, "NOT", "Palavra reservada"));
        Symbols.put("FOR", new Symbol(43, "FOR", "Palavra reservada"));
        Symbols.put("TO", new Symbol(44, "TO", "Palavra reservada"));
        Symbols.put("CASE", new Symbol(45, "CASE", "Palavra reservada"));
    }
}