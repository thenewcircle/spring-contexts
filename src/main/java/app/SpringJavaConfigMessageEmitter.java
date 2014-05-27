package app;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import services.Emitter;
import domain.Message;

public class SpringJavaConfigMessageEmitter {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Logger logger = LoggerFactory.getLogger(SpringJavaConfigMessageEmitter.class);
		

		logger.info("Executing SpringMessageEmitter\n");

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);) {

			Emitter e = (Emitter) context.getBean("emitter");
			logger.info("Emitter instance 1 = {}", e);

			/*
			Emitter e2 = (Emitter) context.getBean("emitter");
			logger.info("Emitter instance 2 = {}", e);
			*/

			logger.info("MesasgeEmitter local");
			MessageEmitter me = new MessageEmitter();
			me.setEmitter(e);
			me.setMessages((Collection<Message>) context.getBean("messages"));
			me.emitMessages();
			
			logger.info("MesasgeEmitter by type");
			me = context.getBean(MessageEmitter.class);
			
		} catch (Exception e) {
			System.err.println("Could not access applicaton context beans.xml");
			e.printStackTrace();
		}

	}

}
