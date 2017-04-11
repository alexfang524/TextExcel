// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 
package textExcel;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

import textExcel.TestsALL.TestLocation;



public class TextExcel
{

	public static void main(String[] args)
	{

		//ask user to continue typing commands until user types quit	
			Spreadsheet textExcel = new Spreadsheet ();
			System.out.println("Enter your input: ");
		
		    Scanner scanner = new Scanner (System.in);
		    String input = scanner.nextLine();
		   
		    while (!input.equalsIgnoreCase("quit")) {
		    	System.out.println(textExcel.processCommand(input)); 
		    	input = scanner.nextLine();
		    }
	    
	}
}