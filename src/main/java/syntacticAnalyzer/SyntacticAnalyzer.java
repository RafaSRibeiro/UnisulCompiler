package syntacticAnalyzer;

import lexicoAnalyzer.LexicoAnalyzer;
import lexicoAnalyzer.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SyntacticAnalyzer {

    private Object List;

    public void analyse(String program) throws SyntacticAnalyzerException {

        Stack auxStack = new Stack();
        auxStack.push(ParserConstants.START_SYMBOL);

        List<Symbol> symbols = this.getLexicoAnalyzerSymbols(program);
        Stack inputSymbols = new Stack();
        for (int i = symbols.size() - 1; i >= 0; i--) {
            inputSymbols.add(symbols.get(i).getId());
        }

        do {
            int currentAuxToken = ((Integer) auxStack.peek()).intValue();
            int currentToken = ((Integer) inputSymbols.peek()).intValue();
            if (isTerminal(currentAuxToken) || auxStack.empty()) {
                if (currentAuxToken == currentToken) {
                    auxStack.pop();
                    auxStack.pop();
                } else {
                    throw new SyntacticAnalyzerException(error(currentAuxToken));
                }
            } else if (isNonTerminal(currentAuxToken)) {
                if (hasParseTable(currentAuxToken, currentToken)) {
                    auxStack.pop();
                    int parseTableId = getParseTable(currentAuxToken, currentToken);
                    int[] rules = getProductionRules(parseTableId);
                    for (int i = rules.length - 1; i >= 0; i--) {
                        auxStack.push(rules[i]);
                    }
                } else {
                    throw new SyntacticAnalyzerException(error(currentAuxToken));
                }

            } else {
                throw new SyntacticAnalyzerException(error(currentAuxToken));
            }
        } while (!auxStack.empty());
    }

    private List<Symbol> getLexicoAnalyzerSymbols(String program) throws SyntacticAnalyzerException {
        LexicoAnalyzer lexicoAnalyzer = new LexicoAnalyzer();
        try {
            return lexicoAnalyzer.analyze(program);
        } catch (Exception e) {
            return  new ArrayList<Symbol>();
        }
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

    private String error(int errorId) {
        return ParserConstants.PARSER_ERROR[errorId];
    }
}
