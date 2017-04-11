// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 
package textExcel;
import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.Scanner;


public class Spreadsheet implements Grid
{
	
	private Cell [] [] textExcel;
	public Spreadsheet () {
		textExcel = new Cell [12] [20];
		for (int i = 0; i < 12; i++){
			for (int j = 0; j< 20; j++){
				textExcel [i][j] = new EmptyCell();
			}
		}
		
	}
	
	
	public String processCommand(String command) {
		if (command.length()==0){
			return "";
		}	
		String [] input = command.split(" ",3);
		if (input[0].toLowerCase().equals("clear")){
			// clear cell or spreadsheet
			clearCellSpreadsheet(input);
			return getGridText();
		}		
		else if (input.length > 2){
			//assign value to either a formula, text, percent or value
			inspectCell(input);
			return getGridText();
		}		
		else {
			//cell inspection:returns value at that cell
			SpreadsheetLocation place = new SpreadsheetLocation(input[0].toUpperCase());
			return getCell(place).fullCellText();
		}
	}
	
	public void clearCellSpreadsheet (String [] input){
		//setting a specific element into a emtpy cell
		if (input.length > 1){
			SpreadsheetLocation place = new SpreadsheetLocation(input[1].toUpperCase());
			textExcel[place.getCol()] [place.getRow()] = new EmptyCell ();
		}
		else {
			//makes entire spreadsheet equal to emtpy cell, so bascially clearing entire spreadsheet
			for (int j = 0; j < 20; j++ ){
				for (int k = 0; k < 12; k++){
					textExcel[k][j] = new EmptyCell();
				}			
			}
		}

	}
	
	public void inspectCell (String [] input){
		String userInput = input[2]; 
		SpreadsheetLocation mysteryInput = new SpreadsheetLocation(input[0].toUpperCase());
		if (userInput.charAt(0) == 34){ 
			//if a text cell, replaces the string in the quotations with a textCell
			String words = input[2].substring(1, (input[2].length()-1));
			textExcel[mysteryInput.getCol()] [mysteryInput.getRow()] = new TextCell (words);
		}
		else if (userInput.substring(userInput.length()-1).equals("%")){ 
			//if a Percent cell, replaces the string in the quotations with a percent cell
			textExcel[mysteryInput.getCol()] [mysteryInput.getRow()] = new PercentCell (userInput);	
		}
		else if (userInput.substring(userInput.length()-1).equals(")")){ 
			//if a formula cell, replaces the string in the quotations with a formula cell
			textExcel[mysteryInput.getCol()] [mysteryInput.getRow()] = new FormulaCell (userInput);	
		}
		else { 
			//if a value cell, replaces the string in the quotations with a value cell
			textExcel[mysteryInput.getCol()] [mysteryInput.getRow()] = new ValueCell (userInput);	
		}
}
		

	public int getRows()
	{
		return 20;
	}


	public int getCols()
	{
		return 12;
	}

	public Cell getCell(Location loc)
	{
		return textExcel[loc.getCol()] [loc.getRow()];
		
	}

	public String getGridText()
	{		
		String topLine = "   ";
		for (char i = 'A'; i <= 'L'; i++){
			topLine += "|" + i + "         ";	
		}
		topLine += "|";
		String full = "\n";		
		for (int j = 0; j < 20; j++ ){
			full += ((j+1) + "   ").substring(0, 3);
			full += "|";
			for (int k = 0; k < 12; k++){
				full += textExcel[k][j].abbreviatedCellText() + "|";
			}			
			full += "\n";
		}
		return topLine+full;
	}
	
	
}