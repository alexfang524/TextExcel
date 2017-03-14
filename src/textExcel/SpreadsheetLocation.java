package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	
	private String location;
	private int row;
	private int col;
 
	public int getRow(){
		//returns the string as an integer for rows
		this.row = Integer.parseInt(location.substring(1));
        return this.row - 1;
    }

    @Override
    public int getCol(){
    	//return the index of the letter
    	this.col = location.charAt(0);
    	//subtract 65 b/c letter A on ascii chart is 65
    	return this.col - 65;
    }
    
    public SpreadsheetLocation(String cellName){
    	this.location = cellName;
    }
    
}

