package services;

import java.io.PrintStream;

import domain.Message;

public class PrintStreamEmitter implements Emitter {
	
	private PrintStream printStream = java.lang.System.out;
	
	public PrintStream getPrintStream() {
		return printStream;
	}

	public void setPrintStream(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void emit(Message msg) {
		printStream.format("Hello %s:\n",msg.getReceiver().getName());
		printStream.format("\t%s\n", msg.getBody());
		printStream.format("Sincerely,\n-%s\n", msg.getSender().getName());
	}

}
