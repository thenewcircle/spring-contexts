package app;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
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

	/**
	 * Return an configured emitter object. The Equivalent XML configuration
	 * follows.
	 * 
	 * <code>
	 *   <bean id="emitter" class="services.PrintStreamEmitter" scope="prototype" />
	 * </code>
	 * 
	 * @return
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Emitter emitter() {
		return new PrintStreamEmitter();
	}

	/**
	 * Return a list of messages ready to emit. The Equivalent XML configuration
	 * follows.
	 * 
	 * <code>
	<bean id="tim" class="domain.Person">
		<property name="name" value="Tim" />
	</bean>

	<bean id="alice" class="domain.Person">
		<property name="name" value="Alice" />
	</bean>

	<bean id="bob" class="domain.Person">
		<property name="name" value="Bob" />
	</bean>

	<bean id="debbie" class="domain.Person">
		<property name="name" value="Debbie" />
	</bean>
	
	<bean id="messageBody" class="java.lang.String" value="Have a nice day!"/>

	<bean id="message" class="domain.Message">
		<property name="receiver" ref="alice" />
		<property name="sender" ref="tim" />
		<property name="body" ref="messageBody"/>
	</bean>

	<bean id="messages" class="java.util.ArrayList">
		<constructor-arg>
			<list>
				<ref bean="message" />
				<bean class="domain.Message">
					<property name="receiver" ref="debbie" />
					<property name="sender" ref="alice" />
					<property name="body" ref="messageBody" />
				</bean>
				<bean class="domain.Message">
					<property name="receiver" ref="bob" />
					<property name="sender" ref="debbie" />
					<property name="body" ref="messageBody"/>
				</bean>

			</list>
		</constructor-arg>
	</bean>
	 * </code>
	 * 
	 * @return
	 */
	@Bean
	// @Scope("singleton")
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

	/**
	 * Return a fully populated MessageEmitter object. The equivalent XML follows.
	 * <code>
	 * 	<bean id="messageEmitter" class="app.MessageEmitter"
		  p:emitter-ref="emitter" p:messages-ref="messages" />
	 * </code>
	 * @return
	 */
	@Bean
	public MessageEmitter messageEmitter() {
		MessageEmitter em = new MessageEmitter();
		em.setEmitter(emitter());
		em.setMessages(messages());
		return em;
	}

}
