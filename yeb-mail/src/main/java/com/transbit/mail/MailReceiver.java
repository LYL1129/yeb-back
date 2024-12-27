/**
 * @author lylstart
 * @data 2024/12/27 - 19:12
 * 2024 - 12月 - 周五 - 19 - 12
 */
package com.transbit.mail;

import com.transbit.server.pojo.Employee;
import com.transbit.server.pojo.MailConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.Message;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import com.rabbitmq.client.Channel;


import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;

/**
 * @description: TODO
 * @author jd
 * @date 2024/12/27 19:12
 * @version 1.0
 */
@Component
public class MailReceiver {
    public static final Logger log = LoggerFactory.getLogger(MailReceiver.class);

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MailProperties mailProperties;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private RedisTemplate redisTemplate;

    @RabbitListener(queues = MailConstant.MAIL_QUEUE_NAME)
    public void handler(Employee employee){

//        Employee employee = (Employee) msg.getPayload();
//        MessageHeaders headers = msg.getHeaders();
//        String msgId = (String) headers.get("spring_return_message_correlation");
//        HashOperations hash = redisTemplate.opsForHash();
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try{
//            if(hash.entries("mail_log").containsKey(msgId)){
//                log.error("消息已经被取消===>{}", msgId);
//                channel.basicAck(tag, false);
//                return;
//            }
            helper.setFrom(mailProperties.getUsername());
            helper.setTo(employee.getEmail());
            helper.setSubject("入职欢迎文件");
            helper.setSentDate(new Date());
            Context context = new Context();

            context.setVariable("name", employee.getName());
            context.setVariable("posName", employee.getPosition().getName());
            context.setVariable("joblevelName", employee.getJoblevel().getName());
            context.setVariable("departmentName", employee.getDepartment().getName());
            String mail = templateEngine.process("mail", context);
            helper.setText(mail, true);
            mailSender.send(message);
            log.info("消息发送成功");
//            hash.put("mail_log", msgId, "OK");
//            channel.basicAck(tag, false);
        }catch (Exception e){
            log.error("邮件发送失败==>{}", e.getMessage());
//            try{
//                channel.basicNack(tag, false, true);
//            }catch(IOException ex){
//                log.error("邮件发送失败===>{}", ex.getMessage());
//            }
//            log.error("邮件发送失败==>{}", e.getMessage());

        }

    }


}
