// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 
package textExcel;

public class TextCell implements Cell {
	
	String string; 
	
	public TextCell (String text) {
		this.string = text;
	}

	@Override
	public String abbreviatedCellText() {
		String abv = string;
		abv += "          ";
		return abv.substring(0,10);
	}

	@Override
	public String fullCellText() {
		return "\"" + string + "\"";
	}


}