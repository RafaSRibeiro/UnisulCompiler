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
        Symbol symbol8 = new Symbol("pq", 3, 0, 0, 0);


        SymbolsTable symbolTable = new SymbolsTable();
        symbolTable.add(symbol1);
        symbolTable.add(symbol2);
        symbolTable.add(symbol3);
        symbolTable.add(symbol4);
        symbolTable.add(symbol5);
        symbolTable.add(symbol6);
        symbolTable.add(symbol7);
        symbolTable.add(symbol8);

        Symbol symbol1v2 = new Symbol("var1", 1, 1, 1, 1);
        Symbol symbol6v2 = new Symbol("var3", 5, 1, 1, 0);
        Symbol symbol8v2 = new Symbol("pq", 2, 1, 1, 1);
        try {
            symbolTable.update(symbol1, symbol1v2);
            symbolTable.update(symbol6, symbol6v2);
            symbolTable.update(symbol8, symbol8v2);
        } catch (ClassNotFoundException e) {

        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
