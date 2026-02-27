package es.fplumara.dam1.prestamos.exception;

public class CsvInvalidoException extends RuntimeException {

    public CsvInvalidoException(String message) {
        super(message);
    }

    // 👉 Añade este constructor
    public CsvInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}