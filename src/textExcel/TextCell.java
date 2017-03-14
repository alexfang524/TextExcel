package textExcel;

public class TextCell implements Cell {
	
	private String stringWord;
	//a TextCell stores string values
	public TextCell(String textCell){
		this.stringWord = textCell;
	}

	@Override
	public String abbreviatedCellText() {

		int strlength = stringWord.length();
		String abbreviated;
		if(strlength < 10){
			abbreviated = stringWord.substring(0);
			for(int i = 0; i < 10-strlength;i++){
				abbreviated += " ";
			}
		}else{
			abbreviated = stringWord.substring(0, 10);
		}
		return abbreviated;
	}

	@Override
	public String fullCellText() {
		return  "\"" + stringWord + "\"";
	}

}
