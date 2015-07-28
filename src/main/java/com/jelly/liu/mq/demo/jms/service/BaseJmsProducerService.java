package com.jelly.liu.mq.demo.jms.service;

import com.jelly.liu.mq.demo.jms.service.exception.ParamNullException;
import org.springframework.jms.JmsException;

import javax.jms.Destination;

/**
 * @author Jelly.Liu(Liu'zhudong)
 * @version V1.0
 * @Project mq-demo
 * @Desc TODO
 * <pre>
 * 		TODO
 * </pre>
 * @date 2015/7/28
 * @Copyright (c) Jelly.Liu(Liu'zhudong)
 */
public interface BaseJmsProducerService {

    /**
     * ������Ϣ����
     *
     * @param destination Ŀ��
     * @param message ��Ϣ
     * @throws JmsException
     * @throws ParamNullException
     */
    void sendMessage(Destination destination, final String message) throws JmsException, ParamNullException;

    /**
     * ������Ϣ����������
     *
     * @param queue ��������
     * @param message ��Ϣ
     * @throws JmsException
     * @throws ParamNullException
     */
    void sendQueueMessage(String queue, final String message) throws JmsException, ParamNullException;

    /**
     * ������Ϣ����������
     *
     * @param topic ��������
     * @param message ��Ϣ
     * @throws JmsException
     * @throws ParamNullException
     */
    void sendTopicMessage(String topic, final String message) throws JmsException, ParamNullException;
}
