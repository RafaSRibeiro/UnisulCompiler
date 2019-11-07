package semanticAnalyzer;

import hypotheticalMachine.Hipotetica;
import hypotheticalMachine.InstructionArea;
import symbolsTable.Symbol;
import symbolsTable.SymbolDeclaredException;
import symbolsTable.SymbolNotFoundException;
import symbolsTable.SymbolsTable;

import java.util.Stack;

public class SemanticAnalyzer {

    private static final int CONTEXT_EXPRESSAO = 1;
    private static final int CONTEXT_READLN = 2;

     private Stack conditionStack;

     private SymbolsTable symbolsTable;

     private int actualLevel;

     private int freePosition;

    private int variableNumber;

    private int parameterNumber;

    private int shift;

    private boolean hasParameters = false;

    private Hipotetica hipotetica;

    public int identificatorType;

    public lexicoAnalyzer.Symbol lastNonTerminalSymbol;

    private int context;

    public SemanticAnalyzer() {
        this.symbolsTable = new SymbolsTable();
    }

    public void executeAction(int action) {
        switch (action) {
            case 100:
                action100();
                break;
            case 102:
                action102();
                break;
            case 104:
                action104();
                break;
            case 105:
                action105();
                break;
            case 106:
                action106();
                break;
            case 107:
                action107();
                break;
            case 108:
                action108();
                break;
            case 109:
                action109();
                break;
            case 110:
                action110();
                break;
            case 111:
                action111();
                break;
            case 114:
                action114();
                break;
            case 115:
                action115();
                break;
            case 116:
                action116();
                break;
            case 117:
                action117();
                break;
            case 118:
                action118();
                break;
            case 120:
                action120();
                break;
            case 121:
                action121();
                break;
            case 122:
                action122();
                break;
            case 123:
                action123();
                break;
            case 124:
                action124();
                break;
            case 125:
                action125();
                break;
            case 126:
                action126();
                break;
            case 127:
                action127();
                break;
            case 128:
                action128();
                break;
            case 129:
                action129();
                break;
            case 130:
                action130();
                break;
            case 131:
                action131();
                break;
            case 132:
                action132();
                break;
            case 133:
                action133();
                break;
            case 134:
                action134();
                break;
            case 135:
                action135();
                break;
            case 136:
                action136();
                break;
            case 137:
                action137();
                break;
            case 138:
                action138();
                break;
            case 139:
                action139();
                break;
            case 140:
                action140();
                break;
            case 141:
                action141();
                break;
            case 142:
                action142();
                break;
            case 143:
                action143();
                break;
            case 144:
                action144();
                break;
            case 145:
                action145();
                break;
            case 146:
                action146();
                break;
            case 147:
                action147();
                break;
            case 148:
                action148();
                break;
            case 149:
                action149();
                break;
            case 150:
                action150();
                break;
            case 151:
                action151();
                break;
            case 152:
                action152();
                break;
            case 153:
                action153();
                break;
            case 154:
                action154();
                break;
            case 155:
                action155();
                break;
            case 156:
                action156();
                break;
        }
    }

    private void action156() {
        this.context = CONTEXT_EXPRESSAO;
    }

    private void action155() {
        System.out.print("TODO");
    }

    private void action154() {
        // TODO: 11/7/19 Expressão – inteiro
        // gera CRCT 
    }

    private void action153() {
        System.out.print("TODO");
    }

    private void action152() {
        // TODO: 11/7/19 Expressão – divisão
        // gera DIV 
    }

    private void action151() {
        System.out.print("TODO");
    }

    private void action150() {
        System.out.print("TODO");
    }

    private void action149() {
        System.out.print("TODO");
    }

    private void action148() {
        // TODO: 11/7/19 Expressão – subtração
        // gera SUBT 
    }

    private void action147() {
        System.out.print("TODO");
    }

    private void action146() {
        System.out.print("TODO");
    }

    private void action145() {
        System.out.print("TODO");
    }

    private void action144() {
        System.out.print("TODO");
    }

    private void action143() {
        System.out.print("TODO");
    }

    private void action142() {
        System.out.print("TODO");
    }

    private void action141() {
        System.out.print("TODO");
    }

