package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{

	private Cell[][] textExcel = new Cell[getRows()][getCols()];
	public Spreadsheet() {
		for(int i = 0;i < getRows();i++){
			for(int j = 0;j < getCols();j++){
				textExcel[i][j]=new EmptyCell();
			}
		}
	}
	
	public String processCommand(String command){
		//cell inspection : return value at that cell
		//assignment to string values : return string of entire sheet
		//clear command : return string of entire spreadsheet 
		//clear cell command : return string of spreadsheet as empty cell
		
		String[] arr = command.split(" ");
		
		//to satisfy checkpoint 1
		if(command.equals("")){
			return command;
		}
		if(arr.length==0){
			return command;
		}
		 
		//clears entire sheet
		if(command.equalsIgnoreCase("clear")){ 
			clearSheet();
			return getGridText();
		}
		//cell inspection: returns value at specific cell
		else if(arr.length==2){
			String loc= arr[1];
			SpreadsheetLocation loc1 = new SpreadsheetLocation(loc);
			textExcel[loc1.getRow()][loc1.getCol()]= new EmptyCell();
			return getGridText();
			
		}
		//cell assignment if "" appear, so you split the string 
		else if(command.contains("\"")){
			String[] split = command.split(" = ");
			String loc= split[0];
			String input= split[1];
			SpreadsheetLocation loc1 = new SpreadsheetLocation(loc);
			
			if(split.length >= 3){
				System.out.println(input += " = " + split[2]);
			}
			textExcel[loc1.getRow()][loc1.getCol()] = new TextCell(input.substring(1, input.length()-1));
			return getGridText();
			
		}
		else if(arr.length==1){
			SpreadsheetLocation locspect= new SpreadsheetLocation(command);
			return textExcel[locspect.getRow()][locspect.getCol()].fullCellText();
			
		}	
		
		
		//clear a specific cell
		else if(command.equalsIgnoreCase("clear ")){
			String loca = arr[1];
			SpreadsheetLocation location= new SpreadsheetLocation(loca);
			textExcel[location.getRow()][location.getCol()] = new EmptyCell();
			
			return getGridText();
		}	
		
		//satisfy checpoint 1
		else if(arr.length<=3){
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return textExcel[loc.getRow()][loc.getCol()].fullCellText();
		}
		
		return command;
		
	}
	
	
	//sets everything to emptycell to clear
	public void clearSheet(){
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 12; j++){
				textExcel[i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public int getRows()
	{
		//returns row as 20
		return 20;
	}

	@Override
	public int getCols()
	{
		//returns columns as 12
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return textExcel [loc.getRow()] [loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		//return a string containing entire sheet grid
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
