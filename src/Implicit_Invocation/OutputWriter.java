package Implicit_Invocation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputWriter {
	
	public ArrayList<String> ready;
	
	public OutputWriter(ArrayList<String> readyList) {
		this.ready = readyList;
	}
	
	public void write(String fileName) throws IOException {
		
		File file = new File(fileName);
		FileWriter fout = new FileWriter(file);
		BufferedWriter bout = new BufferedWriter(fout);

		if (!file.exists()) {
			file.createNewFile();
		}
		
		for (int i = 0; i < ready.size(); i++) {
			bout.write(ready.get(i)+"\n");
		}
		
		System.out.println("Output generated!");
		
		fout.flush();
		bout.flush();

		fout.close();
		bout.close();

	}
}