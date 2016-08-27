package pipes_and_filters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputWriter {

	/**
	 * Empty constructor
	 */
	public OutputWriter() {
		
	}
	
	/**
	 * Method to write Strings from output into the specified output file
	 * 
	 * @param fileName
	 * @param output
	 * @throws IOException
	 */
	public void write(String fileName, ArrayList<String> output) throws IOException {
		
		File file = new File(fileName);
		FileWriter fout = new FileWriter(file);
		BufferedWriter bout = new BufferedWriter(fout);

		if (!file.exists()) {
			file.createNewFile();
		}
		
		for (int i = 0; i < output.size(); i++) {
			bout.write(output.get(i)+"\n");
		}
		
		System.out.println("Output generated!");
		
		fout.flush();
		bout.flush();

		fout.close();
		bout.close();

	}

}
