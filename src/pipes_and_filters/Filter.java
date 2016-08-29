package pipes_and_filters;

import java.io.EOFException;

public abstract class Filter {
	
	// List of ignored words
	public static final String ignoreList[] = { "the", "and", "a", "to", "of", "in",
			"i", "is", "that", "it", "on", "you", "this", "for", "but", "with",
			"are", "have", "be", "at", "or", "as", "was", "so", "if", "out",
			"not", "after"};
	
	protected Pipe in, out;
	
	/**
	 * Method to set the input pipe
	 * 
	 * @param in
	 */
	public void setInPipe(Pipe in) {
		this.in = in;
	}
	
	/**
	 * Method to set the output pipe
	 * 
	 * @param out
	 */
	public void setOutPipe(Pipe out) {
		this.out = out;
	}
	
	/**
	 * Method to write into output pipe
	 * 
	 * @param s
	 */
	public void write(String s) {
		if (s == null) {
			out.close();
			return;
		}
		out.write(s);
	}
	
	/**
	 * Method to read from input pipe
	 * 
	 * @return
	 * @throws EOFException
	 */
	public String read() throws EOFException {
		return in.read();
	}
	
	/**
	 * Method to be implemented by the respective filters
	 */
	public abstract void run();
	
}
