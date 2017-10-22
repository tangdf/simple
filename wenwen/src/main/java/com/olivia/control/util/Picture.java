package com.olivia.control.util;

import java.awt.Color;

public class Picture {

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	private int height=60;
	private int width=100;
	private int number=4;
	
	private Color backgroundColor=Color.BLACK;
	private Color fontColor=Color.WHITE;
	
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	public Color getFontColor() {
		return fontColor;
	}
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	@Override
	public String toString() {
		return "Picture [height=" + height + ", width=" + width + ", number=" + number 
				 + "]";
	}
	
}
