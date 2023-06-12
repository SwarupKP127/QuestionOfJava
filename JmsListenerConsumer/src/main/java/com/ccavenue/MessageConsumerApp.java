package com.ccavenue;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import com.ccavenue.config.AppConfig;

public class MessageConsumerApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		try
		{
			Thread.sleep(6000000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		((AbstractApplicationContext) context).close();
	}

}
