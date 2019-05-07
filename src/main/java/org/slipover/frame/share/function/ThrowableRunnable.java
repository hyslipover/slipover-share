package org.slipover.frame.share.function;

@FunctionalInterface
public interface ThrowableRunnable {

    void run() throws Throwable;

}
