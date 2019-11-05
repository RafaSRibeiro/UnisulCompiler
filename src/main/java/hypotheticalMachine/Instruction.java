package hypotheticalMachine;

/**
 * Classe utilizada pela classe "Hipotetica" para armazenar as informações
 * de uma instrução.
 * Esta classe, bem como as classes "AreaInstrucoes", "AreaLiterais"
 * e "Hipotetica" foi criada por Maicon, Reinaldo e Fabio e adaptada
 * para este aplicativo.
 */
public class Instruction {

    public int codigo;
    public int op1;
    public int op2;

    /**
     * Construtor sem parâmetros.
     * Todos os atributos são inicializados com valores padrões.
     */
    public Instruction() {
        codigo = 0;
        op1 = 0;
        op2 = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public Instruction setCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    public int getOp1() {
        return op1;
    }

    public Instruction setOp1(int op1) {
        this.op1 = op1;
        return this;
    }

    public int getOp2() {
        return op2;
    }

    public Instruction setOp2(int op2) {
        this.op2 = op2;
        return this;
    }
}
