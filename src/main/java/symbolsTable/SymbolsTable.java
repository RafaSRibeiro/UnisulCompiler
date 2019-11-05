package symbolsTable;

public class SymbolsTable {

    private final int tableSize = 25147; //first prime after 25143

    Symbol[] hashtable = new Symbol[tableSize];

    public SymbolsTable() {
        inithashTable();
    }

    public void add(Symbol symbol) throws SymbolDeclaredException {
        if (exists(symbol))
            throw new SymbolDeclaredException();
        int index = this.hash(symbol.name, tableSize);
        if (hashtable[index] == null) {
            hashtable[index] = symbol;
        } else {
            Symbol symbolLinked = hashtable[index];
            while (symbolLinked.next != null)
                symbolLinked = symbolLinked.next;
            symbolLinked.next = symbol;
        }
    }

    public void update(Symbol symbol, Symbol newSymbol) throws ClassNotFoundException {
        int index = this.hash(symbol.name, tableSize);
        if (hashtable[index] != null) {
            Symbol symbolLinked = hashtable[index];
            if (symbolLinked == symbol && symbolLinked.next == null) {
                hashtable[index] = newSymbol;
            } else if (symbolLinked == symbol) {
                newSymbol.next = symbolLinked.next;
                hashtable[index] = newSymbol;
            } else {
                Symbol previousSymbol = symbolLinked;
                symbolLinked = symbolLinked.next;
                while (symbolLinked != symbol){
                    previousSymbol = symbolLinked;
                    symbolLinked = symbolLinked.next;
                }
                if (symbolLinked != null) {
                    previousSymbol.next = newSymbol;
                    newSymbol.next = symbolLinked.next;
                } else {
                    throw new ClassNotFoundException("Símbolo " + symbol.name + " não existe");
                }
            }
        } else {
            throw new ClassNotFoundException("Símbolo " + symbol.name + " não existe");
        }
    }

    public void remove(Symbol symbol) throws ClassNotFoundException {
        int index = this.hash(symbol.name, tableSize);
        if (hashtable[index] != null) {
            Symbol symbolLinked = hashtable[index];
            if (symbolLinked == symbol && symbolLinked.next == null) { //Verifica se é o mesmo simbolo do hash e se não possui lista encadeada.
                hashtable[index] = null;
            } else if (symbolLinked == symbol && symbolLinked.next != null) { //Verifica se é o mesmo simbolo do hash e se possui lista encadeada.
                hashtable[index] = symbolLinked.next;
            } else if (symbolLinked.next != null) { //Se não for o mesmo simbolo do has mas possui lista encadeada, procura pelos itens da lista.
                Symbol previousSymbol = symbolLinked;
                symbolLinked = symbolLinked.next;
                while (symbolLinked != null && symbolLinked != symbol){
                    previousSymbol = symbolLinked;
                    symbolLinked = symbolLinked.next;
                }
                if (symbolLinked != null) {
                    previousSymbol.next = symbolLinked.next;
                } else {
                    throw new ClassNotFoundException("Símbolo " + symbol.name + " não existe");
                }
            } else {
                throw new ClassNotFoundException("Símbolo " + symbol.name + " não existe");
            }
        } else {
            throw new ClassNotFoundException("Símbolo " + symbol.name + " não existe");
        }
    }

    public boolean exists(Symbol symbol) {
        int index = this.hash(symbol.name, tableSize);
        if (hashtable[index] != null) {
            Symbol symbolLinked = hashtable[index];
            if (symbolLinked == symbol)
                return true;
            while (symbolLinked.next != null) {
                symbolLinked = symbolLinked.next;
                if (symbolLinked == symbol)
                    return true;
            }
            if (symbolLinked.next == null)
                return false;
        } else {
            return false;
        }
        return true;
    }

    public Symbol find(Symbol symbol) throws SymbolNotFoundException {
        int index = this.hash(symbol.name, tableSize);
        if (hashtable[index] != null) {
            Symbol symbolLinked = hashtable[index];
            if (symbolLinked == symbol)
                return symbolLinked;
            while (symbolLinked.next != null) {
                symbolLinked = symbolLinked.next;
                if (symbolLinked == symbol)
                    return symbolLinked;
            }
            if (symbolLinked.next == null)
                throw new SymbolNotFoundException("Símbolo " + symbol.name + " não existe");
        } else {
            throw new SymbolNotFoundException("Símbolo " + symbol.name + " não existe");
        }
        return symbol;
    }

    public void printSymbolTable() {
        String returnTable = "| %-15s | %-4d | %-4d | %-4d | %-4d |%n";
        System.out.format("+-----------------+------+------+------+------+%n");
        System.out.format("| name            | cat  | lvl  | gen1 | gen2 |%n");
        System.out.format("+-----------------+------+------+------+------+%n");
        Symbol actualSymbol;

        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                actualSymbol = hashtable[i];
                boolean colision = true;
                boolean lastColision = false;

                if (actualSymbol.next == null){
                    System.out.format(returnTable, actualSymbol.name, actualSymbol.category, actualSymbol.level, actualSymbol.generalA,  actualSymbol.generalB);
                }else {
                    do {
                        if (colision) {
                            System.out.format(returnTable, actualSymbol.name, actualSymbol.category, actualSymbol.level, actualSymbol.generalA, actualSymbol.generalB);
                        }else{
                            System.out.format(returnTable, " - " + actualSymbol.name, actualSymbol.category, actualSymbol.level, actualSymbol.generalA, actualSymbol.generalB);
                        }
                        if (actualSymbol.next == null)
                            lastColision = true;
                        actualSymbol = actualSymbol.next;
                        colision = false;
                    } while (lastColision == false);
                }
            }
        }
        System.out.format("+-----------------+------+------+------+------+%n");
    }

    private int hash(String key, int tableSize) {
        int hashVal = 0; //uses Horner’s method to evaluate a polynomial
        for (int i = 0; i < key.length(); i++)
            hashVal = 37 * hashVal + key.charAt(i);
        hashVal %= tableSize;
        if (hashVal < 0)
            hashVal += tableSize; //needed if hashVal is negative
        return hashVal;
    }

    private void inithashTable() {
        for (int index = 0; index < tableSize; index++)
            hashtable[index] = null;
    }
}