    private void action140() {
        // TODO: 11/7/19 Após comando em FOR
        // gera instrução CRVL, utilizando endereço salvo em #139( @ da TS da variável de controle
        //na pilha de controle)
        // gera instrução CRCT (1) base 10
        // gera instrução soma (até aqui incrementa variável de controle)
        // gera instrução ARMZ variável controle
        // completa instrução DSVF, gerada na ação #139, utilizando como operando (LC+1)
        // gera instruçao DSVS, utilizando como operando o valor de LC salvo na ação #139 (retorno) gera instrução AMEN, -1 (limpeza)
    }

    private void action139() {
        // TODO: 11/7/19 Após expressão – valor final
        // armazena valor de LC na pilha de controle do FOR
        // gera instrução COPIA
        // gera instrução CRVL – atributos salvos em #137
        // gera instrução CMAI
        // gera instrução DSVF com parâmetro desconhecido, guardando na pilha de controle o
        //endereço do operando (ou da instrução) para posterior marcação.
        // armazena na pilha de controle o endereço do nome da variável de controle relativo à
        //tabela de símbolos. 
    }

    private void action138() {
        // TODO: 11/7/19 Após expressão valor inicial
        // gera instrução ARMZ – considerando variável de controle atributos salvos em #137) 
    }

    private void action137() {
        // TODO: 11/7/19 Após variável controle comando FOR
        //se nome esta na TS e é nome da variável então
        //salva endereço do nome em relação a TS
        //senão erro
        //fim se 
    }

    private void action136() {
        System.out.print("TODO");
    }

    private void action135() {
        System.out.print("TODO");
    }

    private void action134() {
        System.out.print("TODO");
    }

    private void action133() {
        System.out.print("TODO");
    }

    private void action132() {
        System.out.print("TODO");
    }

    private void action131() {
        // TODO: 11/7/19 WRITELN após expressão
        // gera IMPR
    }

    private void action130() {
        // TODO: 11/7/19 WRITELN - após literal na instrução WRITELN
        // armazena cadeia literal na área de literais (pega o literal identificado pelo léxico e
        //transposta para área de literais – área_literais)
        // atualiza ponteiro de literal ( pont_literal – vetor que aponta para o inicio do literal
        //respectivo na área de literais) - aponta para o inicio do proximo literal.
        // gera IMPRLIT tendo como parâmetro o numero de ordem do literal ( literal 1, literal 2
        //...)
        // incrementa no. de ordem do literal
        //Nota : a área de literais (área_literais) e o ponteiro de literais (pont_literal) são gerados na fase
        //de compilação e utilizados na fase de interpretação (execução) do programa. 
    }

    private void action129() {
        switch (this.context) {
            case CONTEXT_READLN:
                // TODO: 11/7/19 se identificador é nome de variável e está na tabela de símbolos então
                //gera LEIT
                //gera ARMZ
                //senão erro
                //fim se
                break;
            case CONTEXT_EXPRESSAO:
                // TODO: 11/7/19 se nome não está na tabela de símbolos
                //então erro
                //senão
                //se nome é de procedure ou de rótulo
                //então erro
                //senão se nome é de constante
                //então gera CRCT valor decimal
                //senão gera CRVL - , deslocamento
                //fim se
                //fim se
                //fim se
                break;
        }
    }

    private void action128() {
        this.context = CONTEXT_READLN;
    }

    private void action127() {
        System.out.print("TODO");
    }

    private void action126() {
        System.out.print("TODO");
    }

    private void action125() {
        System.out.print("TODO");
    }

    private void action124() {
        System.out.print("TODO");
    }

    private void action123() {
        // TODO: 11/7/19 Comando WHILE antes da expressão
        // o valor de LC é armazenado na pilha dos WHILE’s, este é o endereço de retorno do
        //WHILE 
    }

    private void action122() {
        System.out.print("TODO");
    }

    private void action121() {
        // TODO: 11/7/19 Após instrução IF
        // completa instrução DSVS gerada na ação #122
        // operando recebe valor de LC 
    }

    private void action120() {
        System.out.print("TODO");
    }

    private void action118() {
        // TODO: 11/7/19 Após expressão, em comando call
        // acumula número de parâmetros efetivos 
    }

