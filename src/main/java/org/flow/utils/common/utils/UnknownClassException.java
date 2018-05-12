package org.flow.utils.common.utils;

public class UnknownClassException extends RuntimeException {

        private static final long serialVersionUID = -8441929162975509110L;

    /**
     * Constructs an {@code UnknownClassException} with no detail message.
     */
    public UnknownClassException() {
        super();
    }

    /**
     * Constructs an {@code UnknownClassException} with the
     * specified detail message.
     *
     * @param   s   the detail message.
     */
    public UnknownClassException(String s) {
        super(s);
    }

        public UnknownClassException(Throwable cause) {
        super(cause);
    }

    public UnknownClassException(String message, Throwable cause) {
        super(message, cause);
    }
}
