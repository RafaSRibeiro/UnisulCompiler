package semanticAnalyzer;

import hypotheticalMachine.Hipotetica;
import symbolsTable.SymbolsTable;

import java.util.Stack;

public class SemanticAnalyzer {

     private Stack conditionStack;

     private SymbolsTable symbolsTable;

     private int actualLevel;

     private int freePosition;

     private int variableNumber;

     private int shift;

     private Hipotetica hipotetica;

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
    }

    private void action155() {
    }

    private void action154() {
    }

    private void action153() {
    }

    private void action152() {
    }

    private void action151() {
    }

    private void action150() {
    }

    private void action149() {
    }

    private void action148() {
    }

    private void action147() {
    }

    private void action146() {
    }

    private void action145() {
    }

    private void action144() {
    }

    private void action143() {
    }

    private void action142() {
    }

    private void action141() {
    }

    private void action140() {
    }

    private void action139() {
    }

    private void action138() {
    }

    private void action137() {
    }

    private void action136() {
    }

    private void action135() {
    }

    private void action134() {
    }

    private void action133() {
    }

    private void action132() {
    }

    private void action131() {
    }

    private void action130() {
    }

    private void action129() {
    }

    private void action128() {
    }

    private void action127() {
    }

    private void action126() {
    }

    private void action125() {
    }

    private void action124() {
    }

    private void action123() {
    }

    private void action122() {
    }

    private void action121() {
    }

    private void action120() {
    }

    private void action118() {
    }

    private void action117() {
    }

    private void action116() {
    }

    private void action115() {
    }

    private void action114() {
    }

    private void action111() {
    }

    private void action110() {
    }

    private void action109() {
    }

    private void action108() {
    }

    private void action100() {
        this.conditionStack = new Stack();
        this.symbolsTable = new SymbolsTable();
        this.actualLevel = 0;
        this.freePosition = 1;
        this.variableNumber = 0;
        this.shift = 3;
        this.hipotetica = new Hipotetica();
    }

    private void action102() {
//        this.hipotetica.incluirAI(Hipotetica.AMEM, );
    }

    private void action104() {
        // TODO: 10/20/19
    }

    private void action105() {
        // TODO: 10/20/19
    }

    private void action106() {
        // TODO: 10/20/19
    }

    private void action107() {
        // TODO: 10/20/19
    }

    private void initVariables() {
        // TODO: 10/20/19
    }

}
