package by.yoursoft.pitstop.qwepapi.exception;

public class QwepBadResponseException extends RuntimeException {
    public QwepBadResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public QwepBadResponseException(String message) {
        super(message);
    }
}
