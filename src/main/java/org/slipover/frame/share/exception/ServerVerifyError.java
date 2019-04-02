package org.slipover.frame.share.exception;

import org.slipover.frame.share.code.CommonCode;

public class ServerVerifyError extends ServerError {

    public ServerVerifyError() {
        super(CommonCode.VERIFY_ERROR);
    }

    public ServerVerifyError(String message) {
        super(CommonCode.VERIFY_ERROR.code(), message);
    }

}
