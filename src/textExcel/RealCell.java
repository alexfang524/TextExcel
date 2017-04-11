// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 
package textExcel;

public class RealCell implements Cell {

	private String string;
	 
	public RealCell (String text){
		this.string = text;
	}
	public String abbreviatedCellText() {
		return "          ";//10 spaces
	}

	public String fullCellText() {
		return string;
	}
	
	public double getDoubleValue(String words){
		return Double.parseDouble(words);
	}

}