package com.jelly.liu.mq.demo.jms.service.impl;

import com.jelly.liu.mq.demo.jms.service.BaseJmsProducerService;
import com.jelly.liu.mq.demo.jms.service.exception.ParamNullException;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;


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
@Service("baseJmsProducerService")
public class BaseJmsProducerServiceImpl implements BaseJmsProducerService {
    protected static final Logger logger =  LoggerFactory.getLogger(BaseJmsProducerServiceImpl.class);

    private JmsTemplate jmsTemplate;

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(Destination destination, final String message) throws JmsException, ParamNullException {
        logger.debug("send message to mq server:::");
        logger.debug("message::" + message);
        if (destination == null) {
            throw new ParamNullException(Destination.class);
        }
        if (StringUtils.isBlank(message)) {
            throw new ParamNullException("message");
        }
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    public void sendQueueMessage(String queue, final String message) throws JmsException, ParamNullException {
        if (StringUtils.isBlank(message)) {
            throw new ParamNullException("message");
        }
        if (StringUtils.isBlank(queue)) {
            throw new ParamNullException("queue name");
        }
        logger.debug("send message to mq server:::");
        logger.debug("queue::" + queue);
        logger.debug("message::" + message);
        Destination destination = new ActiveMQQueue(queue);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }

    public void sendTopicMessage(String topic, final String message) throws JmsException, ParamNullException {
        if (StringUtils.isBlank(message)) {
            throw new ParamNullException("message");
        }
        if (StringUtils.isBlank(topic)) {
            throw new ParamNullException("topic name");
        }
        logger.debug("send message to mq server:::");
        logger.debug("topic::" + topic);
        logger.debug("message::" + message);
        Destination destination = new ActiveMQTopic(topic);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);
            }
        });
    }
}
