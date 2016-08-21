package KWIC;

import java.io.File;
import java.util.Scanner;

import pipes_and_filters.PipesAndFilters;

public class KWIC {

	private static final String MSG_WELCOME = "Welcome to KWIC!";
	private static final String MSG_ERROR = "Invalid number of arguments provided! Usage: java KWIC.java input.txt ignore.txt output.txt";
	private static final String MSG_FILECHECK = "Checking files..";
	private static final String MSG_FILECHECK_SUCCESS = "Input file: %s1\nIgnore file: %s2\nOutput file: %s3\nFiles check successful!";
	private static final String MSG_FILECHECK_FAIL = "\"%s\" does not exist! Please refer to README.md for further clarifications!";
	private static final String MSG_QNS = "Please choose which design to run the program with\n1. Implicit Invocation\n2. Pipes and Filters";
	private static final String MSG_PROMPT = "Your choice (enter 1 or 2): ";
	private static final String MSG_II = "You have chosen option Implicit Invocation";
	private static final String MSG_PNF = "You have chosen option Pipes and Filters";
	private static final String MSG_INVALID = "You have entered an invalid option, please choose between 1 or 2: ";

	public static void main(String args[]) {
		
		System.out.println(MSG_WELCOME);
		System.out.println(MSG_FILECHECK);
		
		if (args.length != 3) {
			System.out.println(MSG_ERROR);
			System.exit(0);
		}
		
		checkFiles(args[0], args[1], args[2]);
		KWIC active = new KWIC();
		active.choose_Design(args[0], args[1], args[2]);
	}

	private static void checkFiles(String inputFileName, String ignoreFileName, String outputFileName) {
		File input = new File (inputFileName);
		File ignore = new File(ignoreFileName);
		
		if (!input.exists()) {
			System.out.println(String.format(MSG_FILECHECK_FAIL, inputFileName));
			System.exit(0);
		} else if (!ignore.exists()) {
			System.out.println(String.format(MSG_FILECHECK_FAIL, ignoreFileName));
			System.exit(0);
		} else {
			System.out.println(String.format(MSG_FILECHECK_SUCCESS, inputFileName, ignoreFileName, outputFileName));
		}
	}
	
	private void choose_Design(String inputFileName, String ignoreFileName, String outputFileName) {
		System.out.println(MSG_QNS);

		// open scanner to read option
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			int input = scan.nextInt();

			switch (input) {
			case (1):
				System.out.println(MSG_II);
				// ImplicitInvocation design = new ImplicitInvocation();
				// design.launch();
				scan.close();
				break;
			case (2):
				System.out.println(MSG_PNF);
				PipesAndFilters design = new PipesAndFilters(inputFileName, ignoreFileName, outputFileName);
				design.launch();
				scan.close();
				break;
			default:
				System.out.print(MSG_INVALID);
			}
		}

	}
}
