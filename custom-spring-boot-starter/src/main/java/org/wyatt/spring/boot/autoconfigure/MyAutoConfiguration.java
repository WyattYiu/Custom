package org.wyatt.spring.boot.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyThreadPoolProperties.class)
@ConditionalOnClass(MyThreadPoolService.class)
public class MyAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(MyAutoConfiguration.class);

    @Autowired
    MyThreadPoolProperties myThreadPoolProperties;

    @Bean
    @ConditionalOnMissingBean
    public MyThreadPoolService getInstance() {
        MyThreadPoolService myThreadPoolService = MyThreadPoolService.getInstance();
        myThreadPoolService.setCorePoolSize(myThreadPoolProperties.getCorePoolSize());
        myThreadPoolService.setMaxPoolSize(myThreadPoolProperties.getMaxPoolSize());
        myThreadPoolService.setKeepAliveSeconds(myThreadPoolProperties.getKeepAliveSeconds());
        myThreadPoolService.setQueueCapacity(myThreadPoolProperties.getQueueCapacity());
        logger.info(myThreadPoolService.toString());
        return myThreadPoolService;
    }
}
