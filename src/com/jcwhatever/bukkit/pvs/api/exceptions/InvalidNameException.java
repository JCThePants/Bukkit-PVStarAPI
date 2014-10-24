package com.jcwhatever.bukkit.pvs.api.exceptions;

/**
 * Thrown when an invalid name is detected.
 */
public class InvalidNameException extends RuntimeException {

    private String _msg;

    /**
     * Constructor. Default message used.
     */
    public InvalidNameException() {
        _msg = "An invalid name was detected. Names should be alphanumeric, begin with a letter and contain no spaces. Underscores are allowed.";
    }

    /**
     * Constructor with custom message.
     *
     * @param message  Custom message.
     */
    public InvalidNameException(String message) {
        _msg = message;
    }

    /**
     * Get the exception message.
     */
    @Override
    public String getMessage() {
        return _msg;
    }

}
