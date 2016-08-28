package Implicit_Invocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetize {
	Alphabetize(){
		
	}
	
	//takes in the ArrayList to be sorted as parameter
	ArrayList<String> runAlpha(ArrayList<String> sorting){
		Collections.sort(sorting, new StringCompare());
		return sorting;
	}
	
	
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
