package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public class EquException extends Exception {

    private static final long serialVersionUID = 1L;

    public EquException() {

        super();
    }

    public EquException(final String message) {

        super(message);
    }

    public EquException(final String message, final Throwable cause) {

        super(message, cause);
    }

    public EquException(final Throwable cause) {

        super(cause);
    }
}
