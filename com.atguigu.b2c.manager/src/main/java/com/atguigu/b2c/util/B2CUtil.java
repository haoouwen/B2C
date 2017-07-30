package com.atguigu.b2c.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.web.multipart.MultipartFile;


public class B2CUtil {

	public static List<String> getImgeName(MultipartFile[] multipart) {
		List<String> list = new ArrayList<String>();
		String imgePath = B2CUtil.getImgePath();
		for (MultipartFile file : multipart) {
				String originalFilename = file.getOriginalFilename();
				String name =imgePath+"\\"+System.currentTimeMillis()+originalFilename;
				list.add(name);
				try {
					file.transferTo(new File(name));
				} catch (Exception e) {
					
					e.printStackTrace();
				}
		}
		return list;
	}
	public static String getImgePath(){
		Properties properties = new Properties();
		InputStream resourceAsStream = B2CUtil.class.getClassLoader().getResourceAsStream("imgePath.properties");
		try {
			properties.load(resourceAsStream);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String imgePath = properties.getProperty("windows");
		System.out.println(imgePath);
		return imgePath;
		
	}
	

}
