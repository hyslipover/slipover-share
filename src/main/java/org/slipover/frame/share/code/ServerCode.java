package org.slipover.frame.share.code;

import java.io.Serializable;

/**
 * 服务code
 */
public interface ServerCode extends Serializable {

    String code();

    String message();

    default boolean equalsCode(String code) {
        return code().equals(code);
    }

}