    private void action117() {
        // TODO: 11/7/19 Após comando call
        //se num. de parâmetros <> num. de parâmetros efetivos
        //então erro
        //senão
        //gera instrução CALL, utilizando informaçoes da procedure, contidas na TS (
        //endereço na TS salvo em ação #116)
        //fim se 
    }

    private void action116() {
        // TODO: 11/7/19 Chamada de procedure
        //se nome esta na TS e é nome de procedure
        //então salva endereço do nome
        //senão erro
        //fim se 
    }

    private void action115() {
        this.hipotetica.addInstruction(InstructionArea.AMEM, 0, actualLevel);
    }

    private void action114() {
        // TODO: 11/7/19 Atribuição parte esquerda
        //se nome está na tabela de símbolos então
        //se nome <> nome de variável então erro
        //senão salva atributos do nome
        //fim se
        //senão erro (“identificador não declarado”)
        //fim se 
    }

    private void action111() {
        this.identificatorType = Symbol.PARAMETRO;
        this.hasParameters = true;
    }

    private void action110() {
        // TODO: 11/7/19 Fim de procedure
        // retira da pilha de controle de procedures: número de parâmetros (np) , endereço da instrução
        //de desvio
        // gera instrução RETU
        // verifica utilização de rótulos na TS
        //
        //
        //completa instrução de desvio da procedure ( aponta para LC)
        //deleta nomes do escopo do nível na TS
        //decrementa nível (Nível_atual:= nível_atual – 1) 
    }

    private void action109() {
        if (this.hasParameters) {
            try {
                Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.PROCEDURE, this.actualLevel, 0, 0);
                Symbol symbol = symbolsTable.find(newSymbol);
                symbol.generalB = this.parameterNumber;
                // TODO: 11/5/19 preenche atributos dos parâmetros (deslocamento):
                //primeiro parâmetro –> deslocamento = - (np)
                //segundo parâmetro –> deslocamento = - (np – 1)
            } catch (SymbolNotFoundException e) {
            }
        }
        // TODO: 11/5/19 gera instrução DSVS com parâmetro zero, e salva na pilha de controle de desvios de
        //procedure o endereço da instrução de desvio e o número de parâmetros.
    }

    private void action108() {
        try {
            Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.PROCEDURE, this.actualLevel, 0, 0);
            symbolsTable.add(newSymbol);
        } catch (SymbolDeclaredException e) {
        }
        this.hasParameters = false;
        this.parameterNumber = 0;
        this.actualLevel++;
    }

    private void action100() {
        this.conditionStack = new Stack();
        this.symbolsTable = new SymbolsTable();
        this.actualLevel = 0;
        this.freePosition = 1;
        this.variableNumber = 0;
        this.parameterNumber = 0;
        this.shift = 3;
        this.hipotetica = new Hipotetica();
    }

    private void action102() {
        this.hipotetica.addInstruction(InstructionArea.AMEM, 0, variableNumber);
    }

    private void action104() {
        switch (this.identificatorType) {
            case Symbol.ROTULO:
                try {
                    Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.ROTULO, this.actualLevel, 0, 0);
                    symbolsTable.add(newSymbol);
                    // TODO: 11/5/19 cabeça de lista de referências futuras = 0
                } catch (SymbolDeclaredException e) {
                }
                break;
            case Symbol.VARIAVEL:
                try {
                    Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.VARIAVEL, this.actualLevel, 0, 0);
                    symbolsTable.add(newSymbol);
                    this.variableNumber++;
                } catch (SymbolDeclaredException e) {
                }
                break;
            case Symbol.PARAMETRO:
                try {
                    Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.PARAMETRO, this.actualLevel, 0, 0);
                    symbolsTable.add(newSymbol);
                    this.parameterNumber++;
                } catch (SymbolDeclaredException e) {
                }
                break;
        }
    }

    private void action105() {
        Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.CONSTANTE, this.actualLevel, 0, 0);
        try {
            this.symbolsTable.add(newSymbol);
        } catch (SymbolDeclaredException e) {
        }
    }

    private void action106() {
        // TODO: 10/20/19 preenche atributo para constante na TS (valor base 10), utilizando endereço do
        //identificador na TS salvo em ação #105
    }

    private void action107() {
        this.identificatorType = Symbol.VARIAVEL;
    }

    private void initVariables() {
        // TODO: 10/20/19
    }

}
