package com.luckyshane.github.sutil;

public abstract class CancellableRunnable implements Runnable {
    private volatile boolean cancelled;

    @Override
    public final void run() {
        if (!cancelled) {
            doRun();
        }
    }

    public abstract void doRun();

    public void cancel() {
        cancelled = true;
    }

    public boolean isCancelled() {
        return cancelled;
    }

}
