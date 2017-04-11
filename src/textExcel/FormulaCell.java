// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 
package textExcel;

public class FormulaCell implements Cell {

	private String string;
	
	public FormulaCell(String text) {
		this.string = text;		
	}
	public String abbreviatedCellText() {
		String abv = string;
		abv += "          ";
		return abv.substring(0,10);
	}
	public String fullCellText() {
		return string;
	}
	public double GetValue (String text){
		return Double.parseDouble(text);
	}
}