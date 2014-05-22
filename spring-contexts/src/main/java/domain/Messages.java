package domain;

import java.util.List;

/** 
 * Use this class to represent a list of messages as a bean property
 * @author Gordon
 *
 */
public class Messages {
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	private List<Message> messages;

}
