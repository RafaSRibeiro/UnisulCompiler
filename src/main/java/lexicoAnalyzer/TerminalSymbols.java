package lexicoAnalyzer;

import syntacticAnalyzer.Constants;

import java.util.HashMap;
import java.util.Map;

public class TerminalSymbols {

    public static final Map<String, Symbol> Symbols;

    static {

        Symbols = new HashMap<String, Symbol>();

        // Delimitadores
        Symbols.put("$", new Symbol(Constants.DOLLAR, "$", "Fim de arquivo"));

        // Operadores
        Symbols.put("+", new Symbol(Constants.t_TOKEN_2, "+", "Operador de adição"));
        Symbols.put("-", new Symbol(Constants.t_TOKEN_3, "-", "Operador de subtração"));
        Symbols.put("*", new Symbol(Constants.t_TOKEN_4, "*", "Operador de multiplicação"));
        Symbols.put("/", new Symbol(Constants.t_TOKEN_5, "/", "Operador de divisão"));
        Symbols.put("=", new Symbol(Constants.t_TOKEN_6, "=", "Igual"));
        Symbols.put(">", new Symbol(Constants.t_TOKEN_7, ">", "Maior"));
        Symbols.put(">=", new Symbol(Constants.t_TOKEN_8, ">=", "Maior ou igual"));
        Symbols.put("<", new Symbol(Constants.t_TOKEN_9, "<", "Menor"));
        Symbols.put("<=", new Symbol(Constants.t_TOKEN_10, "<=", "Menor ou igual"));
        Symbols.put("<>", new Symbol(Constants.t_TOKEN_11, "<>", "Diferente"));

        // S�mbolos especiais
        Symbols.put(":=", new Symbol(Constants.t_TOKEN_12, ":=", "Atribuição"));
        Symbols.put(":", new Symbol(Constants.t_TOKEN_13, ":", "Dois Pontos"));
        Symbols.put(";", new Symbol(Constants.t_TOKEN_14, ";", "Ponto e Virgula"));
        Symbols.put(",", new Symbol(Constants.t_TOKEN_15, ",", "Virgula"));
        Symbols.put(".", new Symbol(Constants.t_TOKEN_16, ".", "Ponto"));
        Symbols.put("(", new Symbol(Constants.t_TOKEN_17, "(", "Abre Parentese"));
        Symbols.put(")", new Symbol(Constants.t_TOKEN_18, ")", "Fecha Parentese"));

        // Palavras reservadas
        Symbols.put("PROGRAM", new Symbol(Constants.t_PROGRAM, "PROGRAM", "Palavra reservada"));
        Symbols.put("CONST", new Symbol(Constants.t_CONST, "CONST", "Palavra reservada"));
        Symbols.put("VAR", new Symbol(Constants.t_VAR, "VAR", "Palavra reservada"));
        Symbols.put("PROCEDURE", new Symbol(Constants.t_PROCEDURE, "PROCEDURE", "Palavra reservada"));
        Symbols.put("BEGIN", new Symbol(Constants.t_BEGIN, "BEGIN", "Palavra reservada"));
        Symbols.put("END", new Symbol(Constants.t_END, "END", "Palavra reservada"));
        Symbols.put("INTEGER", new Symbol(Constants.t_INTEGER, "INTEGER", "Palavra reservada"));
        Symbols.put("OF", new Symbol(Constants.t_OF, "OF", "Palavra reservada"));
        Symbols.put("CALL", new Symbol(Constants.t_CALL, "CALL", "Palavra reservada"));
        Symbols.put("IF", new Symbol(Constants.t_IF, "IF", "Palavra reservada"));
        Symbols.put("THEN", new Symbol(Constants.t_THEN, "THEN", "Palavra reservada"));
        Symbols.put("ELSE", new Symbol(Constants.t_ELSE, "ELSE", "Palavra reservada"));
        Symbols.put("WHILE", new Symbol(Constants.t_WHILE, "WHILE", "Palavra reservada"));
        Symbols.put("DO", new Symbol(Constants.t_DO, "DO", "Palavra reservada"));
        Symbols.put("REPEAT", new Symbol(Constants.t_REPEAT, "REPEAT", "Palavra reservada"));
        Symbols.put("UNTIL", new Symbol(Constants.t_UNTIL, "UNTIL", "Palavra reservada"));
        Symbols.put("READLN", new Symbol(Constants.t_READLN, "READLN", "Palavra reservada"));
        Symbols.put("WRITELN", new Symbol(Constants.t_WRITELN, "WRITELN", "Palavra reservada"));
        Symbols.put("OR", new Symbol(Constants.t_OR, "OR", "Palavra reservada"));
        Symbols.put("AND", new Symbol(Constants.t_AND, "AND", "Palavra reservada"));
        Symbols.put("NOT", new Symbol(Constants.t_NOT, "NOT", "Palavra reservada"));
        Symbols.put("FOR", new Symbol(Constants.t_FOR, "FOR", "Palavra reservada"));
        Symbols.put("TO", new Symbol(Constants.t_TO, "TO", "Palavra reservada"));
        Symbols.put("CASE", new Symbol(Constants.t_CASE, "CASE", "Palavra reservada"));
    }
}