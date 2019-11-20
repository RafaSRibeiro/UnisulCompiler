package program;

import lexicoAnalyzer.LexicoAnalyzer;
import lexicoAnalyzer.Symbol;
import syntacticAnalyzer.SyntacticAnalyzer;
import syntacticAnalyzer.SyntacticAnalyzerException;

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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {
    private static DefaultTableModel model;

    private static JTable table;
    private TextArea textArea;
    private JScrollPane scrollPane;

    public Main() {
        //definição da tela
        setTitle("Syntatic Analizer");
        setResizable(true);
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 320) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 280) - (this.getHeight() / 2)));
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Token");
        model.addColumn("Description");

        table = new JTable(model);

        JLabel labelInput = new JLabel("Input:");
        labelInput.setFont(new Font("Arial Black", Font.BOLD, 14));
        labelInput.setBounds(10, 10, 73, 14);
        getContentPane().add(labelInput);

        final TextArea textAreaError = new TextArea();
        textAreaError.setBounds(10, 550, 500, 300);
        getContentPane().add(textAreaError);

        textArea = new TextArea();
        textArea.setBounds(10, 33, 500, 500);
        textArea.setText("Program ProgramaTrabalho3;\n" +
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
        getContentPane().add(textArea);

        Container container = getContentPane();
        getContentPane().setLayout(null);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(textArea.getWidth() + 50, 32, 500, 500);
        container.add(scrollPane);

        JButton analyserButton = new JButton("Analize");
        analyserButton.addActionListener(new ActionListener() {

            //ação ao clica no botão
            public void actionPerformed(ActionEvent e) {
                LexicoAnalyzer lexicoAnalyzer = new LexicoAnalyzer();
                //atribui toda caixa de texto para uma string
                String entrada = textArea.getText() + "";

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
                } catch (SyntacticAnalyzerException ex) {
                    textAreaError.setText("Error: " + ex.getMessage());
                } catch (Exception ex) {
                    textAreaError.setText("Error: " + ex.getMessage());
                }


            }

        });
        analyserButton.setFont(new Font("Arial Black", Font.BOLD, 14));
        analyserButton.setBounds(550, 550, 215, 47);
        getContentPane().add(analyserButton);

        JButton buttonLimpar = new JButton("Clean");
        buttonLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cleanTable();
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
//        analyserButton.doClick();
    }

    public static void main(String args[]) {
        new Main();
    }

    //metodo que limpa a tabela gráfica
    public static void cleanTable() {
        while (table.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    //metodo que plota os simbolos na tabela gráfica
    public static void generateTableResults(List<Symbol> symbols) {
        cleanTable();
        for (Symbol symbol : symbols) {
            model.addRow(new String[]{String.valueOf(symbol.getId()), symbol.getToken(), symbol.getDescription()});
        }
    }
}