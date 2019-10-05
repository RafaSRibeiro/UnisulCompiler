package syntacticAnalyzer;

import lexicoAnalyzer.LexicoAnalyzer;
import lexicoAnalyzer.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SyntacticAnalyzer {

    public void analyse(List<Symbol> symbols) throws SyntacticAnalyzerException {

        //instancia a pilha de simbolos e empilha $
        Stack auxStack = new Stack();
        auxStack.push(ParserConstants.START_SYMBOL);

        //instancia a pilha de entrada, empilhando a lista 'symbols' passada por parametro
        Stack inputSymbols = new Stack();
        for (int i = symbols.size() - 1; i >= 0; i--) {
            inputSymbols.add(symbols.get(i));
        }

        do {
            //tira do topo da pilha de simbolos sentaças vazias
            while (((Integer) auxStack.peek()).intValue() == Constants.EPSILON) {
                auxStack.pop();
            }
            //instancia os simbolos que serão comparados (pilha de simbolo x pilha de entrada)
            int currentAuxToken = ((Integer) auxStack.peek()).intValue();
            Symbol currentToken = (Symbol) inputSymbols.peek();

            //se o simbolo atual, topo da pilha da simbolos, for TERMINAL
            if (isTerminal(currentAuxToken) || auxStack.empty()) {
                //se os simbolos das pilhas de simbolos e de entrada coincidirem, desempilha o simbolo das duas
                if (currentAuxToken == currentToken.getId()) {
                    auxStack.pop();
                    inputSymbols.pop();
                //senao mostra erro sintatico
                } else {
                    throw new SyntacticAnalyzerException(error(currentAuxToken, currentToken));
                }
            //se o simbolo atual, topo da pilha de simbolos, for NÃO TERMINAL
            } else if (isNonTerminal(currentAuxToken)) {
                //se existe derivação para o não terminal encontrado
                if (hasParseTable(currentAuxToken, currentToken.getId())) {
                    //desempilha a simbolo que gerou as derivações
                    auxStack.pop();
                    //pega o indice da lista de produções
                    int parseTableId = getParseTable(currentAuxToken, currentToken.getId());
                    //instancia um array com as produções geradas pelo não terminal
                    int[] rules = getProductionRules(parseTableId);
                    //empilha os simbolos da produção na pilha de simbolos
                    for (int i = rules.length - 1; i >= 0; i--) {
                        auxStack.push(rules[i]);
                    }
                //se não existe derivação para o não terminal encontrado
                } else {
                    throw new SyntacticAnalyzerException(error(currentAuxToken, currentToken));
                }

            } else {
                throw new SyntacticAnalyzerException(error(currentAuxToken, currentToken));
            }
        } while (!auxStack.empty());
    }
    //testa se o token é terminal ou não (id do token < primeiro não terminal
    private boolean isTerminal(int tokenId) {
        return tokenId < ParserConstants.FIRST_NON_TERMINAL;
    }
    private boolean isNonTerminal(int tokenId) {
        return tokenId >= ParserConstants.FIRST_NON_TERMINAL && tokenId < ParserConstants.FIRST_SEMANTIC_ACTION;
    }
    //retorna a posição da lista de regras de produções a ser seguida na tabela da parser
    private boolean hasParseTable(int row, int col) {
        return getParseTable(row, col) > -1;
    }
    private int getParseTable(int row, int col) {return ParserConstants.PARSER_TABLE[row - ParserConstants.START_SYMBOL][col - 1];
    }
    //retorna a lista das regras de produções que serão utilizadas para a derivação
    private int[] getProductionRules(int parseTableId) {
        return ParserConstants.PRODUCTIONS[parseTableId];
    }
    //metodo que mostra o erro
    private String error(int errorId, Symbol symbol) {
        return ParserConstants.PARSER_ERROR[errorId] + " - " + symbol.getToken() + ": " + symbol.getDescription() + " Linha: " + symbol.getRow() + " - Coluna:"+ symbol.getCol();
    }
}
