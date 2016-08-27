package pipes_and_filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Pipe {
	
	// Initialization of name strings
	String inputFileName;
	String ignoreFileName;
	String outputFileName;
	
	/**
	 * Constructor
	 * 
	 * @param inputFileName
	 * @param ignoreFileName
	 * @param outputFileName
	 */
	public Pipe(String inputFileName, String ignoreFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.ignoreFileName = ignoreFileName;
		this.outputFileName = outputFileName;
	}
	
	
	/**
	 * Method to carry out the KWIC. 
	 */
	public void launch() {
		
		// Initiation of the various Filters used
		InputReader reader = new InputReader();
		CircularShift shifter = new CircularShift();
		Alphabetizer alphabetizer = new Alphabetizer();
		OutputWriter writer = new OutputWriter();
		
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> ignore = new ArrayList<String>();
		
		try {
			// Reading input
			input = reader.read(inputFileName);
			ignore = reader.read(ignoreFileName);
			
			// Alphabetize ignored words
			for (int i = 0; i < input.size(); i++) {
				input.set(i, alphabetizer.alphabetize(ignore, input.get(i)));
			}
			
			// Shifting the words
			ArrayList<String> shiftedLines =  shifter.shift(ignore, input);
			
			// Sorting the lines
			Collections.sort(shiftedLines, new StringCompare());
			
			// Writing to output
			writer.write(outputFileName, shiftedLines);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	/**
	 * Private comparator class to sort the lines, regardless of the case
	 */
	private class StringCompare  implements Comparator<String> {
		
		public int compare(String obj1, String obj2) {
			
			obj1 = obj1.toUpperCase();
			obj2 = obj2.toUpperCase();
			
		    if (obj1 == obj2) {
		        return 0;
		    }
		    
		    if (obj1 == null) {
		        return -1;
		    }
		    
		    if (obj2 == null) {
		        return 1;
		    }
		    
		    return obj1.compareTo(obj2);
		    
		}
	}
}
