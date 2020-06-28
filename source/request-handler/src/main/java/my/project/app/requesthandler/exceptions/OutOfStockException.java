package my.project.app.requesthandler.exceptions;

public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}
