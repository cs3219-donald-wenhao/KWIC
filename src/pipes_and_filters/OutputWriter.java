package pipes_and_filters;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter extends Filter {

	private File file;
	private FileWriter fout;
	private BufferedWriter bout;
	
	
	/**
	 * Constructor
	 */
	public OutputWriter(String fileName) {
		try {
			file = new File(fileName);
			fout = new FileWriter(file);
			bout = new BufferedWriter(fout);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to run this filter. Reads from pipe and writes to output file.
	 */
	public void run() {
		
		while (true) {

			try {
				String input = read();
				bout.write(input + "\n");
			} catch (EOFException e) {
				try {
					fout.flush();
					bout.flush();
					
					fout.close();
					bout.close();
					break;
				} catch (IOException err) {
					err.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Output generated as \"" + file.getName() + "\" in the same location as the application");
		
		
	}

}
