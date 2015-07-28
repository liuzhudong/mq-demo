/**
 * 
 */
package com.jelly.liu.mq.demo.action;

import com.jelly.liu.mq.demo.jms.service.BaseJmsProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "test")
public class TestAction {
	@Resource
	private BaseJmsProducerService baseJmsProducerService;

	@Autowired
	private Destination testQueue;

	@Autowired
	private Destination testTopic;

	@RequestMapping(value = "/mq/send/queue", method = { RequestMethod.GET })
	@ResponseBody
	public Object sendMsgToMQ(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = "hello_" + (new Date()).getTime();
//		String queue = "testQueue";
		baseJmsProducerService.sendMessage(testQueue, msg);
		return "OK";
	}

	@RequestMapping(value = "/mq/send/topic", method = { RequestMethod.GET })
	@ResponseBody
	public Object sendMsgTopicToMQ(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String msg = "hello";
		//String queue = "testTopic";
		baseJmsProducerService.sendMessage(testTopic, msg);
		return "OK";
	}



}
