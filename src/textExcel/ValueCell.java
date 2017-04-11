// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 

package textExcel;

public class ValueCell extends RealCell implements Cell{

	private String string;
	
	public ValueCell (String text){ 
		super (text);
		this.string = text;
	}	
	public String abbreviatedCellText() {
		String abv = getValue(string)+"";
		abv += "          ";//10 spaces
		return abv.substring(0,10);	
	}

	public String fullCellText() {
		//changing integer to double
		if (string.indexOf(".")<0){ 
			return string;
		}
		return getValue(string)+"";
	}	
	public double getValue(String text){
		return super.getDoubleValue(text);
	}

}