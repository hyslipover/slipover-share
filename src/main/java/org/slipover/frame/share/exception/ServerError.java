package org.slipover.frame.share.exception;

import org.slipover.frame.share.code.ServerCode;

import java.util.Objects;

public class ServerError extends RuntimeException {

    private String code;

    private String normMessage;

    public ServerError(ServerCode serverCode) {
        this(serverCode.code(), serverCode.message());
    }

    public ServerError(String code, String message) {
        super(message);
        this.code = code;
        this.normMessage = message;
    }

    public ServerError(ServerCode serverCode, String message) {
        super(Objects.nonNull(message) ? message : serverCode.message());
        this.code = serverCode.code();
        this.normMessage = serverCode.message();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNormMessage() {
        return normMessage;
    }

    public void setNormMessage(String normMessage) {
        this.normMessage = normMessage;
    }
}
