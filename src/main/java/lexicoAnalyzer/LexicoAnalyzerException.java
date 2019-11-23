package lexicoAnalyzer;

public class LexicoAnalyzerException extends Exception {

    public String message;

    public LexicoAnalyzerException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
