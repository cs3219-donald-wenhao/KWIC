import java.util.Scanner;

public class KWIC {
	public static void main(String args[]){
		KWIC active = new KWIC();
		active.choose_Design();
	}
	
	private void choose_Design(){
		System.out.println("Key in '1' for Implicit Invocation/ '2' for Pipes and Filters");
		
		//open scanner to read option
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		
		switch (input){
			case(1):
				ImplicitInvocation design = new ImplicitInvocation();
				design.launch();
				break;
			case(2):
				System.out.println("You have chosen option Pipes and Filters");
				//launch solution 2 here
				break;
			default: System.out.print("You have chosen an invalid option, Goodbye");
					 System.exit(0);
					 break;
		}
		scan.close();
	}
}
