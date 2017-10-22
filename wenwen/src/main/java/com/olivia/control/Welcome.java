package com.olivia.control;


import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.olivia.control.util.ImageInfo;
import com.olivia.control.util.Imagination;
import com.olivia.control.util.Picture;





@Controller
public class Welcome {

	private Logger logger= LoggerFactory.getLogger(Welcome.class);
	
	@RequestMapping("/login")
	public String handle() {
	
		logger.info("simple logger ok");
		
		return "index";
		
	}
	@RequestMapping("/vali")
	//@SessionAttributes("")
	public void pic(HttpServletRequest httpServletRequest ,HttpServletResponse response){
		Picture picture=new Picture();
	    picture.setBackgroundColor(new Color(12, 22, 17));
	    picture.setFontColor(new Color(200,221, 220));
	    picture.setHeight(60);
	    picture.setWidth(200);
	    
	    picture.setNumber(4);
	    Imagination imagination=new Imagination();
	    ImageInfo imageInfo=imagination.validatePicture(picture);
	    System.out.println(imageInfo.getValue());
	    response.setContentType("image/jpeg");
	   
	    httpServletRequest.getSession().setAttribute("validator", imageInfo.getValue());
	    OutputStream outputStream=null;
		try {
			outputStream = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    imagination.outPut(imageInfo, outputStream);
	   
	 
	}
	    
}
