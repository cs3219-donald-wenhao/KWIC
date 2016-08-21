package pipes_and_filters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputReader {
	
	public InputReader() {

	}
	
	public ArrayList<String> read(String fileName) throws IOException {
		
		FileReader fin = new FileReader(fileName);
		BufferedReader bin = new BufferedReader(fin);
		
		ArrayList<String> input = new ArrayList<String>();
		String line;
		while( (line = bin.readLine()) != null) {
			if (line.length() == 0) {
				// reach a new line => end of input
				break;
			} else {
				input.add(line);
			}
		}
		
		fin.close();
		bin.close();
		
		return input;
		
	}
	
}
