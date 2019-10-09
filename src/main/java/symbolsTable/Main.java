package symbolsTable;

public class Main {

    public Main() {

        //instancia simbolos
        Symbol symbol1 = new Symbol("var1", 1, 0, 0, 0);
        Symbol symbol2 = new Symbol("var2", 1, 1, 0, 0);
        Symbol symbol3 = new Symbol("abc", 2, 0, 0, 0);
        Symbol symbol4 = new Symbol("pq", 3, 0, 0, 0);
        Symbol symbol5 = new Symbol("par1", 4, 0, 0, 0);
        Symbol symbol6 = new Symbol("var3", 1, 0, 0, 0);
        Symbol symbol7 = new Symbol("pq", 3, 0, 0, 0);
        Symbol symbol8 = new Symbol("pq", 3, 0, 0, 0);
        Symbol symbol9 = new Symbol("name_proc", 4, 0, 0, 0);
        Symbol symbol10 = new Symbol("aux_var1", 2, 0, 0, 0);

//        Adiciona Symbolos
        SymbolsTable symbolTable = new SymbolsTable();
        symbolTable.add(symbol1);
        symbolTable.add(symbol2);
        symbolTable.add(symbol3);
        symbolTable.add(symbol4);
        symbolTable.add(symbol5);
        symbolTable.add(symbol6);
        symbolTable.add(symbol7);
        symbolTable.add(symbol8);
        symbolTable.add(symbol9);
        symbolTable.add(symbol10);
        System.out.println("Símbolos adicionados");
        symbolTable.printSymbolTable();

//        Altera Symbolos
        Symbol symbol1v2 = new Symbol("var1", 1, 1, 1, 1);
        Symbol symbol6v2 = new Symbol("var3", 5, 1, 1, 0);
        Symbol symbol8v2 = new Symbol("pq", 2, 1, 1, 1);
        Symbol symbol9v2 = new Symbol("name_proc", 1, 1, 0, 0);
        Symbol symbol10v2 = new Symbol("aux_var1", 2, 1, 1, 1);
        try {
            symbolTable.update(symbol1, symbol1v2);
            System.out.format("Símbolo %s editado.%n", symbol1.name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            symbolTable.update(symbol6, symbol6v2);
            System.out.format("Símbolo %s editado.%n", symbol6.name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            symbolTable.update(symbol8, symbol8v2);
            System.out.format("Símbolo %s editado.%n", symbol8.name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            symbolTable.update(symbol9, symbol9v2);
            System.out.format("Símbolo %s editado.%n", symbol9.name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            symbolTable.update(symbol10, symbol10v2);
            System.out.format("Símbolo %s editado.%n", symbol10.name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        symbolTable.printSymbolTable();

//        Remove Symbolos
        try {
            symbolTable.remove(symbol2);
            System.out.format("Símbolo %s removido.%n", symbol2.name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            symbolTable.remove(symbol8v2);
            System.out.format("Símbolo %s removido.%n", symbol8v2.name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            symbolTable.remove(symbol9);
            System.out.format("Símbolo %s removido.%n", symbol9.name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        symbolTable.printSymbolTable();

//        Busca Symbolos, TESTE COMMIT
        try {
            symbolTable.find(symbol5);
            System.out.format("Símbolo %s encontrado.%n", symbol5.name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            symbolTable.find(symbol8v2);
            System.out.format("Símbolo %s encontrado.%n", symbol8v2.name);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        new Main();
    }

}
