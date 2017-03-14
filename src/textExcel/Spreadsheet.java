package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private String command;
	private Cell [] []textExcel;
	
	//constructing the 2-d Array
	public Spreadsheet(){
	Cell[][]textExcel = new Cell[getRows()][getCols()];
	for(int i = 0; i < getRows(); i++){
		for(int j = 0; j < getCols(); j++){
			textExcel[i][j] = new EmptyCell();
		}
		
	}
	}
	
	
	@Override
	public String processCommand(String command)
	{
		//cell inspection : return value at that cell
		//assignment to string values : return string of entire sheet
		//clear command : return string of entire spreadsheet
		//clear cell command : return string of entire spreadsheet
		
	}

	@Override
	public int getRows()
	{

		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return textExcel [loc.getCol()] [loc.getRow()];
	}

	@Override
	public String getGridText()
	{
		//return a string containing entire sheet grid
		
	}
	
	public void clearCell (String [] input){
		
	}
	
	public void setCell (String [] input){
		
	}

}
