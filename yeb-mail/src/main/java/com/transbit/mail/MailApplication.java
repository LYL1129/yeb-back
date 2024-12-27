package com.transbit.mail; /**
 * @author lylstart
 * @data 2024/12/27 - 18:47
 * 2024 - 12月 - 周五 - 18 - 47
 */

import com.transbit.server.pojo.MailConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @description: TODO
 * @author jd
 * @date 2024/12/27 18:47
 * @version 1.0
 */
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class MailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class, args);
    }

    @Bean
    public Queue queue(){
        return new Queue(MailConstant.MAIL_QUEUE_NAME);
    }
}
