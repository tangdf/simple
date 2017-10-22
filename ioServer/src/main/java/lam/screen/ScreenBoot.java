package lam.screen;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScreenBoot {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("application.xml");
		ctx.getBean(ClientFrame.class);
	}
}
