package org.slipover.frame.share.result;

import org.slipover.frame.share.code.ServerCode;

import java.util.Map;

public class ResultMap<K, V> extends Result<Map<K, V>> {

    public ResultMap(Map<K, V> data) {
        super(data);
    }

    public ResultMap(ServerCode serverCode) {
        super(serverCode);
    }

    public ResultMap(ServerCode serverCode, String message) {
        super(serverCode, message);
    }

    public ResultMap(String code, String message) {
        super(code, message);
    }

    public ResultMap(Map<K, V> data, ServerCode serverCode) {
        super(data, serverCode);
    }

    public ResultMap(Map<K, V> data, ServerCode serverCode, String message) {
        super(data, serverCode, message);
    }

    public ResultMap(Map<K, V> data, String code, String message) {
        super(data, code, message);
    }

}
