

import org.newdawn.slick.Color;

public class CustomColor{
	
	private int colorNum;
	private String colorName;
	private Color actualColor;
	
	CustomColor(String _colorName, int _colorNum, Color c){
		this.colorName = _colorName;
		this.colorNum = _colorNum;
		this.actualColor = c;
	}
	
	

	public int getColorNum() {
		return colorNum;
	}

	public String getColorName() {
		return colorName;
	}

	public Color getColor(){
		return actualColor;
	}


}
