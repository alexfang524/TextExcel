// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 
package textExcel;

public class EmptyCell implements Cell {
	public EmptyCell() { 
		// there is nothing in here because it is an empty cell!
		
	}
	
	public String abbreviatedCellText() {
		//10 spaces
		return "          "; 
	}

	public String fullCellText() {
		return "";
	}
}