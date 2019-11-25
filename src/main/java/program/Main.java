package program;

import hypotheticalMachine.Instruction;
import lexicoAnalyzer.LexicoAnalyzer;
import lexicoAnalyzer.Symbol;
import syntacticAnalyzer.SyntacticAnalyzer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame {

    private DefaultTableModel tokenModel = new DefaultTableModel();

    private DefaultTableModel symbolTableModel = new DefaultTableModel();

    private DefaultTableModel instructionTableModel = new DefaultTableModel();

    private JTable tokenTable;

    private JTable symbolTable;

    private JTable instructionTable;

    private TextArea consoleTextArea = new TextArea();

    private JScrollPane tokenScrollPane;

    private JScrollPane symbolTableScrollPane;

    private JScrollPane instructionTableScrollPane;

    private Container container = getContentPane();

    private TextArea textAreaError = new TextArea();

    private List<Symbol> symbols;

    public static void main(String args[]) {
        new Main();

    }

    public Main() {
        container.setLayout(null);
        setTitle("Syntatic Analizer");
        setResizable(true);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 320) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 280) - (this.getHeight() / 2)));

        mountScreen();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 465);
        setVisible(true);

    }

    private void createConsoleTextArea() {
        JLabel labelInput = new JLabel("Input:");
        labelInput.setFont(new Font("Arial Black", Font.BOLD, 14));
        labelInput.setBounds(10, 10, 73, 14);
        container.add(labelInput);

        consoleTextArea.setBounds(10, 33, 500, 500);
        consoleTextArea.setFont(new Font("Monospaced", 0, 12));
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
        container.add(consoleTextArea);

        textAreaError.setBounds(10, 550, 500, 300);
        container.add(textAreaError);
    }

    private void mountScreen() {
        createConsoleTextArea();
        createTokenTable();
        createSymbolTable();
        createInstructionTable();
        createLexicoAnalyzeButton();
        createSyntacticAnalyzeButton();
        createButtonClean();
        createExecuteButton();
        createOpenFileButton();
    }

    private void createTokenTable() {
        tokenModel.addColumn("Id");
        tokenModel.addColumn("Token");
        tokenModel.addColumn("Description");
        tokenTable = new JTable(tokenModel);
        tokenTable.getColumnModel().getColumn(0).setMaxWidth(30);
        tokenScrollPane = new JScrollPane(tokenTable);
        tokenScrollPane.setBounds(consoleTextArea.getX() + consoleTextArea.getWidth() + 20, 32, 350, 500);
        container.add(tokenScrollPane);

        JLabel lable = new JLabel("Token Table:");
        lable.setFont(new Font("Arial Black", Font.BOLD, 14));
        lable.setBounds(tokenScrollPane.getX(), 10, tokenScrollPane.getWidth(), 14);
        container.add(lable);
    }

    private void createSymbolTable() {
        symbolTableModel.addColumn("Name");
        symbolTableModel.addColumn("Category");
        symbolTableModel.addColumn("Level");
        symbolTableModel.addColumn("General A");
        symbolTableModel.addColumn("General B");
        symbolTable = new JTable(symbolTableModel);
        symbolTable.getColumnModel().getColumn(2).setMaxWidth(40);
        symbolTableScrollPane = new JScrollPane(symbolTable);
        symbolTableScrollPane.setBounds(tokenScrollPane.getX() + tokenScrollPane.getWidth() + 20, 32, 500, 500);
        container.add(symbolTableScrollPane);

        JLabel label = new JLabel("Symbols Table:");
        label.setFont(new Font("Arial Black", Font.BOLD, 14));
        label.setBounds(symbolTableScrollPane.getX(), 10, symbolTableScrollPane.getWidth(), 14);
        container.add(label);
    }

    private void createInstructionTable() {
        instructionTableModel.addColumn("id");
        instructionTableModel.addColumn("Command");
        instructionTableModel.addColumn("Q1");
        instructionTableModel.addColumn("Q2");
        instructionTable = new JTable(instructionTableModel);
        instructionTableScrollPane = new JScrollPane(instructionTable);
        instructionTableScrollPane.setBounds(symbolTableScrollPane.getX() + symbolTableScrollPane.getWidth() + 20, 32, 300, 500);
        container.add(instructionTableScrollPane);

        JLabel label = new JLabel("Instruction Table:");
        label.setFont(new Font("Arial Black", Font.BOLD, 14));
        label.setBounds(instructionTableScrollPane.getX(), 10, instructionTableScrollPane.getWidth(), 14);
        container.add(label);
    }

    private void createLexicoAnalyzeButton() {
        JButton analyserButton = new JButton("Lexico Analize");
        analyserButton.addActionListener(new ActionListener() {

            //ação ao clica no botão
            public void actionPerformed(ActionEvent e) {
                LexicoAnalyzer lexicoAnalyzer = new LexicoAnalyzer();
                String entrada = consoleTextArea.getText() + "";

                try {
                    symbols = lexicoAnalyzer.analyze(entrada);
                    generateSymbolTableResults(symbols);
                    textAreaError.setText("Lexico Analize Finished");
                } catch (Exception ex) {
                    textAreaError.setText(ex.getMessage());
                }
            }

        });
        analyserButton.setFont(new Font("Arial Black", Font.BOLD, 14));
        analyserButton.setBounds(550, 550, 215, 47);
        container.add(analyserButton);
    }

    private void createSyntacticAnalyzeButton() {
        JButton analyserButton = new JButton("Syntactic Analize");
        analyserButton.addActionListener(new ActionListener() {

            //ação ao clica no botão
            public void actionPerformed(ActionEvent e) {
                LexicoAnalyzer lexicoAnalyzer = new LexicoAnalyzer();
                String entrada = consoleTextArea.getText() + "";

                try {
                    symbols = lexicoAnalyzer.analyze(entrada);
                    generateSymbolTableResults(symbols);

                    SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer();
                    syntacticAnalyzer.analyse(symbols);
                    generateSymbolTableResults(syntacticAnalyzer.semanticAnalyzer.symbolsTable.hashtable);
                    generateInstructionTableResults(syntacticAnalyzer.semanticAnalyzer.hipotetica.getInstructions());

                    textAreaError.setText("Syntactic Analize Finished");
                } catch (Exception ex) {
                    textAreaError.setText(ex.getMessage());
                }


            }

        });
        analyserButton.setFont(new Font("Arial Black", Font.BOLD, 14));
        analyserButton.setBounds(550, 650, 215, 47);
        container.add(analyserButton);
    }

    private void createExecuteButton() {
        JButton analyserButton = new JButton("Execute Program");
        analyserButton.addActionListener(new ActionListener() {

            //ação ao clica no botão
            public void actionPerformed(ActionEvent e) {
                LexicoAnalyzer lexicoAnalyzer = new LexicoAnalyzer();
                String entrada = consoleTextArea.getText() + "";

                try {
                    symbols = lexicoAnalyzer.analyze(entrada);
                    generateSymbolTableResults(symbols);

                    SyntacticAnalyzer syntacticAnalyzer = new SyntacticAnalyzer();
                    syntacticAnalyzer.analyse(symbols);
                    generateSymbolTableResults(syntacticAnalyzer.semanticAnalyzer.symbolsTable.hashtable);
                    generateInstructionTableResults(syntacticAnalyzer.semanticAnalyzer.hipotetica.getInstructions());

                    syntacticAnalyzer.semanticAnalyzer.hipotetica.Interpreta();
                    textAreaError.setText("Executed Finished");
                } catch (Exception ex) {
                    textAreaError.setText(ex.getMessage());
                }


            }

        });
        analyserButton.setFont(new Font("Arial Black", Font.BOLD, 14));
        analyserButton.setBounds(550, 750, 215, 47);
        container.add(analyserButton);
    }

    private void createOpenFileButton() {
        JButton analyserButton = new JButton("Open File");
        analyserButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                LexicoAnalyzer lexicoAnalyzer = new LexicoAnalyzer();
                try {
                    FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
                    dialog.setMode(FileDialog.LOAD);
                    dialog.setVisible(true);
                    String file = dialog.getDirectory() + dialog.getFile();
                    String fileString = new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
                    consoleTextArea.setText(fileString);
                    textAreaError.setText("Load Finished");
                } catch (Exception ex) {
                    textAreaError.setText(ex.getMessage());
                }


            }

        });
        analyserButton.setFont(new Font("Arial Black", Font.BOLD, 14));
        analyserButton.setBounds(550, 850, 215, 47);
        container.add(analyserButton);
    }

    private void createButtonClean() {
        JButton buttonLimpar = new JButton("Clean");
        buttonLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cleanTokenTable();
                cleanSymbolTable();
                cleanInstructionTable();
            }
        });
        buttonLimpar.setFont(new Font("Arial Black", Font.BOLD, 14));
        buttonLimpar.setBounds(800, 550, 215, 47);
        container.add(buttonLimpar);
    }

    private void cleanTokenTable() {
        while (tokenTable.getRowCount() > 0) {
            tokenModel.removeRow(0);
        }
    }

    private void cleanSymbolTable() {
        while (symbolTable.getRowCount() > 0) {
            symbolTableModel.removeRow(0);
        }
    }

    private void cleanInstructionTable() {
        while (instructionTable.getRowCount() > 0) {
            instructionTableModel.removeRow(0);
        }
    }

    private void generateSymbolTableResults(List<Symbol> symbols) {
        cleanTokenTable();
        for (Symbol symbol : symbols) {
            tokenModel.addRow(new String[]{String.valueOf(symbol.getId()), symbol.getToken(), symbol.getDescription()});
        }
    }

    private void generateInstructionTableResults(Instruction[] instructions) {
        cleanInstructionTable();
        int index = 0;
        for (Instruction instruction : instructions) {
            instructionTableModel.addRow(new String[]{String.valueOf(index), String.valueOf(instruction.getNomeCodigo()), String.valueOf(instruction.op1), String.valueOf(instruction.op2)});
            index++;
        }
    }

    private void generateSymbolTableResults(symbolsTable.Symbol[] symbols) {
        cleanSymbolTable();
        for (symbolsTable.Symbol symbol : symbols) {
            if (symbol != null)
                symbolTableModel.addRow(new String[]{symbol.name, String.valueOf(symbol.category), String.valueOf(symbol.level), String.valueOf(symbol.generalA), String.valueOf(symbol.generalB)});
        }
    }


}