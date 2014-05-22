package app;

import java.util.ArrayList;
import java.util.List;

import services.PrintStreamEmitter;
import domain.Message;
import domain.Person;

public class DIMessageEmitter {
	
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
	
	private static List<Message> createMessages() {
		List<Message> messages = new ArrayList<Message>();

		Person bob = createPerson("Bob");
		Person debbie = createPerson("Debbie");
		Person alice = createPerson("Alice");
		Person tim  = createPerson("Tim");
		
		messages.add(createMessage(bob,alice));
		messages.add(createMessage(alice,debbie));
		messages.add(createMessage(debbie,tim));
		messages.add(createMessage(tim,bob));
		
		return messages;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Executing DIMessageEmtter\n");
		MessageEmitter me = new MessageEmitter();
		me.setEmitter(new PrintStreamEmitter());
		me.setMessages(createMessages());
		me.emitMessages();
	}

}
