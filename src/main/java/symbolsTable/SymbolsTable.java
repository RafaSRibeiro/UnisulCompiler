package symbolsTable;

public class SymbolsTable {

    private final int tableSize = 25147; //first prime after 25143

    Symbol[] hashtable = new Symbol[tableSize];

    public SymbolsTable() {
        inithashTable();
    }

    public void add(Symbol symbol) {
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

    public void remove(Symbol symbol) throws ClassNotFoundException {
        int index = this.hash(symbol.name, tableSize);
        if (hashtable[index] != null) {
            Symbol symbolLinked = hashtable[index];
            if (symbolLinked == symbol && symbolLinked.next == null) {
                hashtable[index] = null;
            } else if (symbolLinked == symbol) {
                hashtable[index] = symbolLinked.next;
            } else {
                Symbol previousSymbol = symbolLinked;
                while (symbolLinked.next != symbol){
                    previousSymbol = symbolLinked;
                    symbolLinked = symbolLinked.next;
                }
                if (symbolLinked != null) {
                    previousSymbol.next = symbolLinked.next;
                }
            }
        } else {
            throw new ClassNotFoundException();
        }
    }

    public Symbol find(Symbol symbol) throws ClassNotFoundException {
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
        } else {
            throw new ClassNotFoundException();
        }
        return symbol;
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
