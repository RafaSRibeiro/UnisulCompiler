package lexicoAnalyzer;

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
import java.awt.Color;

public class Main extends JFrame {
    private static DefaultTableModel model;

    private static JTable table;
    private TextArea textEntrada;
    private JScrollPane scrollPane;

    public Main() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Lexic Analizer");
        setResizable(false);
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width  / 2 - 320) - (this.getWidth() / 2)),
                        ((Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 280) - (this.getHeight() / 2)));
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Token");
        model.addColumn("Description");

        table = new JTable(model);

        Container container = getContentPane();
        getContentPane().setLayout(null);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(344, 32, 440, 336);
        container.add(scrollPane);

        JLabel labelEntrada = new JLabel("Input:");
        labelEntrada.setForeground(Color.WHITE);
        labelEntrada.setFont(new Font("Arial Black", Font.BOLD, 14));
        labelEntrada.setBounds(10, 10, 73, 14);
        getContentPane().add(labelEntrada);

        textEntrada = new TextArea();
        textEntrada.setBounds(10, 33, 328, 393);
        getContentPane().add(textEntrada);

        JButton buttonAnalisar = new JButton("Analize");
        buttonAnalisar.setForeground(Color.WHITE);
        buttonAnalisar.setBackground(Color.GREEN);
        buttonAnalisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String entrada = textEntrada.getText() + " ";
                LexicoAnalyzer lexicoAnalyzer = new LexicoAnalyzer();

                try {
                    List<Symbol> symbols = lexicoAnalyzer.analyze(entrada);
                    generateTableResults(symbols);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });
        buttonAnalisar.setFont(new Font("Arial Black", Font.BOLD, 14));
        buttonAnalisar.setBounds(344, 379, 215, 47);
        getContentPane().add(buttonAnalisar);

        JButton buttonLimpar = new JButton("Clean");
        buttonLimpar.setBackground(Color.RED);
        buttonLimpar.setForeground(Color.WHITE);
        buttonLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cleanTable();
            }
        });
        buttonLimpar.setFont(new Font("Arial Black", Font.BOLD, 14));
        buttonLimpar.setBounds(569, 379, 215, 47);
        getContentPane().add(buttonLimpar);

        JLabel labelResultado = new JLabel("Result:");
        labelResultado.setForeground(Color.WHITE);
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

    public static void cleanTable(){
        while (table.getRowCount()>0){
            model.removeRow(0);
        }
    }

    public static void generateTableResults(List<Symbol> symbols){
        cleanTable();
        for (Symbol symbol : symbols) {
            model.addRow(new String[] {String.valueOf(symbol.getId()),symbol.getToken(),symbol.getDescription()});
        }
    }
}