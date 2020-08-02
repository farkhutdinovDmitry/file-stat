package exceptions;

import java.io.IOException;

public class IncorrectPatternException extends IOException {
    private String message;

    public IncorrectPatternException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
