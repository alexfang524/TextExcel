// Alex Fang
// APCS 1st
// 11 April 2017 
// TextExcel 

package textExcel;

public class ValueCell extends RealCell{
	
	private String value;
	
	//set num to value and value into the superclass of RealCell
	public ValueCell(String num){
		this.value = num;
		setRealCell(num);

	}
	
	public double getDoubleValue(){
		return Double.parseDouble(getRealCell());
	}

}