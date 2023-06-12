package com.ccavenue.config;

import javax.jms.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class MessagingListnerConfiguration {

	@Autowired
	ConnectionFactory connectionFactory;

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory()
	{
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setConcurrency("1-1");
		return factory;
	}
	
	
	/*
	 * MessagingListnerConfiguration is a configuration class.
	 * Spring container reads configuration class and it creates jmsListenerContainerFactory bean.
	 * jmsListenerContainer will do read message from queue and pass it to the bean which is annotated with @JmsListener.
	 * MessagingListnerConfiguration class annotated with @EnableJms annotation and it is used to enable the detection of @JmsListener annotation in the application.
	 * 
	 * 
	 * 
	 * */

}
