package com.example.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisDelayQueueRunner implements CommandLineRunner {

    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void run(String... args) {
        new Thread(() -> {
            while (true) {
                try {
                    RedisDelayQueueEnum[] queueEnums = RedisDelayQueueEnum.values();
                    for (RedisDelayQueueEnum queueEnum : queueEnums) {
                        Object value = redisDelayQueueUtil.getDelayQueue(queueEnum.getCode());
                        log.info("拉取到的任务：{}", value);
                        if (value != null) {
                            OrderPaymentTimeout redisDelayQueueHandle = (OrderPaymentTimeout) applicationContext.getBean(queueEnum.getBeanId());
                            redisDelayQueueHandle.execute(value);
                        }
                    }
                } catch (Exception e) {
                    log.error("(Redis延迟队列异常中断) {}", e.getMessage());
                }
            }
        }).start();
        log.info("(Redis延迟队列启动成功)");
    }
}
