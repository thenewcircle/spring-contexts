package services;

import domain.Message;

/** 
 * Emit to a destination using a a printer writer interface.
 * @author marakana
 *
 */
public interface Emitter {
		
	public void emit(Message msg);

}
