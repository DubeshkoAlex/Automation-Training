package exceptions;

public class IncorrectDataTypeException extends RuntimeException{
    public IncorrectDataTypeException(String message){
        super(message);
    }
}
