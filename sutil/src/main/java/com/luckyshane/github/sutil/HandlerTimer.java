package com.luckyshane.github.sutil;

import android.os.Handler;

import java.util.concurrent.TimeUnit;

public class HandlerTimer {
    private Handler handler;

    public HandlerTimer(Handler handler) {
        this.handler = handler;
    }

    public static HandlerTimer getMainTimer() {
        return new HandlerTimer(ThreadUtil.getMainHandler());
    }

    public CancellableRunnable schedule(final Runnable runnable, final long delay, final TimeUnit delayTimeUnit) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        CancellableRunnable timerTask = new CancellableRunnable() {
            @Override
            public void doRun() {
                runnable.run();
            }
        };
        handler.postDelayed(timerTask, delayTimeUnit.toMillis(delay));
        return timerTask;
    }

    public CancellableRunnable schedule(final Runnable runnable, final long delay, final long period, final TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException();
        }
        CancellableRunnable timerTask = new CancellableRunnable() {
            @Override
            public void doRun() {
                runnable.run();
                handler.postDelayed(this, timeUnit.toMillis(period));
            }
        };
        handler.postDelayed(timerTask, timeUnit.toMillis(delay));
        return timerTask;
    }

    public void cancel(CancellableRunnable timerTask) {
        if (timerTask != null) {
            timerTask.cancel();
            handler.removeCallbacks(timerTask);
        }
    }



}
