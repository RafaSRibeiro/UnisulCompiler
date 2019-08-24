package lexicoAnalyzer;

import java.util.ArrayList;
import java.util.List;

public class LexicoAnalyzer {

    private String numbers = "0123456789";

    private String letters = "abcdefghijklmnopqrstuvxwyzABCDEFGHIJKLMNOPQRSTUVXWYZ";

    private List<Symbol> symbols;

    private Integer state;

    private StringBuilder buffer;

    public List<Symbol> analyze(String input) throws Exception {

        symbols = new ArrayList<Symbol>();

        resetBuffer();

        int row = 1;

        int column = 1;

        int i = 0;

        while (i < input.length()) {

            char currentChar = input.charAt(i);

            switch (state) {

                case 0:

                    if (isIgnoredChar(currentChar)) {

                        if (currentChar == '\n'){
                            row++;
                            column = 1;
                        }
                        i++;
                        continue;

                    } else if (isAlphabet(currentChar)) {
                        state = 1;
                    } else if (isNumber(currentChar)) {
                        state = 2;
                        // Quando a entrada � "
                    } else if (currentChar == '"') {

                        state = 3;

                        // Quando a entrada � : ou >
                    } else if (currentChar == ':' || currentChar == '>') {

                        state = 5;

                        // Quando a entrada � <
                    } else if (currentChar == '<') {

                        state = 6;

                        // Quando a entrada � (
                    } else if (currentChar == '(') {

                        state = 7;

                        // Quando a entrada � . ou , ou ; ou ) ou * ou / ou + ou - ou = ou $
                    } else if (".,;)*/+-=$".indexOf(currentChar) != -1) {

                        state = 11;

                        // Quando a entrada � um caracter que n�o est� na gram�tica
                    } else {
                        showError(String.format("Símbolo '" + currentChar + "' não reconhecido. Linha: " + row + ". Coluna: " + column + "."));
                    }

                    buffer.append(currentChar);
                    i++;
                    break;

                case 1:

                    if (letters.contains(String.valueOf(currentChar)) || numbers.contains(String.valueOf(currentChar))) {
                        buffer.append(currentChar);
                        i++;
                    } else {
                        String string = buffer.toString().toUpperCase();
                        Symbol symbol = TerminalSymbols.Symbols.get(string);
                        if (symbol != null) {
                            symbols.add(symbol);
                            resetBuffer();
                        } else {
                            if (string.length() <= 30) {
                                symbols.add(new Symbol(19, buffer.toString(), "Identificador"));
                                resetBuffer();
                            } else {
                                showError(String.format("Identificador com " + string.length() + " caracteres. Tamanho máximo permitido é 30 caracteres. Linha: " + row + ". Coluna: " + column + "."));
                            }
                        }
                    }
                    break;

                case 2:

                    if (numbers.contains(String.valueOf(currentChar))) {
                        buffer.append(currentChar);
                        i++;
                    } else {
                        String string = buffer.toString();
                        int inteiro = Integer.parseInt(string);
                        if (inteiro <= 32767) {
                            symbols.add(new Symbol(20, string, "Inteiro"));
                            resetBuffer();
                        } else {
                            showError(String.format("Número inteiro " + string + " fora da escala. Máximo permitido é 32767 para inteiro. Linha: " + row + ". Coluna: " + column + "."));
                        }
                    }
                    break;

                case 3:

                    if (currentChar == '"') {
                        state = 4;
                    }
                    buffer.append(currentChar);
                    i++;
                    break;

                case 4:

                    String string = buffer.toString();
                    if (string.length() <= 255){
                        symbols.add(new Symbol(21, string, "Literal"));
                        resetBuffer();
                    } else {
                        showError(String.format("Literal com " + string.length() + " caracteres. Tamanho m�ximo permitido � 255 caracteres. Linha: " + row + ". Coluna: " + column + "."));
                    }
                    break;

                case 5:

                    if (currentChar == '=') {
                        state = 11;
                        buffer.append(currentChar);
                        i++;
                    } else {
                        addSymbolToList();
                    }
                    break;

                case 6:

                    if (currentChar != '>' && currentChar != '=') {
                        addSymbolToList();
                    } else {
                        state = 11;
                        buffer.append(currentChar);
                        i++;
                    }
                    break;

                case 7:

                    if (currentChar == '*') {
                        state = 8;
                    } else {
                        addSymbolToList();
                    }
                    break;

                case 8:

                    if (currentChar == '*') {
                        state = 9;
                    }
                    i++;
                    break;

                case 9:

                    if (currentChar == ')') {
                        state = 10;
                    } else if (currentChar != '*') {
                        state = 8;
                    }
                    i++;
                    break;

                case 10:

                    resetBuffer();
                    break;

                case 11:

                    addSymbolToList();
                    break;
            }
            column++;
        }

        return symbols;
    }

    private void resetBuffer() {
        buffer = new StringBuilder();
        state = 0;
    }

    private void addSymbolToList() {
        String string = buffer.toString();
        symbols.add(TerminalSymbols.Symbols.get(string));
        resetBuffer();
    }

    private void showError(String message) throws Exception {
        Main.generateTableResults(symbols);
        throw new Exception(String.format(message));
    }

    private boolean isIgnoredChar(char character) {
        return character == ' ' || character == '\t' || character == '\n' || character == '\r';
    }

    private boolean isAlphabet(char character) {
        return letters.contains(String.valueOf(character));
    }

    private boolean isNumber(char character) {
        return numbers.contains(String.valueOf(character));
    }
}
