package by.yoursoft.pitstop.qwepapi.exception;

public class QwepTokenNotValidException extends RuntimeException {
    public QwepTokenNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public QwepTokenNotValidException(String message) {
        super(message);
    }
}
