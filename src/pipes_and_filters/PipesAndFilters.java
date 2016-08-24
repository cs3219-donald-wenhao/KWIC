package pipes_and_filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PipesAndFilters {
	
	String inputFileName;
	String ignoreFileName;
	String outputFileName;
	
	public PipesAndFilters(String inputFileName, String ignoreFileName, String outputFileName) {
		this.inputFileName = inputFileName;
		this.ignoreFileName = ignoreFileName;
		this.outputFileName = outputFileName;
	}
	
	public void launch() {
		
		// Initiation of the various Filters used
		InputReader reader = new InputReader();
		CircularShift shifter = new CircularShift();
		Alphabetizer alphabetizer = new Alphabetizer();
		OutputWriter writer = new OutputWriter();
		
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> ignore = new ArrayList<String>();
		
		try {
			input = reader.read(inputFileName);
			ignore = reader.read(ignoreFileName);
			
			for (int i = 0; i < input.size(); i++) {
				input.set(i, alphabetizer.alphabetize(ignore, input.get(i)));
			}
			
			ArrayList<String> shiftedLines =  shifter.shift(ignore, input);
			
			Collections.sort(shiftedLines, new StringCompare());
			
			writer.write(outputFileName, shiftedLines);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public class StringCompare  implements Comparator<String> {
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
