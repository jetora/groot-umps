package org.flow.utils.common.utils;

public class InstantiationException extends RuntimeException{

 public InstantiationException() {
    }

    public InstantiationException(String message) {
        super(message);
    }

    public InstantiationException(Throwable cause) {
        super(cause);
    }

    public InstantiationException(String message, Throwable cause) {
        super(message, cause);
    }


}
