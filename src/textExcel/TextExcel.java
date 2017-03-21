package textExcel;
import java.util.*;
import java.io.*;

import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		//ask user to continue typing commands until user types quit
		Spreadsheet textexcell = new Spreadsheet();
		Scanner scanner = new Scanner (System.in);
	    String input = scanner.nextLine();
	    while (input != "quit") {
	    	textexcell.processCommand(input);
	    	input = scanner.nextLine();
	    }
	    
	}
}
