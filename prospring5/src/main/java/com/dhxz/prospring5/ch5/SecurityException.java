package com.dhxz.prospring5.ch5;

public class SecurityException extends RuntimeException {
    private static final long serialVersionUID = -8075484431778376227L;

    public SecurityException() {
    }

    public SecurityException(String message) {
        super(message);
    }

    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityException(Throwable cause) {
        super(cause);
    }
}
