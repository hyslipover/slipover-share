package org.slipover.frame.share.exception;

import org.slipover.frame.share.code.ServerCode;

public class ServerError extends RuntimeException {

    private String code;

    public ServerError(ServerCode serverCode) {
        this(serverCode.code(), serverCode.message());
    }

    public ServerError(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
