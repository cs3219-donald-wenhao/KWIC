package pipes_and_filters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputWriter {

	public OutputWriter() {
		
	}
	
	public void write(String fileName) throws IOException {
		
		File file = new File(fileName);
		FileWriter fout = new FileWriter(file);
		BufferedWriter bout = new BufferedWriter(fout);

		if (!file.exists()) {
			file.createNewFile();
		}
		
		ArrayList<String> output = new ArrayList<String>();
		output.add("loves");
		output.add("lovesdf");
		output.add("gasfgsdfhi");
		
		for (int i = 0; i < output.size(); i++) {
			bout.write(output.get(i)+"\n");
		}
		
		fout.flush();
		bout.flush();

		fout.close();
		bout.close();

	}

}
