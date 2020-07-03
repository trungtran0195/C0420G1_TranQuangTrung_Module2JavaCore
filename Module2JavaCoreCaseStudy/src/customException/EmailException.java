package customException;

public class EmailException extends Exception {
    public EmailException(String massage) {
        super(massage);
    }
}
