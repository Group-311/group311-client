package example;

public class Color {
	
	private int colorNum;
	private String colorName;
	
	Color(String _colorName, int _colorNum){
		this.colorName = _colorName;
		this.colorNum = _colorNum;
	}
	
	public int getColorNum() {
		return colorNum;
	}

	public String getColorName() {
		return colorName;
	}


}
