package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{ 
	
	private int row;
	private int column;
	
  @Override
  public int getRow()
  {
  	return this.row;
  }

  @Override
  public int getCol()
  {
  	return this.column;
  }
  public SpreadsheetLocation(String cellName){
	//returns the string as an integer for rows
  	row = Integer.parseInt(cellName.substring(1)) - 1;
  	////subtract 65 b/c letter A on ascii chart is 65
  	column = Character.toUpperCase(cellName.charAt(0)) - 65;
  }
  

}

