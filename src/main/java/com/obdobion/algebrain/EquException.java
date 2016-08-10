package com.obdobion.algebrain;

/**
 * <p>EquException class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 */
public class EquException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * <p>Constructor for EquException.</p>
     */
    public EquException() {

        super();
    }

    /**
     * <p>Constructor for EquException.</p>
     *
     * @param message a {@link java.lang.String} object.
     */
    public EquException(final String message) {

        super(message);
    }

    /**
     * <p>Constructor for EquException.</p>
     *
     * @param message a {@link java.lang.String} object.
     * @param cause a {@link java.lang.Throwable} object.
     */
    public EquException(final String message, final Throwable cause) {

        super(message, cause);
    }

    /**
     * <p>Constructor for EquException.</p>
     *
     * @param cause a {@link java.lang.Throwable} object.
     */
    public EquException(final Throwable cause) {

        super(cause);
    }
}
