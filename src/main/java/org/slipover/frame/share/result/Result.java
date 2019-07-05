package org.slipover.frame.share.result;

import org.slipover.frame.share.code.CommonCode;
import org.slipover.frame.share.code.ServerCode;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Result<T> implements Serializable {

    private T data;

    private String code;

    private String message;

    private String normMessage;

    public Result(T data) {
        this.data = data;
        setCode(CommonCode.SUCCESS);
    }

    public Result(ServerCode serverCode) {
        setCode(serverCode);
    }

    public Result(ServerCode serverCode, String message) {
        setCode(serverCode);
        this.message = message;
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
        this.normMessage = message;
    }

    public Result(T data, ServerCode serverCode) {
        this.data = data;
        setCode(serverCode);
    }

    public Result(T data, ServerCode serverCode, String message) {
        this.data = data;
        setCode(serverCode);
        this.message = message;
    }

    public Result(T data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
        this.normMessage = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode(ServerCode serverCode) {
        this.code = serverCode.code();
        this.normMessage = serverCode.message();
        if (message == null) {
            this.message = serverCode.message();
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNormMessage() {
        return normMessage;
    }

    public void setNormMessage(String normMessage) {
        this.normMessage = normMessage;
    }

    public boolean isCode(String code) {
        return code.equals(this.code);
    }

    public boolean isCode(ServerCode serverCode) {
        return Objects.nonNull(serverCode) && serverCode.code().equals(this.code);
    }

    public boolean isSuccess() {
        return CommonCode.SUCCESS.equalsCode(code) && Objects.nonNull(data);
    }

    public boolean isVerifyError(){
        return CommonCode.VERIFY_ERROR.equalsCode(code);
    }

    public boolean isError() {
        return CommonCode.ERROR.equalsCode(code);
    }

    public boolean isException() {
        return CommonCode.EXCEPTION.equalsCode(code);
    }

    public T orElse(T other) {
        return data != null ? data : other;
    }

    public T orElseGet(Supplier<T> other) {
        return data != null ? data : other.get();
    }

    public void ifEqualsCode(String code, Consumer<T> consumer) {
        if (isCode(code)) {
            consumer.accept(data);
        }
    }

    public void ifEqualsCode(ServerCode serverCode, Consumer<T> consumer) {
        if (isCode(serverCode)) {
            consumer.accept(data);
        }
    }

    public <R> Optional<R> ifEqualsCode(String code, Function<T,R> function) {
        if (isCode(code)) {
            return Optional.ofNullable(function.apply(data));
        }
        return Optional.empty();
    }

    public <R> Optional<R> ifEqualsCode(ServerCode serverCode, Function<T,R> function) {
        if (isCode(serverCode)) {
            return Optional.ofNullable(function.apply(data));
        }
        return Optional.empty();
    }

    public void ifSuccess(Consumer<T> consumer) {
        if (isSuccess()) {
            consumer.accept(data);
        }
    }

    public <R> Optional<R> ifSuccess(Function<T,R> function) {
        if (isSuccess()) {
            return Optional.ofNullable(function.apply(data));
        }
        return Optional.empty();
    }

    public <R> Result<R> map(Function<T, R> transition) {
        return new Result<>(transition.apply(data), code, message);
    }

}
