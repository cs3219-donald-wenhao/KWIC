package main;

import java.io.File;
import java.util.Scanner;

import Implicit_Invocation.Master;
import pipes_and_filters.Pipe;

public class KWIC {
	
	// Initialization of file name strings
	private static String inputFileName, ignoreFileName, outputFileName;
	
	// Message Strings
	private static final String MSG_WELCOME = "Welcome to KWIC!";
	private static final String MSG_INPUT_PROMPT = "Please specify input file: ";
	private static final String MSG_IGNORE_PROMPT = "Please specify ignore file: ";
	private static final String MSG_OUTPUT_PROMPT = "Please specify output file: ";
	private static final String MSG_FILECHECK = "\nChecking files..";
	private static final String MSG_FILECHECK_SUCCESS = "Files check successful!\n";
	private static final String MSG_FILECHECK_FAIL = "\"%s\" does not exist! Please refer to README.md for further clarifications!";
	private static final String MSG_QNS = "Please choose which design to run the program with\n1. Implicit Invocation\n2. Pipes and Filters";
	private static final String MSG_PROMPT = "Your choice (enter 1 or 2): ";
	private static final String MSG_II = "You have chosen option Implicit Invocation";
	private static final String MSG_PNF = "You have chosen option Pipes and Filters";
	private static final String MSG_INVALID = "You have entered an invalid option, please choose between 1 and 2: ";

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		KWIC active = new KWIC();
		active.init();
	}
	
	/**
	 * Initializes the KWIC and carry out the main work
	 */
	private void init() {
		
		System.out.println(MSG_WELCOME);
		
		this.promptFiles();
		
		System.out.println(MSG_FILECHECK);
		
		this.checkFiles(inputFileName, ignoreFileName, outputFileName);
		
		this.choose_Design(inputFileName, ignoreFileName, outputFileName);
	}
	
	/**
	 * Method to prompt for file names
	 */
	private void promptFiles() {
		
		// open scanner to read option
		Scanner scan = new Scanner(System.in);
		
		System.out.print(MSG_INPUT_PROMPT);
		inputFileName = scan.nextLine();
		
		System.out.print(MSG_IGNORE_PROMPT);
		ignoreFileName = scan.nextLine();
		
		System.out.print(MSG_OUTPUT_PROMPT);
		outputFileName = scan.nextLine();
		
	}

	/**
	 * Method to check whether given input files exist
	 * 
	 * @param inputFileName
	 * @param ignoreFileName
	 * @param outputFileName
	 */
	private void checkFiles(String inputFileName, String ignoreFileName, String outputFileName) {
		
		File input = new File(inputFileName);
		File ignore = new File(ignoreFileName);

		if (!input.exists()) {
			System.out.println(String.format(MSG_FILECHECK_FAIL, inputFileName));
			System.exit(0);
		} else if (!ignore.exists()) {
			System.out.println(String.format(MSG_FILECHECK_FAIL, ignoreFileName));
			System.exit(0);
		} else {
			System.out.println(MSG_FILECHECK_SUCCESS);
		}
	}

	/**
	 * Method to carry out the choosing of architectural design
	 * 
	 * @param inputFileName
	 * @param ignoreFileName
	 * @param outputFileName
	 */
	private void choose_Design(String inputFileName, String ignoreFileName, String outputFileName) {
		System.out.println(MSG_QNS);

		// open scanner to read option
		Scanner scan = new Scanner(System.in);

		System.out.print(MSG_PROMPT);

		while (true) {

			String input = scan.nextLine();

			switch (input) {

			case ("1"):
				System.out.println(MSG_II);
				Master impInvDesign = new Master(inputFileName, ignoreFileName, outputFileName);
				impInvDesign.launch();
				scan.close();
				System.exit(0);

			case ("2"):
				System.out.println(MSG_PNF);
				Pipe pipesDesign = new Pipe(inputFileName, ignoreFileName, outputFileName);
				pipesDesign.launch();
				scan.close();
				System.exit(0);

			default:
				System.out.print(MSG_INVALID);
			}
		}

	}
}
