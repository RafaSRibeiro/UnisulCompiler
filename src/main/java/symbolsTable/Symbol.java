package symbolsTable;

public class Symbol {

    private static final int VARIAVEL = 1;
    private static final int CONSTANTE = 2;
    private static final int PROCEDURE = 3;
    private static final int PARAMETRO = 4;

    public String name;

    public int category;

    public int level;

    public int generalA;

    public int generalB;

    public Symbol next;

    public Symbol(String name, int category, int level, int generalA, int generalB) {
        this.name = name;
        this.category = category;
        this.level = level;
        this.generalA = generalA;
        this.generalB = generalB;
    }
}
