package symbolsTable;

public class Symbol {

    public static final int VARIAVEL = 1;
    public static final int CONSTANTE = 2;
    public static final int PROCEDURE = 3;
    public static final int PARAMETRO = 4;
    public static final int ROTULO = 5;

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
