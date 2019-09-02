package syntacticAnalyzer;

public class SyntacticAnalyzerException extends Exception {


    public SyntacticAnalyzerException() {
    }

    public SyntacticAnalyzerException(String s) {
        super(s);
    }

    public SyntacticAnalyzerException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public SyntacticAnalyzerException(Throwable throwable) {
        super(throwable);
    }

    public SyntacticAnalyzerException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }

}
