package org.wyatt.spring.boot.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "my-threadpool")
public class MyThreadPoolProperties {
    // 核心线程数
    private int corePoolSize = 1;
    // 最大线程数
    private int maxPoolSize = Integer.MAX_VALUE;;
    // 非核心线程存活时间
    private int keepAliveSeconds = 60;
    // 阻塞队列Link
    private int queueCapacity = Integer.MAX_VALUE;
}
