package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int rows = 20;
	private int columns = 12;
	private Cell[][] textExcel = new Cell[rows][columns];
	public Spreadsheet() {
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				textExcel[i][j]=new EmptyCell();
			}
		}
	}
	
	
	
	public String processCommand(String command){
		//cell inspection : return value at that cell
		//assignment to string values : return string of entire sheet
		//clear command : return string of entire spreadsheet
		//clear cell command : return string of entire spreadsheet
		String[] splitCommand = command.split(" ");
		splitCommand[0] = splitCommand[0].toUpperCase();
		//If length is 3 or less, that means it must want to inspectCell
		if(command.length()==0){
			return "";
		}else if(splitCommand.length >= 3){
			String userInput = splitCommand[2];
			int counter = 3;
				while(counter < splitCommand.length){
					//adds the space that was taken out and the next part of the value
					userInput += " " + splitCommand[counter];
					counter++;
				}
			String cell = splitCommand[0];
			cellAssignment(userInput, cell);
			return getGridText();
			//if its less than 3, it has to be cell inspection
		}else if(command.length() < 3){
			//make if statement to test the type of splitCommand[2]
			return cellInspection(splitCommand[0]);
			//check if the user input has clear, has been changed to uppercase
		}else if (splitCommand[0].contains("CLEAR")){
			//if theres no spaces, then must be just clear so clear entire cell
			if(splitCommand.length == 1){
				 clearEntireCell();
				 return getGridText();
				 //if there is space, then must be clearing just one spot
			} else{
				//in case the cell isnt uppercased
				clearParticularCell(splitCommand[1].toUpperCase());
				return getGridText();
			}
		} 
		return "";
		
	}
	
	public String cellInspection(String cell){
		//makes new spreadsheetlocation object to get the rows and col
		SpreadsheetLocation a = new SpreadsheetLocation(cell);
		String result = textExcel[a.getRow()][a.getCol()].fullCellText();
		return result;
	}
	//assigns cell using Textcell constructor
	public void cellAssignment(String input, String cell){
		SpreadsheetLocation b = new SpreadsheetLocation(cell);
		textExcel[b.getRow()][b.getCol()] = new TextCell(input);
	}
	//sets everything to emptycell to clear
	public void clearEntireCell(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				textExcel[i][j] = new EmptyCell();
			}
		}
	}
	public void clearParticularCell(String cell){
		SpreadsheetLocation userInput = new SpreadsheetLocation(cell);
		textExcel[userInput.getRow()][userInput.getCol()] = new EmptyCell();
	}

	
	
	
	
	@Override
	public int getRows()
	{

		return rows;
	}

	@Override
	public int getCols()
	{
		return columns;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return textExcel [loc.getRow()] [loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		//return a string containing entire sheet grid4
		String topLetter = "   |";
		for(char i = 'A'; i<='L'; i++){
			topLetter += i + "         |";
		}
		String numbers = "\n";
		for(int i = 0;i < 20;i++){
			if(i<9){
				numbers += (i+1);
				numbers += "  |";
				for(int j = 0; j<12;j++){
					numbers += textExcel[i][j].abbreviatedCellText() + "|";
				}
				numbers +="\n";
			}else{
				numbers += (i+1);
				numbers += " |";
				for(int j = 0; j<12;j++){
					numbers += textExcel[i][j].abbreviatedCellText() + "|";
				}
				numbers +="\n";
			}
		}
		return topLetter + numbers;

	}
		

}
