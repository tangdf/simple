package com.olivia.control.util;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;



public class Imagination {
	
    private Random random=new Random();
    
	public ImageInfo validatePicture(Picture picture){
		//内存创建验证码图片 更好的方式是有个base picture imageio读取并往上添加新的信息；
		BufferedImage bufferedImage=new BufferedImage(picture.getWidth(), picture.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d=(Graphics2D) bufferedImage.getGraphics();
		
		//填充背景色
		graphics2d.setColor(picture.getBackgroundColor());
		graphics2d.fillRect(0, 0, picture.getWidth(), picture.getHeight());
		//填充前景色也就是验证码的主要信息
		graphics2d.setColor(picture.getFontColor());
		graphics2d.setFont(new Font("Arial", Font.BOLD, 40));
		graphics2d.setStroke(new BasicStroke(2));
		StringBuffer stringBuffer=new StringBuffer();//可以成为该类的持有属性 
		for(int i=0;i<picture.getNumber();i++){
		String str=String.valueOf((char)(random.nextInt(26)+97));
		graphics2d.drawString(str, i*picture.getWidth()/picture.getNumber()+10, picture.getHeight()-10);
		stringBuffer.append(str);
		}
		String value=stringBuffer.toString();
		
		
		//随机加干扰线
		for(int j=0;j<picture.getNumber();j++){
	    graphics2d.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		graphics2d.drawLine(random.nextInt(picture.getWidth()), random.nextInt(picture.getHeight()), random.nextInt(picture.getHeight()), random.nextInt(picture.getHeight()));
		
		}
		ImageInfo imageInfo=new ImageInfo(bufferedImage,value);
	

		
		return imageInfo;
		
	}
	public void outPut(ImageInfo imageInfo,OutputStream outputStream){
		//输出保存图片 也可以直接返回客户端
		//String url="F:/javalearn/lesson1/"+value+".jpg";
		//File FileoutputStream
		
		
		try {
			
			ImageIO.write(imageInfo.getBufferedImage(), "jpg", outputStream);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		finally{
		try {
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
