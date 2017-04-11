// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 
package textExcel;

public class PercentCell implements Cell {

private String string;
	
	public PercentCell (String text){
		this.string = text;
	}
	
	public String abbreviatedCellText() {
		String abrv = "";
		if (string.indexOf(".")>0){ 
			// checks to see if there is a decimal in string
			abrv = string.substring(0, string.indexOf(".")); 
		}
		abrv += "%         "; 
		return abrv.substring(0,10);
	}

	public String fullCellText() {
		return GetValue(string)+"";
	}
	
	public double GetValue (String text){
		return Double.parseDouble(text.substring(0, text.length()-1))/100; 
		
	}

}