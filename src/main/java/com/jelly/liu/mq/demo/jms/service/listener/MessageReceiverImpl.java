/**
 * 
 */
package com.jelly.liu.mq.demo.jms.service.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.stereotype.Service;

/**
 * @author user
 *
 */
@Service("messageReceiver")
public class MessageReceiverImpl implements MessageListener{

	@Override
	public void onMessage(Message message) {
		if(message == null){
			return;
		}
		System.out.println("[receive message]");  
        if(message instanceof TextMessage){
        	TextMessage textMessage = (TextMessage)message;
			try {
				System.out.println("MSG:::" + textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}	
        }
        		
	}

}
