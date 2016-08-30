package pipes_and_filters;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataSource extends Filter{
	
	private InputStreamReader fin;
	private BufferedReader bin;
	
	/**
	 * Constructor
	 */
	public DataSource(String fileName) throws FileNotFoundException {
		fin = new FileReader(fileName);
		bin = new BufferedReader(fin);
	}
	
	/**
	 * Method to run this filter. Reads from file and write to pipe
	 */
	public void run() {
		String line;
		try {
			while(true) {
				line = bin.readLine();
				if (line == null) {
					write(null);

					break;
				} else {
					write(line);	
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
