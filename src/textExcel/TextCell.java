package textExcel;

public class TextCell implements Cell {
	
	private String stringWord;
	private int length;
	//textCell stores string and its length
	public TextCell(String textCell){
		this.stringWord = textCell;
		length = textCell.length();
	}
	

	@Override
	public String abbreviatedCellText() {
		//makes new String so this method won't affect fullCellText 
		return (stringWord + "          ").substring(0, 10);
	}


	@Override
	public String fullCellText() {
		//returns full string
		return ("\"" + stringWord.substring(0, length) + "\"");
	}
		

}


