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

    public SymbolsTable symbolsTable;

    private int actualLevel;

    private int freePosition;

    private int variableNumber;

    private int parameterNumber;

    private int shift;

    private boolean hasParameters = false;

    public Hipotetica hipotetica;

    public int identificatorType;

    public lexicoAnalyzer.Symbol lastNonTerminalSymbol;

    private int context;

    private Symbol lastSymbol;


    private Stack<ProcedureDeviationControl> procedureControlStack = new Stack<ProcedureDeviationControl>();
    private Stack<Symbol> paramControlStack = new Stack<Symbol>();
    private Stack<Integer> ifControlStack = new Stack<Integer>();
    private Stack<Integer> whileControlStack = new Stack<Integer>();
    private Stack<Integer> repeatControlStack = new Stack<Integer>();
    private Stack<Integer> caseControlStack = new Stack<Integer>();
    private Stack<Integer> forControlStack = new Stack<Integer>();
    public Stack<lexicoAnalyzer.Symbol> tokens = new Stack<lexicoAnalyzer.Symbol>();

    private Symbol actualProcedure;

    private Symbol leftAssignmentName;

    public lexicoAnalyzer.Symbol previousToken;

    public Symbol procedure;

    public Symbol currentForIdentifier;

    private int effectiveParameterNumber = 0;

    public SemanticAnalyzer() {
        this.symbolsTable = new SymbolsTable();
    }

    public void executeAction(int action) throws SemanticException, SymbolNotFoundException, SymbolDeclaredException {
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
        // Gera instrução PARA
        this.hipotetica.addInstruction(InstructionArea.PARA, -1, -1);
    }

    private void action156() {
        this.context = CONTEXT_EXPRESSAO;
    }

    private void action155() {
        hipotetica.addInstruction(InstructionArea.NEGA,-1,-1);
    }

    private void action154() {
        hipotetica.addInstruction(InstructionArea.CRCT, -1, Integer.parseInt(lastNonTerminalSymbol.getToken()));
    }

    private void action153() {
        hipotetica.addInstruction(InstructionArea.CONJ,-1,-1);
    }

    private void action152() {
        this.hipotetica.addInstruction(InstructionArea.DIVI, -1, -1);
    }

    private void action151() {
        hipotetica.addInstruction(InstructionArea.MULT, -1, -1);
    }

    private void action150() {
        hipotetica.addInstruction(InstructionArea.DISJ, -1, -1);
    }

    private void action149() {
        hipotetica.addInstruction(InstructionArea.SUBT, -1, -1);
    }

    private void action148() {
        hipotetica.addInstruction(InstructionArea.SOMA, -1, -1);
    }

    private void action147() {
        hipotetica.addInstruction(InstructionArea.INVR, -1, -1);
    }

    private void action146() {
        hipotetica.addInstruction(InstructionArea.CMDF, -1, -1);
    }

    private void action145() {
        hipotetica.addInstruction(InstructionArea.CMEI, -1, -1);
    }

    private void action144() {
        hipotetica.addInstruction(InstructionArea.CMAI, -1, -1);
    }

    private void action143() {
        hipotetica.addInstruction(InstructionArea.CMMA, -1, -1);
    }

    private void action142() {
        hipotetica.addInstruction(InstructionArea.CMME, -1, -1);
    }

    private void action141() {
        hipotetica.addInstruction(InstructionArea.CMIG, -1, -1);
    }

    private void action140() {
        // gera instrução CRVL, utilizando endereço salvo em #139( @ da TS da variável de controle
        //na pilha de controle)
        hipotetica.addInstruction(InstructionArea.CRVL, currentForIdentifier.level, currentForIdentifier.generalA);

        // gera instrução CRCT (1) base 10
        hipotetica.addInstruction(InstructionArea.CRCT, -1,1);

        // gera instrução soma (até aqui incrementa variável de controle)
        hipotetica.addInstruction(InstructionArea.SOMA, -1, -1);

        // gera instrução ARMZ variável controle
        hipotetica.addInstruction(InstructionArea.ARMZ, currentForIdentifier.level, currentForIdentifier.generalA);

        // completa instrução DSVF, gerada na ação #139, utilizando como operando (LC+1)
        hipotetica.alterInstruction(forControlStack.pop(), 0, hipotetica.intructionArea.LC + 1);

        // gera instruçao DSVS, utilizando como operando o valor de LC salvo na ação #139 (retorno) gera instrução AMEN, -1 (limpeza)
        hipotetica.addInstruction(InstructionArea.DSVS, 0, forControlStack.peek());

        hipotetica.addInstruction(InstructionArea.AMEM, -1, -1);
    }

    private void action139() {
        // armazena valor de LC na pilha de controle do FOR
        forControlStack.add(hipotetica.intructionArea.LC);

        // gera instrução COPIA
        hipotetica.addInstruction(InstructionArea.COPY, -1, -1);

        // gera instrução CRVL – atributos salvos em #137
        hipotetica.addInstruction(InstructionArea.CRVL, actualLevel - lastSymbol.level, lastSymbol.generalA);

        // gera instrução CMAI
        hipotetica.addInstruction(InstructionArea.CMAI, -1, -1);

        // gera instrução DSVF com parâmetro desconhecido, guardando na pilha de controle o
        //endereço do operando (ou da instrução) para posterior marcação.
        // armazena na pilha de controle o endereço do nome da variável de controle relativo à
        //tabela de símbolos.
        forControlStack.add(hipotetica.intructionArea.LC);
        hipotetica.addInstruction(InstructionArea.DSVF, -1, -1);
    }

    private void action138() {
        hipotetica.addInstruction(InstructionArea.ARMZ, actualLevel - currentForIdentifier.level, currentForIdentifier.generalA);
    }

    private void action137() throws SemanticException {
        try {
            Symbol symbol = symbolsTable.findByName(lastNonTerminalSymbol.getToken());
            if (symbol.category == Symbol.VARIAVEL) {
                currentForIdentifier = symbol;
            } else {
                throw new SemanticException("ERRO 137: Não é uma variável");
            }
        } catch (SymbolNotFoundException e) {
            throw new SemanticException("ERRO 137: Symbolo não existe");
        }
    }

    private void action136() {
        //    gera instrução COPIA
        hipotetica.addInstruction(InstructionArea.COPY, -1, -1);
        //    gera instrução CRCT inteiro
        hipotetica.addInstruction(InstructionArea.CRCT, 0, Integer.parseInt(getTokenAnterior().getToken()));
        //    gera instrução CMIG
        hipotetica.addInstruction(InstructionArea.CMIG, -1, -1);
        //    gera instrução DSVT – salvando endereço da instrução na pilha de controle para posterior marcação.
        hipotetica.addInstruction(InstructionArea.DSVT, -1, -1);
        caseControlStack.add(hipotetica.intructionArea.LC - 1);
    }

    private void action135() {
        //   resolve ultima instrução de desvio (DSVF) gerada,  utilizando endereços salvos na pilha de controle, colocando como operando (LC+1)
        int casePosition = caseControlStack.pop();
        hipotetica.alterInstruction(casePosition, 0, hipotetica.intructionArea.LC + 1);
        //   gera instrução DSVS, guardando endereço da instrução  na pilha de controle, para posterior marcação
        hipotetica.addInstruction(InstructionArea.DSVS, -1, -1);
        caseControlStack.add(hipotetica.intructionArea.LC - 1);
    }

    private void action134() {
        //   gera instrução COPIA
        hipotetica.addInstruction(InstructionArea.COPY, -1, -1);
        //   gera instrução CRCT inteiro
        hipotetica.addInstruction(InstructionArea.CRCT, 0, Integer.parseInt(getTokenAnterior().getToken()));
        //   gera instrução CMIG
        hipotetica.addInstruction(InstructionArea.CMIG, -1, -1);
        //todo   resolve, se houver pendência, instruções de desvio (DSVT) utilizando endereços salvos na pilha de controle, colocando como operando (LC+1)

        //  gera instrução DSVF, guardando endereço do operando ou da instrução na pilha de controle dos CASE´s.
        hipotetica.addInstruction(InstructionArea.DSVF, -1, -1);
        caseControlStack.add(hipotetica.intructionArea.LC - 1);
    }

    private void action133() {
        //   completa instruções de desvio (DSVS), relativas ao CASE em questão, com LC, utilizando endereços salvos na pilha de controle
        int casePosition = caseControlStack.pop();
        hipotetica.alterInstruction(casePosition, 0, hipotetica.intructionArea.LC);
        //   gera instrução AMEN -, -1 (limpeza)
        hipotetica.addInstruction(InstructionArea.AMEM, -1, -1);
    }

    private void action132() {
        // TODO: 18/11/2019  Após palavra reservada CASE
        //  .  Acopla mecanismo de controle de inicio de CASE junto à pilha de controle de CASE
    }

    private void action131() {
        hipotetica.addInstruction(InstructionArea.IMPR,-1,-1);
    }

    private void action130() {
        hipotetica.addLiteralArea(lastNonTerminalSymbol.getToken());
        hipotetica.addInstruction(InstructionArea.IMPRL, -1, hipotetica.instructionliteralarea.LIT - 1);
    }

    private void action129() throws SymbolNotFoundException, SemanticException {
            Symbol symbol = symbolsTable.findByName(lastNonTerminalSymbol.getToken());
            switch (this.context) {
                case CONTEXT_READLN:
                    if (symbol.category == Symbol.VARIAVEL) {
                        this.hipotetica.addInstruction(InstructionArea.LEIT, -1, -1);
                        this.hipotetica.addInstruction(InstructionArea.ARMZ, actualLevel - symbol.level, symbol.generalA);
                    } else {
                        throw new SemanticException("ERRO 129: Símbolo não é uma variável");
                    }
                    break;
                case CONTEXT_EXPRESSAO:
                    if (symbol.category == Symbol.PROCEDURE) {
                        throw new SemanticException("ERRO 129: Símbolo é uma procedure");
                    }
                    if (symbol.category == Symbol.CONSTANTE) {
                        this.hipotetica.addInstruction(InstructionArea.CRCT, 0, symbol.generalA);
                    } else {
                        this.hipotetica.addInstruction(InstructionArea.CRVL, actualLevel - symbol.level, symbol.generalA);
                    }
                    break;
            }
    }

    private void action128() {
        this.context = CONTEXT_READLN;
    }

    private void action127() {
        //     gera  DSVF, utilizando como operando o valor de LC guardado na pilha dos repeat´s conforme ação # 126.
        hipotetica.addInstruction(InstructionArea.DSVF, 0, repeatControlStack.pop());
    }

    private void action126() {
        repeatControlStack.add(hipotetica.intructionArea.LC);
    }

    private void action125() {
        //   resolve DSVF da ação #124 colocando como operando o endereço(LC + 1)
        int whileAddress = whileControlStack.pop();
        hipotetica.alterInstruction(whileAddress, 0, hipotetica.intructionArea.LC + 1);
        //   gera DSVS com operando = endereço de retorno, salvo na pilha de ação #123
        hipotetica.addInstruction(InstructionArea.DSVS, 0, whileAddress);
    }

    private void action124() {
        //   gera DSVF com operando desconhecido.  Como o operando não é conhecido no momento, o seu endereço (ou da instrução) é guardado na pilha dos WHILE’s para posterior marcação
        hipotetica.addInstruction(InstructionArea.DSVF, -1, -1);
        whileControlStack.add(hipotetica.intructionArea.LC);
    }

    private void action123() {
        whileControlStack.add(hipotetica.intructionArea.LC);
    }

    private void action122() {
        //   resolve DSVF da ação #120, colocando como operando o endereço (LC + 1)
        this.hipotetica.alterInstruction(ifControlStack.pop(), 0, hipotetica.intructionArea.LC + 1);


        //   gera instrução DSVS, com operando desconhecido, salvando seu endereço na pilha dos IF’s para posterior marcação
        this.hipotetica.addInstruction(InstructionArea.DSVS, 0,0);
        ifControlStack.add(this.hipotetica.intructionArea.LC - 1);
    }

    private void action121() {
        //completa instrução DSVS gerada na ação #122
        // operando recebe valor de LC
        this.hipotetica.alterInstruction(ifControlStack.pop(), 0, hipotetica.intructionArea.LC + 1);
        ifControlStack.add(hipotetica.intructionArea.LC);
    }

    private void action120() {
        this.hipotetica.addInstruction(InstructionArea.DSVF, -1, -1);
        ifControlStack.add(hipotetica.intructionArea.LC - 1);
    }

    private void action118() {
        effectiveParameterNumber++;
    }

    private void action117() throws SemanticException {
            if (procedure.generalB != effectiveParameterNumber) {
                throw new SemanticException("ERRO 117: Número de parâmetros diferente de efetivo");
            } else {
                hipotetica.addInstruction(InstructionArea.CALL, -1, procedure.generalA);
                effectiveParameterNumber = 0;
            }
    }

    private void action116() throws SemanticException, SymbolNotFoundException {
            Symbol symbol = symbolsTable.findByName(lastNonTerminalSymbol.getToken());
            if (symbol.category == Symbol.PROCEDURE) {
                procedure = symbol;
            } else {
                throw new SemanticException("ERRO 116: Símbolo não é uma procedure");
            }
    }

    private void action115() {
        this.hipotetica.addInstruction(InstructionArea.ARMZ, actualLevel - leftAssignmentName.level, leftAssignmentName.generalA);
    }

    private void action114() throws SymbolNotFoundException, SemanticException {
            Symbol symbol = symbolsTable.findByName(lastNonTerminalSymbol.getToken());
            if (symbol.category == Symbol.VARIAVEL) {
                leftAssignmentName = symbol;
            } else {
                throw new SemanticException("ERRO 114: Símbolo é uma variável");
            }
    }

    private void action111() {
        // seta tipo_identificador = parâmetro
        this.identificatorType = Symbol.PARAMETRO;
        //  houve parâmetro = true
        this.hasParameters = true;
    }

    private void action110() {
        ProcedureDeviationControl procedureDeviationControl = procedureControlStack.pop();
        this.hipotetica.addInstruction(InstructionArea.RETU, -1, procedureDeviationControl.paramcount);
        this.hipotetica.intructionArea.instructions[procedureDeviationControl.pointer - 1].op2 = this.hipotetica.intructionArea.LC;
        // deleta nomes do escopo do nível na TS;
        try {
            symbolsTable.deleteSymbolByLevel(actualLevel);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        this.hipotetica.addInstruction(InstructionArea.DSVS, -1, -1);
        ProcedureDeviationControl procedureDeviationControl = new ProcedureDeviationControl();
        procedureDeviationControl.pointer = this.hipotetica.intructionArea.LC;
        procedureDeviationControl.paramcount = this.parameterNumber;
        procedureControlStack.add(procedureDeviationControl);
    }

    private void action108() throws SymbolDeclaredException {
            //  categoria := proc
            //  inserção
            Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.PROCEDURE, this.actualLevel, hipotetica.intructionArea.LC + 1, -1);
            symbolsTable.add(newSymbol);
            actualProcedure = newSymbol;
            //  houve_parametros := false
            this.hasParameters = false;
            //  n_par := 0
            this.parameterNumber = 0;
            //  incrementa nível (Nível_atual:= nível_atual + 1)
            this.actualLevel++;
            this.shift = 3;
    }

    private void action100() {
        //  Inicializa pilhas (ifs, while, repeat, procedures, case, for) –
        //  Inicializa tabela de símbolos (vetor tab_hash e a própria tabela tab_simb) –
        //  Inicializa área de instruções da máquina hipotética
        //  Inicializa área de literais da máquina hipotética
        //  Inicializa algumas variáveis :
        //  nível_atual:=0 ( faz o controle do nível atual),
        //  Pt_livre:=1 , (aponta para a próxima posição livre da tabela de símbolos)
        //  escopo[0]:=1 (usada juntamente com Tabela de símbolos), Observa-se que estas três variáveis, dependendo da implementação, podem ser inicializadas na Classe TS.
        //  número de variáveis nv :=0 (número de variáveis num bloco)
        //  deslocamento=:3 ( em relação a base),
        //  Lc:=1 (aponta para a próxima instrução a ser gerada)
        //  Lit := 1 { ponteiro auxiliar para área de literais – n. de ordem}
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
        //  Gera instrução AMEM utilizando como base o número de ações acumuladas na ação #104
        this.shift = 3;
        this.hipotetica.addInstruction(InstructionArea.AMEM, -1, shift + variableNumber);
        variableNumber = 0;
    }

    private void action104() {
        switch (this.identificatorType) {
            // caso tipo_identificador = VARIÁVEL {setado em #107}   se nome está na tabela de símbolos no escopo do nível                                     (* usar rotina de inserção*)                                  então erro  senão                                   - insere identificador na TS com os atributos: categoria =  variável, nível, deslocamento;    - acumula número de variáveis (* nv:=nv +1 *)   fim se
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
            // caso tipo_identificador = PARÂMETRO {setado em #111}   se nome está na tabela de símbolos no escopo do nível                      (* usar rotina de inserção na TS*)                       então erro   senão    insere nome na tabela de símbolos preenchendo    atributos: categoria = parâmetro, nível;    acumula número de parâmetros (* np=np+1*)   fim se
            case Symbol.PARAMETRO:
                try {
                    Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.PARAMETRO, this.actualLevel, -1, -1);
                    symbolsTable.add(newSymbol);
                    this.parameterNumber++;
                    paramControlStack.add(newSymbol);
                } catch (SymbolDeclaredException e) {
                }
                break;
        }
    }

    private void action105() {
        //     se nome já declarado no escopo do nível
        //     então erro
        //     senão
        //     insere identificador na tabela de símbolos preenchendo
        //     atributos : categoria = constante, nível
        //     Salva endereço do identificador na TS
        //     fim se
        Symbol newSymbol = new Symbol(lastNonTerminalSymbol.getToken(), Symbol.CONSTANTE, this.actualLevel, -1, -1);
        try {
            this.symbolsTable.add(newSymbol);
            lastSymbol = newSymbol;
        } catch (SymbolDeclaredException e) {
        }
    }

    private void action106() {
        // preenche atributo para constante na TS (valor base 10), utilizando endereço do identificador na TS salvo em ação #105
        lastSymbol.generalA = Integer.parseInt(lastNonTerminalSymbol.getToken());
    }

    private void action107() {
        // seta tipo_identificador = variável
        this.identificatorType = Symbol.VARIAVEL;
    }

    private lexicoAnalyzer.Symbol getTokenAnterior() {
        return tokens.get(tokens.size()-2);
    }
}
