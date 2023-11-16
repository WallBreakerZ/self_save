package com.example.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderPaymentTimeout {
    public void execute(Object map) {
        log.info("{} {}", RedisDelayQueueEnum.ORDER_PAYMENT_TIMEOUT.getName(), map);
        // TODO 订单支付超时，自动取消订单处理业务...

    }
}
