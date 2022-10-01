package org.wyatt.spring.boot.autoconfigure;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class MyThreadPoolService {
    // 单例对象
    private static volatile MyThreadPoolService myThreadPoolService;
    // 核心线程数
    private Integer corePoolSize = 1;
    // 最大线程数
    private Integer maxPoolSize = Integer.MAX_VALUE;
    // 非核心线程存活时间
    private Integer keepAliveSeconds = 60;
    // 阻塞队列Link
    private Integer queueCapacity = Integer.MAX_VALUE;

    // 单例模式
    public static MyThreadPoolService getInstance() {
        if (myThreadPoolService == null) {
            synchronized (MyThreadPoolService.class) {
                if (myThreadPoolService == null) {
                    myThreadPoolService = new MyThreadPoolService();
                }
            }
        }
        return myThreadPoolService;
    }
}
