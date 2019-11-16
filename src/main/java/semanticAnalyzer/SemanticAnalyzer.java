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

    private Symbol lastSymbol;

    private Stack<ProcedureDeviationControl> procedureDeviationControlStack = new Stack<ProcedureDeviationControl>();

    private Stack<Symbol> paramControlStack = new Stack<Symbol>();

    private Stack<Integer> whileControlStack = new Stack<Integer>();

    private Stack<Integer> ifControlStack = new Stack<Integer>();

    private Stack<Integer> forControlStack = new Stack<Integer>();

    private Symbol actualProcedure;

    private Symbol leftAssignmentName;

    private int lastDSVF;

    public lexicoAnalyzer.Symbol previousToken;

    public Symbol procedure;

    public Symbol currentForIdentifier;

    private int effectiveParameterNumber = 0;

    public SemanticAnalyzer() {
        this.symbolsTable = new SymbolsTable();
    }

    public void executeAction(int action) {
        switch (action) {
            case 100:
                action100();
                break;
            case 101:
                action101();
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

    private void action101() {
        this.hipotetica.addInstruction(InstructionArea.PARA, 0, 0);
        // TODO: 11/7/19
        // Verifica utilização de rótulos através da tabela de símbolos
    }

    private void action156() {
        this.context = CONTEXT_EXPRESSAO;
    }

    private void action155() {
        hipotetica.addInstruction(InstructionArea.NEGA,0,0);
    }

    private void action154() {
        hipotetica.addInstruction(InstructionArea.CRCT, 0, Integer.parseInt(lastNonTerminalSymbol.getToken()));
    }

    private void action153() {
        hipotetica.addInstruction(InstructionArea.CONJ,0,0);
    }

    private void action152() {
        this.hipotetica.addInstruction(InstructionArea.DIVI, 0, 0);
    }

    private void action151() {
        hipotetica.addInstruction(InstructionArea.MULT, 0, 0);
    }

    private void action150() {
        hipotetica.addInstruction(InstructionArea.DISJ, 0, 0);
    }

    private void action149() {
        hipotetica.addInstruction(InstructionArea.SUBT, 0, 0);
    }

    private void action148() {
        hipotetica.addInstruction(InstructionArea.SOMA, 0, 0);
    }

    private void action147() {
        hipotetica.addInstruction(InstructionArea.INVR, 0, 0);
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
        hipotetica.addInstruction(InstructionArea.CRVL, currentForIdentifier.level, currentForIdentifier.generalA);

        // gera instrução CRCT (1) base 10
        hipotetica.addInstruction(InstructionArea.CRCT, 0,1);

        // gera instrução soma (até aqui incrementa variável de controle)
        hipotetica.addInstruction(InstructionArea.SOMA, 0, 0);

        // gera instrução ARMZ variável controle
        hipotetica.addInstruction(InstructionArea.ARMZ, currentForIdentifier.level, currentForIdentifier.generalA);

        // completa instrução DSVF, gerada na ação #139, utilizando como operando (LC+1)
        hipotetica.addInstruction(InstructionArea.DSVF, 0, hipotetica.intructionArea.LC + 1);

        // gera instruçao DSVS, utilizando como operando o valor de LC salvo na ação #139 (retorno) gera instrução AMEN, -1 (limpeza)
        hipotetica.addInstruction(InstructionArea.DSVS, 0, forControlStack.pop() + 1);

        hipotetica.addInstruction(InstructionArea.AMEM, 0, -1);
    }

    private void action139() {
        // TODO: 11/7/19 Após expressão – valor final
        // armazena valor de LC na pilha de controle do FOR
        forControlStack.add(hipotetica.intructionArea.LC);

        // gera instrução COPIA
        hipotetica.addInstruction(InstructionArea.COPY, 0, 0);

        // gera instrução CRVL – atributos salvos em #137
        hipotetica.addInstruction(InstructionArea.CRVL, actualLevel - lastSymbol.level, lastSymbol.generalA);

        // gera instrução CMAI
        hipotetica.addInstruction(InstructionArea.CMAI, 0, 0);

        // gera instrução DSVF com parâmetro desconhecido, guardando na pilha de controle o
        hipotetica.addInstruction(InstructionArea.DSVF, 0, 0);

        //endereço do operando (ou da instrução) para posterior marcação.
        // armazena na pilha de controle o endereço do nome da variável de controle relativo à
        //tabela de símbolos.
        forControlStack.add(hipotetica.intructionArea.LC);
    }

    private void action138() {
        hipotetica.addInstruction(InstructionArea.ARMZ, actualLevel - currentForIdentifier.level, currentForIdentifier.generalA);
    }

    private void action137() {
        try {
            Symbol symbol = symbolsTable.findByName(lastNonTerminalSymbol.getToken());
            if (symbol.category == Symbol.VARIAVEL) {
                currentForIdentifier = symbol;
            } else {
                System.out.print("ERRO 137");
            }
        } catch (SymbolNotFoundException e) {
            System.out.print("ERRO 137");
        }
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
        hipotetica.addInstruction(InstructionArea.IMPR,0,0);
    }

    private void action130() {
        hipotetica.IncluirAL(hipotetica.instructionliteralarea, lastNonTerminalSymbol.getToken());
        hipotetica.addInstruction(InstructionArea.IMPRL, 0, hipotetica.instructionliteralarea.LIT - 1);
    }

    private void action129() {
        try {
            Symbol symbol = symbolsTable.findByName(lastNonTerminalSymbol.getToken());
            switch (this.context) {
                case CONTEXT_READLN:
                    if (symbol.category == Symbol.VARIAVEL) {
                        this.hipotetica.addInstruction(InstructionArea.LEIT, 0, 0);
                        this.hipotetica.addInstruction(InstructionArea.ARMZ, actualLevel - symbol.level, symbol.generalA);
                    } else {
                        System.out.print("ERRO 129");
                        throw new Exception();
                    }
                    break;
                case CONTEXT_EXPRESSAO:
                    if (symbol.category == Symbol.PROCEDURE) {
                        System.out.print("ERRO 129");
                        throw new Exception();
                    }
                    if (symbol.category == Symbol.CONSTANTE) {
                        this.hipotetica.addInstruction(InstructionArea.CRCT, 0, symbol.generalA);
                    } else {
                        this.hipotetica.addInstruction(InstructionArea.CRVL, actualLevel - symbol.level, symbol.generalA);
                    }
                    break;
            }
        } catch (SymbolNotFoundException e) {
            System.out.print("ERRO 129");
        } catch (Exception e) {
            System.out.print("ERRO 129");
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
        whileControlStack.add(hipotetica.intructionArea.LC);
    }

    private void action122() {

        System.out.print("TODO");
    }

    private void action121() {
        //completa instrução DSVS gerada na ação #122
        this.hipotetica.intructionArea.instructions[lastDSVF].setOp2(hipotetica.intructionArea.LC);
        // operando recebe valor de LC 
    }

    private void action120() {
        this.hipotetica.addInstruction(InstructionArea.DSVF, 0, 0);
        lastDSVF = hipotetica.intructionArea.LC - 1;
        ifControlStack.add(hipotetica.intructionArea.LC);
    }

    private void action118() {
        effectiveParameterNumber++;
    }

    private void action117() {
        try {
            if (procedure.generalB != effectiveParameterNumber) {
                System.out.print("ERRO 117");
                throw new Exception();
            } else {
                hipotetica.addInstruction(InstructionArea.CALL, 0, procedure.generalA);
                effectiveParameterNumber = 0;
            }
        } catch (Exception e) {
            System.out.print("ERRO 117");
        }
    }

    private void action116() {
        try {
            Symbol symbol = symbolsTable.findByName(lastNonTerminalSymbol.getToken());
            if (symbol.category == Symbol.PROCEDURE) {
                procedure = symbol;
            } else {
                System.out.println("ERRO 116");
            }
        } catch (SymbolNotFoundException e) {
            System.out.println("ERRO 116");
        }
    }

    private void action115() {
        this.hipotetica.addInstruction(InstructionArea.ARMZ, actualLevel - leftAssignmentName.level, leftAssignmentName.generalA);
    }

    private void action114() {
        try {
            Symbol symbol = symbolsTable.findByName(lastNonTerminalSymbol.getToken());
            if (symbol.category == Symbol.VARIAVEL) {
                leftAssignmentName = symbol;
            } else {
                System.out.print("ERRO 114");
            }
        } catch (SymbolNotFoundException e) {
            System.out.print("ERRO 114");
        }
    }

    private void action111() {
        this.identificatorType = Symbol.PARAMETRO;
        this.hasParameters = true;
    }

    private void action110() {
        ProcedureDeviationControl procedureDeviationControl = procedureDeviationControlStack.pop();
        this.hipotetica.addInstruction(InstructionArea.RETU, 0, procedureDeviationControl.paramcount);
        this.hipotetica.intructionArea.instructions[procedureDeviationControl.pointer - 1].op2 = this.hipotetica.intructionArea.LC;
        // TODO: 11/15/19  deleta nomes do escopo do nível na TS;
        actualLevel--;
    }

    private void action109() {
        if (this.hasParameters) {
            actualProcedure.generalB = this.parameterNumber;
            for (int i = 1; i <= this.parameterNumber; i++) {
                Symbol symbol1 = paramControlStack.pop();
                symbol1.generalA = i * -1;
            }
        }
        this.hipotetica.addInstruction(InstructionArea.DSVS, 0, 0);
        ProcedureDeviationControl procedureDeviationControl = new ProcedureDeviationControl();
        procedureDeviationControl.pointer = this.hipotetica.intructionArea.LC;
        procedureDeviationControl.paramcount = this.parameterNumber;
        procedureDeviationControlStack.add(procedureDeviationControl);
    }

    private void action108() {
        try {
            Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.PROCEDURE, this.actualLevel, 0, 0);
            symbolsTable.add(newSymbol);
            actualProcedure = newSymbol;
            this.hasParameters = false;
            this.parameterNumber = 0;
            this.actualLevel++;
            this.shift = 3;
        } catch (SymbolDeclaredException e) {
            System.out.print("ERRO 108");
        }
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
        this.shift = 3;
        this.hipotetica.addInstruction(InstructionArea.AMEM, 0, shift + variableNumber);
        variableNumber = 0;
    }

    private void action104() {
        switch (this.identificatorType) {
            case Symbol.VARIAVEL:
                try {
                    Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.VARIAVEL, this.actualLevel, this.shift, 0);
                    symbolsTable.add(newSymbol);
                    this.shift++;
                    this.variableNumber++;
                    newSymbol.generalA = this.variableNumber + 2;
                } catch (SymbolDeclaredException e) {
                }
                break;
            case Symbol.PARAMETRO:
                try {
                    Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.PARAMETRO, this.actualLevel, 0, 0);
                    symbolsTable.add(newSymbol);
                    this.parameterNumber++;
                    paramControlStack.add(newSymbol);
                } catch (SymbolDeclaredException e) {
                }
                break;
        }
    }

    private void action105() {
        Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.CONSTANTE, this.actualLevel, 0, 0);
        try {
            this.symbolsTable.add(newSymbol);
            lastSymbol = newSymbol;
        } catch (SymbolDeclaredException e) {
        }
    }

    private void action106() {
        lastSymbol.generalA = Integer.parseInt(lastNonTerminalSymbol.getToken());
    }

    private void action107() {
        this.identificatorType = Symbol.VARIAVEL;
    }

}
