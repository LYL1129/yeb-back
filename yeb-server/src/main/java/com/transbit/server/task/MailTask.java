package com.transbit.server.task;
/**
 * @author lylstart
 * @data 2024/12/27 - 21:55
 * 2024 - 12月 - 周五 - 21 - 55
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.transbit.server.pojo.Employee;
import com.transbit.server.pojo.MailConstant;
import com.transbit.server.pojo.MailLog;
import com.transbit.server.service.IEmployeeService;
import com.transbit.server.service.IMailLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @description: TODO
 * @author jd
 * @date 2024/12/27 21:55
 * @version 1.0
 */
@Component
public class MailTask {
    @Autowired
    private IMailLogService mailLogService;

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Scheduled(cron = "0/10 * * * * ?")
    public void mailTask(){
        List<MailLog> list = mailLogService.list(new QueryWrapper<MailLog>().eq("status", 0).
                lt("tryTime", LocalDateTime.now()));
        list.forEach(mailLog -> {
            //如果重试次数超过3次，更新状态为投递失败，不在重试
            if(mailLog.getCount()>=3){
                mailLogService.update(new UpdateWrapper<MailLog>().set("status", 2).
                        eq("msgId", mailLog.getMsgId()));
            }
            mailLogService.update(new UpdateWrapper<MailLog>().
                    set("count", mailLog.getCount()+1).
                    set("updateTime", LocalDateTime.now()).
                    set("tryTime", LocalDateTime.now().plusMinutes(MailConstant.MSG_TIMEOUT)).
                    eq("msgId", mailLog.getMsgId()));

            Employee employee = employeeService.getEmployee(mailLog.getEid()).get(0);
            rabbitTemplate.convertAndSend(
                    MailConstant.MAIL_EXCHANGE_NAME,
                    MailConstant.MAIL_ROUTING_KEY_NAME,
                    employee,
                    new CorrelationData(mailLog.getMsgId()));
        });
    }
}
