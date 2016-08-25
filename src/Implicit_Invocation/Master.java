package Implicit_Invocation;

import java.io.IOException;
import java.util.ArrayList;

public class Master{
	
	//contains the names of the input/ ignore and output files
	String inputFile;
	String ignoreFile;
	String outputFile;
	
	public Master(String inputFileName, String ignoreFileName, String outputFileName) {
		// TODO Auto-generated constructor stub
		this.inputFile = inputFileName;
		this.ignoreFile = ignoreFileName;
		this.outputFile = outputFileName;
	}

	public void launch(){
		InputReader input = new InputReader();
		OutputWriter output = new OutputWriter();
		
		try{
			//reads input and ignore files and store them in arraylist
			input.readIgnore(ignoreFile);
			input.readText(inputFile);
			input.sortedReady = input.produceOutput();

			
			output.write(outputFile, input.sortedReady);

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
