package by.yoursoft.pitstop.qwepapi.exception;

public class QwepNetworkException extends RuntimeException {
    public QwepNetworkException(String message, Throwable cause) {
        super(message, cause);
    }

    public QwepNetworkException(String message) {
        super(message);
    }
}
