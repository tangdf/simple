package com.olivia.control.util;

import java.awt.image.BufferedImage;
//持有返回的内存image 与验证码的值value

public class ImageInfo {
	
private BufferedImage bufferedImage;
private String value;
public ImageInfo(){
	
}
public ImageInfo(BufferedImage bufferedImage ,String value){
	this.bufferedImage=bufferedImage;
	this.value=value;
}
public BufferedImage getBufferedImage() {
	return bufferedImage;
}
public void setBufferedImage(BufferedImage bufferedImage) {
	this.bufferedImage = bufferedImage;
}
public String getValue() {
	return value;
}
public void setValue(String value) {
	this.value = value;
}
}
