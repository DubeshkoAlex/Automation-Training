package exceptions;

public class WrongMarkException extends RuntimeException{
    public WrongMarkException(String message){
        super(message);
    }
}
