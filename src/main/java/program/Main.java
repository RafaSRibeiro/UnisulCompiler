package program;

import lexicoAnalyzer.LexicoAnalyzer;
import lexicoAnalyzer.Symbol;
import syntacticAnalyzer.SyntacticAnalyzer;

import java.awt.Container;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

    private DefaultTableModel tokenModel = new DefaultTableModel();

    private DefaultTableModel symbolTableModel = new DefaultTableModel();

    private JTable tokenTable;

    private JTable symbolTable;

    private TextArea consoleTextArea = new TextArea();

    private JScrollPane scrollPane;


    public Main() {

        setTitle("Syntatic Analizer");
        setResizable(true);
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 320) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 280) - (this.getHeight() / 2)));

        createTokenTable();

        JLabel labelInput = new JLabel("Input:");
        labelInput.setFont(new Font("Arial Black", Font.BOLD, 14));
        labelInput.setBounds(10, 10, 73, 14);
        getContentPane().add(labelInput);

        final TextArea textAreaError = new TextArea();
        textAreaError.setBounds(10, 550, 500, 300);
        getContentPane().add(textAreaError);

        createConsoleTextArea();

        Container container = getContentPane();
        getContentPane().setLayout(null);
        container.add(scrollPane);

        JButton analyserButton = new JButton("Analize");
        analyserButton.addActionListener(new ActionListener() {

            //ação ao clica no botão
            public void actionPerformed(ActionEvent e) {
                LexicoAnalyzer lexicoAnalyzer = new LexicoAnalyzer();
                //atribui toda caixa de texto para uma string
                String entrada = consoleTextArea.getText() + "";

                try {
                    //analisa a entrada com o analizador léxico, convertendo em uma lista de simbolos
                    List<Symbol> symbols = lexicoAnalyzer.analyze(entrada);
                    //plota os simbolos na tabela gráfica
                    generateTableResults(symbols);
                    //analisa os simbolos retornados pelo lexico com analisador sintatico
                    SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer();
                    syntacticAnalyzer.analyse(symbols);
                    //se não houver nenhum erro, exibe a mensagem de conclusao
                    textAreaError.setText("Finished");
                } catch (Exception ex) {
                    textAreaError.setText(ex.getMessage());
                }


            }

        });
        analyserButton.setFont(new Font("Arial Black", Font.BOLD, 14));
        analyserButton.setBounds(550, 550, 215, 47);
        getContentPane().add(analyserButton);

        JButton buttonLimpar = new JButton("Clean");
        buttonLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cleanTokenTable();
            }
        });
        buttonLimpar.setFont(new Font("Arial Black", Font.BOLD, 14));
        buttonLimpar.setBounds(800, 550, 215, 47);
        getContentPane().add(buttonLimpar);

        JLabel labelResultado = new JLabel("Result:");
        labelResultado.setFont(new Font("Arial Black", Font.BOLD, 14));
        labelResultado.setBounds(344, 12, 91, 14);
        getContentPane().add(labelResultado);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 465);
        setVisible(true);
    }

    private void createConsoleTextArea() {
        consoleTextArea.setBounds(10, 33, 500, 500);
        consoleTextArea.setText("Program ProgramaTrabalho3;\n" +
                "Const max_nums = 5;\n" +
                "Var x,res,cont,soma: Integer;\n" +
                "Procedure calcula(y: integer);\n" +
                " var divisor : integer;\n" +
                " Procedure divide(a,b: integer);\n" +
                " begin\n" +
                " res := a / b;\n" +
                " end;\n" +
                " begin\n" +
                " Writeln(\"Informe o valor do divisor: \");\n" +
                " Readln(divisor);\n" +
                " call divide(y,divisor);\n" +
                " end;\n" +
                "Begin\n" +
                " Writeln(\"Iniciando programa...\");\n" +
                " Writeln(\"Informe o valor do dividendo: \");\n" +
                " Readln(x);\n" +
                " soma := 0;\n" +
                " for cont := 1 to max_nums do begin\n" +
                " cont := cont + 1;\n" +
                " call calcula(x);\n" +
                " Writeln(\"Resultado do cálculo: \", res);\n" +
                " soma := soma + res;\n" +
                " end;\n" +
                " Writeln(\"Resultado da soma dos cálculos: \", soma);\n" +
                "End.");
        getContentPane().add(consoleTextArea);
    }

    private void createTokenTable() {
        tokenModel.addColumn("Id");
        tokenModel.addColumn("Token");
        tokenModel.addColumn("Description");
        tokenTable = new JTable(tokenModel);
        scrollPane = new JScrollPane(tokenTable);
        scrollPane.setBounds(consoleTextArea.getWidth() + 50, 32, 500, 500);
    }

    private void createSymbolTable() {
        symbolTableModel.addColumn("Id");
        symbolTableModel.addColumn("Token");
        symbolTableModel.addColumn("Description");
        symbolTable = new JTable(symbolTableModel);
    }

    public static void main(String args[]) {
        new Main();
    }

    public void cleanTokenTable() {
        while (tokenTable.getRowCount() > 0) {
            tokenModel.removeRow(0);
        }
    }

    //metodo que plota os simbolos na tabela gráfica
    public void generateTableResults(List<Symbol> symbols) {
        cleanTokenTable();
        for (Symbol symbol : symbols) {
            tokenModel.addRow(new String[]{String.valueOf(symbol.getId()), symbol.getToken(), symbol.getDescription()});
        }
    }
}