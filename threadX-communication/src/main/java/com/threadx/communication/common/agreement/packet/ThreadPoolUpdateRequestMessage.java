package com.threadx.communication.common.agreement.packet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 同步消息请求器
 *
 * @author huangfukexing
 * @date 2023/8/10 16:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ThreadPoolUpdateRequestMessage extends Message {
    private static final long serialVersionUID = 5136484031973224557L;

    /**
     * 线程池核心数量
     */
    private Integer coreSize;

    /**
     * 线程池最大数量
     */
    private Integer maximumPoolSize;

    /**
     * 线程池空闲时间  单位纳秒
     */
    private Long keepAliveTime;

    /**
     * 线程池工厂全限定名
     */
    private String threadFactoryClass;

    /**
     * 线程池拒绝策略全限定名
     */
    private String rejectedExecutionHandlerClass;
}
