package com.threadx.communication.common.agreement.packet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 同步消息发送相应器
 *
 * @author huangfukexing
 * @date 2023/8/10 16:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ThreadPoolUpdateResponseMessage extends Message {
    private static final long serialVersionUID = 5136484031973224557L;
}
