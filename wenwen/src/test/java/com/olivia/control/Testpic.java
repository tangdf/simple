package com.olivia.control;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.olivia.control.util.ImageInfo;
import com.olivia.control.util.Imagination;
import com.olivia.control.util.Picture;

public class Testpic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Picture picture=new Picture();
    picture.setBackgroundColor(new Color(12, 22, 17));
    picture.setFontColor(new Color(200,221, 220));
    picture.setHeight(60);
    picture.setWidth(200);
    
    picture.setNumber(4);
    Imagination imagination=new Imagination();
    ImageInfo imageInfo=imagination.validatePicture(picture);
    
    OutputStream outputStream=null;
    
    try {
		outputStream=new FileOutputStream(new File("F:/javalearn/lesson1/"+imageInfo.getValue()+".jpg"));
	    imagination.outPut(imageInfo, outputStream);
    } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    System.out.println(imageInfo.getValue());
    
	}

}
