package com.transbit.server.pojo;
/**
 * @author lylstart
 * @data 2024/12/27 - 19:00
 * 2024 - 12月 - 周五 - 19 - 00
 */

/**
 * @description: 消息状态
 * @author jd
 * @date 2024/12/27 19:00
 * @version 1.0
 */
public class MailConstant {
    /**
     * 消息投递中
     */
    public static final Integer DELIVERING=0;
    /**
     * 消息投递成功
     */
    public static final Integer SUCCESS=1;
    /**
     * 消息投递失败
     */
    public static final Integer FAILURE=2;
    /**
     * 最大重试次数
     */
    public static final Integer MAX_TRY_COUNT=3;
    /**
     * 消息超时时间
     */
    public static final Integer MSG_TIMEOUT=1;
    /**
     * 队列
     */
    public static final String MAIL_QUEUE_NAME="mail.queue";
    /**
     * 交换机
     */
    public static final String MAIL_EXCHANGE_NAME="mail.exchange";
    /**
     * 路由键
     */
    public static final String MAIL_ROUTING_KEY_NAME="mail.routingKey";
}