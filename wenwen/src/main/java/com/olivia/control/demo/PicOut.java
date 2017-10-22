package com.olivia.control.demo;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import com.olivia.control.util.ImageInfo;
import com.olivia.control.util.Imagination;
import com.olivia.control.util.Picture;
@Service
public class PicOut extends BasicTask {
	
	  
      public void pictureOut(){
    	  Imagination imagination=new Imagination();
    	  Picture picture=new Picture();
    	  picture.setBackgroundColor(new Color(40, 20, 10));
    	  ImageInfo imageInfo=imagination.validatePicture(picture);
    	  System.out.println(imageInfo.getValue());
    	  OutputStream outputStream=null;
    	  try {
			outputStream=new FileOutputStream(new File("F:/javalearn/lesson1/"+imageInfo.getValue()+".jpg"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  imagination.outPut(imageInfo, outputStream);
      }

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		this.pictureOut();
	}

	@Override
	public String getRules() {
		// TODO Auto-generated method stub
		return "0/20 * * * * ?";
	}
      
      
}
