package semanticAnalyzer;

public class SemanticException extends Exception {

    public String message;

    public SemanticException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }

}
