package hypotheticalMachine;

/**
 * Classe utilizada pela classe "Hipotetica" para armazenar a área de
 * instruções.
 * Esta classe, bem como as classes "Tipos", "AreaLiterais"
 * e "Hipotetica" foi criada por Maicon, Reinaldo e Fabio e adaptada
 * para este aplicativo.
 */
public class InstructionArea {

    public static final int AMEM = 24;
    public static final int PARA = 26;

    public Instruction instructions[] = new Instruction[1000];

    public int LC;

    /**
     * Construtor sem parâmetros.
     * Todos os atributos são inicializados com valores padrões.
     */
    public InstructionArea() {
        for (int i = 0; i < 1000; i++) {
            instructions[i] = new Instruction();
        }

        this.LC = 0;
    }
}
