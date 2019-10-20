package semanticAnalyzer;

public class SemanticAnalyzer {

    public void executeAction(int action) {
        switch (action) {
            case 100:
                action100();
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
        }
    }

    private void action100() {
        initStacks();
        initSymbolsTable();
        initInstructionAreaHypotheticalMachine();
        initLiteralAreaHypotheticalMachine();
        initVariables();
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

    private void initLiteralAreaHypotheticalMachine() {
        // TODO: 10/20/19
    }

    private void initInstructionAreaHypotheticalMachine() {
        // TODO: 10/20/19
    }

    private void initSymbolsTable() {
        // TODO: 10/20/19
    }

    private void initStacks() {
        // TODO: 10/20/19
    }
}
