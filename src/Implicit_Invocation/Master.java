package Implicit_Invocation;

import java.io.IOException;

public class Master{
	
	//contains the names of the input/ ignore and output files
	String inputFile;
	String ignoreFile;
	String outputFile;
	
	public void launch(){
		InputReader input = new InputReader();
		
		try{
			input.read("a.pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
