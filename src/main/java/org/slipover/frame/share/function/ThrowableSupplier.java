package org.slipover.frame.share.function;

@FunctionalInterface
public interface ThrowableSupplier<T> {
    /**
     * Gets a result.
     *
     * @return a result
     */
    T get() throws Throwable;
}
