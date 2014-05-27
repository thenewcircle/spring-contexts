package app;

import java.util.Collection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import services.Emitter;
import domain.Message;

public class SpringXmlConfigMessageEmitter {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		System.out.println("Executing SpringMessageEmitter\n");

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml")) {

			MessageEmitter me = new MessageEmitter();

			Emitter e = (Emitter) context.getBean("emitter");
			System.out.println("Emitter instance 1 = " + e);

			Emitter e2 = (Emitter) context.getBean("emitter");
			System.out.println("Emitter instance 2 = " + e2);

			me.setEmitter(e);

			me.setMessages((Collection<Message>) context.getBean("messages"));
			me.emitMessages();
		} catch (Exception e) {
			System.err.println("Could not access applicaton context beans.xml");
			e.printStackTrace();
		}

	}

}
