package com.threadx.communication.common.future;

import com.threadx.communication.common.agreement.packet.Message;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 异步消息结果集
 *
 * @author huangfukexing
 * @date 2023/8/10 16:00
 */
public class DefaultFuture extends CompletableFuture<Object> implements Serializable {
    private static final long serialVersionUID = 7109955063081226484L;

    @Override
    public Object get() throws InterruptedException, ExecutionException {
        return super.get();
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return super.get(timeout, unit);
    }

    @Override
    public Object getNow(Object valueIfAbsent) {
        return super.getNow(valueIfAbsent);
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return super.cancel(mayInterruptIfRunning);
    }

    /**
     * 通知完成
     *
     * @param message 消息结果集
     */
    public void received(Message message) {
        complete(message);
    }
}
