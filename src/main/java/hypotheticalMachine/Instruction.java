package hypotheticalMachine;

/**
 * Classe utilizada pela classe "Hipotetica" para armazenar as informações
 * de uma instrução.
 * Esta classe, bem como as classes "AreaInstrucoes", "AreaLiterais"
 * e "Hipotetica" foi criada por Maicon, Reinaldo e Fabio e adaptada
 * para este aplicativo.
 */
class Instruction {

    public int codigo;
    public int op1;
    public int op2;

    /**
     * Construtor sem parâmetros.
     * Todos os atributos são inicializados com valores padrões.
     */
    Instruction(){
        codigo=0;
        op1=0;
        op2=0;
    }
}
