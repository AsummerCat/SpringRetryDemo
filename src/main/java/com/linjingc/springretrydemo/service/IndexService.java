package com.linjingc.springretrydemo.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class IndexService {

    /**
     * value：抛出指定异常才会重试
     * include：和value一样，默认为空，当exclude也为空时，默认所有异常
     * exclude：指定不处理的异常
     * maxAttempts：最大重试次数，默认3次
     * backoff：重试等待策略，
     * 默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000； 以毫秒为单位的延迟（默认 1000）
     * multiplier（指定延迟倍数）默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。
     * @return
     */
    @Retryable
//    @Retryable(value = Exception.class,maxAttempts = 3,backoff = @Backoff(delay = 2000,multiplier = 1.5),recover = "recover")
    public String test() {
        System.out.println("准备发起HTTP调用..." + new Date());
        throw new RuntimeException("HTTP调用异常");
//        return "null";
    }

    /**
     * 降级方法
     */
    @Recover
    public String recover(Exception e) {
        System.out.println("recover-->记日志到数据库 或者调用其余的方法");
        return "失败";
    }
}
