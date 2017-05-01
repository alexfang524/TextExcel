// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 
package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextExcel
{

	public static void main(String[] args)
	{

		Spreadsheet excel = new Spreadsheet();	
		
		Scanner input = new Scanner(System.in);
		String command = "";
		while(command.equals("quit") != true){
			System.out.println("Hi there, Enter Command: ");
			command = input.nextLine();
			System.out.println(excel.processCommand(command));
		}
	}
		
}