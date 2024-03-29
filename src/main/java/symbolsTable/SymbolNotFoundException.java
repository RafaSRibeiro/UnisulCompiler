package symbolsTable;

public class SymbolNotFoundException extends ClassNotFoundException {

    public String message;

    public SymbolNotFoundException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
