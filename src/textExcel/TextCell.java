package textExcel;

public class TextCell implements Cell {
	
	private String stringWord;
	//a TextCell stores string values
	public TextCell(String textCell){
		this.stringWord = textCell;
	}

	@Override
	public String abbreviatedCellText() {
		//makes new String so this method won't affect FullCellText when you take out the quotes
				String abbreviatedWord = "";
				
				//gets rid of quotes
				if(stringWord.contains("\"") == true){
					abbreviatedWord = stringWord.substring(1, stringWord.length() - 1);
				}
				//Reduces string to first 10
				if(abbreviatedWord.length() > 10){
					abbreviatedWord = abbreviatedWord.substring(0, 10);
					return abbreviatedWord;
				}else{
					//fills in the spaces so total length will be 10
					while(abbreviatedWord.length() != 10){
						abbreviatedWord += " ";

					}
					return abbreviatedWord;
				}
	}


	@Override
	//returns full string
		public String fullCellText() {
			return stringWord;
		}
		public void setText(String strcontents){
			this.stringWord = strcontents;
		}


}
