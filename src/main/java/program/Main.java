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
        setTitle("Lexic Analizer");
        setResizable(true);
        this.setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 320) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 280) - (this.getHeight() / 2)));
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Token");
        model.addColumn("Description");

        table = new JTable(model);

        JLabel labelEntrada = new JLabel("Input:");
        labelEntrada.setFont(new Font("Arial Black", Font.BOLD, 14));
        labelEntrada.setBounds(10, 10, 73, 14);
        getContentPane().add(labelEntrada);

        textArea = new TextArea();
        textArea.setBounds(10, 33, 500, 500);
        getContentPane().add(textArea);

        Container container = getContentPane();
        getContentPane().setLayout(null);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(textArea.getWidth() + 50, 32, 500, 500);
        container.add(scrollPane);

        JButton analyserButton = new JButton("Analize");
        analyserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String entrada = textArea.getText() + " ";
                SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer();
                try {
                    syntacticAnalyzer.analyse(entrada);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

//                LexicoAnalyzer lexicoAnalyzer = new LexicoAnalyzer();
//
//                try {
//                    List<Symbol> symbols = lexicoAnalyzer.analyze(entrada);
//                    generateTableResults(symbols);
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(null, ex.getMessage());
//                }

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
    }

    public static void main(String args[]) {
        new Main();
    }

    public static void cleanTable() {
        while (table.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public static void generateTableResults(List<Symbol> symbols) {
        cleanTable();
        for (Symbol symbol : symbols) {
            model.addRow(new String[]{String.valueOf(symbol.getId()), symbol.getToken(), symbol.getDescription()});
        }
    }
}