package app;

import java.util.Collection;

import services.Emitter;
import domain.Message;

public class MessageEmitter {
	private Emitter emitter;
	private Collection<Message> messages;

	public MessageEmitter() {
	}

	public Emitter getEmitter() {
		return emitter;
	}

	public void setEmitter(Emitter emitter) {
		this.emitter = emitter;
	}

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}
	

	public void emitMessages() {

		// emit all of the messages
		for (Message msg : messages) {
			emitter.emit(msg);

		}
	}
}