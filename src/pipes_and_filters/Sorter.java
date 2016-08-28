package pipes_and_filters;

import java.io.EOFException;
import java.util.concurrent.ConcurrentSkipListSet;

public class Sorter extends Filter {
	
	private ConcurrentSkipListSet<String> buffer;
	
	/**
	 * Constructor
	 */
	public Sorter() {
		buffer = new ConcurrentSkipListSet<String>(String.CASE_INSENSITIVE_ORDER);
	}
	
	/**
	 * Method to run this filter. Reads from pipe, sort the input, and write to the next pipe.
	 */
	public void run() {
		while (true) {
			try {
				String input = read();
				buffer.add(input);
			} catch (EOFException e) {
				break;
			}
		}
		
		while(!buffer.isEmpty()) {
			write(buffer.pollFirst());
		}
		
		write(null);
	}
	
}
