package pipes_and_filters;

import java.io.EOFException;
import java.util.LinkedList;

public class Pipe {

	public LinkedList<String> buffer;
	private boolean closed;
	
	/**
	 * Constructor
	 */
	public Pipe() {
		buffer = new LinkedList<String>();
		closed = false;
	}
	
	/**
	 * Method to write into pipe
	 * 
	 * @param data
	 */
	public void write(String data) {
		if (closed) {
			return;
		}
		buffer.add(data);
	}
	
	/**
	 * Method to read from pipe
	 * 
	 * @return
	 * @throws EOFException
	 */
	public String read() throws EOFException {
		while(true) {
			if (buffer.isEmpty()) {
				if (closed) {
					throw new EOFException();
				}
			} else {
				return buffer.pop();
			}
		}
	}
	
	/**
	 * Method to close pipe
	 */
	public void close() {
		closed = true;
	}
	
}
