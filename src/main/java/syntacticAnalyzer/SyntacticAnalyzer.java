package syntacticAnalyzer;

import lexicoAnalyzer.LexicoAnalyzer;
import lexicoAnalyzer.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SyntacticAnalyzer {

    private Object List;

    public void analyse(List<Symbol> symbols) throws SyntacticAnalyzerException {

        Stack auxStack = new Stack();
        auxStack.push(ParserConstants.START_SYMBOL);

        Stack inputSymbols = new Stack();
        for (int i = symbols.size() - 1; i >= 0; i--) {
            inputSymbols.add(symbols.get(i));
        }

        do {
            while (((Integer) auxStack.peek()).intValue() == Constants.EPSILON) {
                auxStack.pop();
            }
            int currentAuxToken = ((Integer) auxStack.peek()).intValue();

            Symbol currentToken = (Symbol) inputSymbols.peek();

            if (isTerminal(currentAuxToken) || auxStack.empty()) {
                if (currentAuxToken == currentToken.getId()) {
                    auxStack.pop();
                    inputSymbols.pop();
                } else {
                    throw new SyntacticAnalyzerException(error(currentAuxToken, currentToken));
                }
            } else if (isNonTerminal(currentAuxToken)) {
                System.out.println(ParserConstants.PARSER_TABLE[currentAuxToken - ParserConstants.START_SYMBOL][currentToken.getId() - 1]);
                if (hasParseTable(currentAuxToken, currentToken.getId())) {
                    auxStack.pop();
                    int parseTableId = getParseTable(currentAuxToken, currentToken.getId());
                    int[] rules = getProductionRules(parseTableId);
                    for (int i = rules.length - 1; i >= 0; i--) {
                        auxStack.push(rules[i]);
                    }
                } else {
                    throw new SyntacticAnalyzerException(error(currentAuxToken, currentToken));
                }

            } else {
                throw new SyntacticAnalyzerException(error(currentAuxToken, currentToken));
            }
        } while (!auxStack.empty());
    }

    private boolean isTerminal(int tokenId) {
        return tokenId < ParserConstants.FIRST_NON_TERMINAL;
    }

    private boolean isNonTerminal(int tokenId) {
        return tokenId >= ParserConstants.FIRST_NON_TERMINAL && tokenId < ParserConstants.FIRST_SEMANTIC_ACTION;
    }

    private boolean hasParseTable(int row, int col) {
        return getParseTable(row, col) > -1;
    }

    private int getParseTable(int row, int col) {
        return ParserConstants.PARSER_TABLE[row - ParserConstants.START_SYMBOL][col - 1];
    }

    private int[] getProductionRules(int parseTableId) {
        return ParserConstants.PRODUCTIONS[parseTableId];
    }

    private String error(int errorId, Symbol symbol) {
        return ParserConstants.PARSER_ERROR[errorId] + " - " + symbol.getToken() + ": " + symbol.getDescription();
    }
}
