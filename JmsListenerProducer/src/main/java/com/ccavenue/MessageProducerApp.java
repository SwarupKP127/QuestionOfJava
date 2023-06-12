package com.ccavenue;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.support.AbstractApplicationContext;

import com.ccavenue.config.AppConfig;
import com.ccavenue.model.Product;
import com.ccavenue.producer.MessageSender;

public class MessageProducerApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MessageSender messageSender = context.getBean(MessageSender.class);

		Product product = new Product();
		product.setProductId(100);
		product.setName("Laptop");
		product.setQuantity(10);

		messageSender.sendMessage(product);
		System.out.println("Message has been sent successfully to Queue");

		((AbstractApplicationContext) context).close();
	}

}
