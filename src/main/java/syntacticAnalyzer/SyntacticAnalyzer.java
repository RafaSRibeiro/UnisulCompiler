package syntacticAnalyzer;

import lexicoAnalyzer.LexicoAnalyzer;
import lexicoAnalyzer.Symbol;

import java.util.List;
import java.util.Stack;

public class SyntacticAnalyzer {

    private final int finalSymbol = Constants.DOLLAR;

    public void analyse(String program) throws Exception {

        Stack auxStack = new Stack();
        auxStack.push(ParserConstants.START_SYMBOL);

        List<Symbol> symbols = this.getLexicoAnalyzerSymbols(program);
        Stack inputSymbols = new Stack();
        for (Symbol symbol : symbols) {
            inputSymbols.push(symbol.getId());
        }

        do {
            int currentAuxToken = ((Integer) auxStack.elementAt(0)).intValue();
            int currentToken = ((Integer) inputSymbols.elementAt(0)).intValue();
            if (isTerminal(currentAuxToken) || isFinal(currentAuxToken)) {
                if (currentAuxToken == currentToken) {
                    auxStack.pop();
                    inputSymbols.pop();
                } else {
                    error(currentAuxToken);
                }
            } else if (isNonTerminal(currentAuxToken)) {
                if (hasParseTable(currentAuxToken, currentToken)) {
                    auxStack.pop();
                    int parseTableId = getParseTable(currentAuxToken, currentToken);
                    auxStack.push(getProductionRules(parseTableId));
                } else {
                    error(currentAuxToken);
                }

            } else {
                error(currentAuxToken);
            }
        } while (!auxStack.empty());
    }

    private List<Symbol> getLexicoAnalyzerSymbols(String program) throws Exception {
        LexicoAnalyzer lexicoAnalyzer = new LexicoAnalyzer();
        return lexicoAnalyzer.analyze(program);
    }

    private boolean isTerminal(int tokenId) {
        return tokenId < ParserConstants.FIRST_NON_TERMINAL;
    }

    private boolean isFinal(int tokenId) {
        return tokenId == Constants.DOLLAR;
    }

    private boolean isNonTerminal(int tokenId) {
        return tokenId >= ParserConstants.FIRST_NON_TERMINAL && tokenId < ParserConstants.FIRST_SEMANTIC_ACTION;
    }

    private boolean hasParseTable(int x, int a) {
        return ParserConstants.PARSER_TABLE[x-1][a-1] > -1;
    }

    private int getParseTable(int x, int a) {
        return ParserConstants.PARSER_TABLE[x][a];
    }

    private int[] getProductionRules(int parseTableId) {
        return ParserConstants.PRODUCTIONS[parseTableId];
    }

    private String error(int errorId) {
        System.out.print(ParserConstants.PARSER_ERROR[errorId]);
        return ParserConstants.PARSER_ERROR[errorId];
    }
}
