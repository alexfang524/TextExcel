// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 
package textExcel;


public class SpreadsheetLocation implements Location
{
	private int col;
	private int row;
	private String location;

    public int getRow()
    {
    	// get row at this location
    	row =  Integer.parseInt(location.substring(1));
        return row-1;
    }


    public int getCol()
    {
    	// get the column at this location
    	this.col = location.charAt(0);
        return col-65;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	location = cellName.toUpperCase();
    	
    	
    }

}