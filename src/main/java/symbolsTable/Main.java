package symbolsTable;

public class Main {

    public Main() {

        Symbol symbol1 = new Symbol("var1", 1, 0, 0, 0);
        Symbol symbol2 = new Symbol("var2", 1, 1, 0, 0);
        Symbol symbol3 = new Symbol("abc", 2, 0, 0, 0);
        Symbol symbol4 = new Symbol("pq", 3, 0, 0, 0);
        Symbol symbol5 = new Symbol("par1", 4, 0, 0, 0);
        Symbol symbol6 = new Symbol("var3", 1, 0, 0, 0);
        Symbol symbol7 = new Symbol("pq", 3, 0, 0, 0);


        SymbolsTable symbolTable = new SymbolsTable();
        symbolTable.add(symbol1);
        symbolTable.add(symbol2);
        symbolTable.add(symbol3);
        symbolTable.add(symbol4);
        symbolTable.add(symbol5);
        symbolTable.add(symbol6);
        symbolTable.add(symbol7);
    }

    public static void main(String[] args) {
        new Main();
    }
}
