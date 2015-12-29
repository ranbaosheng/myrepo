package com.fs.general.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class PostToMap {
	
	public static Map<String, Object> getMap(HttpServletRequest request){
		Map<String, Object> accountJsonMap = null;
		/*String file1="";
    	file1=request.getParameter("file");
		if(file1!=null){
			byte[] b= Base64Coder.decodeLines(file1);
			String filepath=request.getSession().getServletContext().getRealPath("/files");
			File file=new File(filepath);
			if(!file.exists())
				file.mkdirs();
			FileOutputStream fos=new FileOutputStream(file.getPath()+"/person_head"+(int)(Math.random()*100)+".png");
			System.out.println(file.getPath());
			fos.write(b);
			fos.flush();
			fos.close();
		}*/
		try {
			  InputStream is = request.getInputStream(); 
	    	  String str = null;
	    	  try{
	    		StringBuffer sb = new StringBuffer() ;
 	            InputStreamReader isr = new InputStreamReader(is);   
 	  	        BufferedReader br = new BufferedReader(isr); 
 	  	        String s = "" ; 
 	  	        while((s=br.readLine())!=null){ 
 	  	           sb.append(s) ; 
 	  	        } 
 	  	        str =sb.toString(); 
	    	   }catch (Exception e) {
			      e.printStackTrace();
		       }
 	    
	    	    accountJsonMap = new HashMap<String, Object>();
	    	    String acountJson = str;	    	        	    	    
	    	    accountJsonMap = JsonUtils.readValue(acountJson);
	    	    
		} catch (Exception e) {
			
		}
		return accountJsonMap;
	}

}
