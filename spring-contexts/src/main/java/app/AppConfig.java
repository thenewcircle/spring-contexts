package app;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import services.Emitter;
import services.PrintStreamEmitter;
import domain.Message;
import domain.Person;

@Configuration
public class AppConfig {

	private static Message createMessage(Person sender, Person receiver) {
		Message msg = new Message();

		msg.setBody("Have a nice day!");
		msg.setSender(sender);
		msg.setReceiver(receiver);

		return msg;
	}

	private static Person createPerson(String name) {
		Person person = new Person();
		person.setName(name);
		return person;

	}

	@Bean
	@Scope("singleton")
	public Emitter emitter() {
		return new PrintStreamEmitter();
	}

	@Bean
	@Scope("singleton")
	public Collection<Message> messages() {
		Collection<Message> messages = new ArrayList<Message>();

		Person bob = createPerson("Bob");
		Person debbie = createPerson("Debbie");
		Person alice = createPerson("Alice");
		Person tim = createPerson("Tim");

		messages.add(createMessage(bob, alice));
		messages.add(createMessage(alice, debbie));
		messages.add(createMessage(debbie, tim));
		messages.add(createMessage(tim, bob));

		return messages;
	}

}
