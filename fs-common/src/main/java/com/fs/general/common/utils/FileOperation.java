package com.fs.general.common.utils;

import java.io.File;
import java.util.regex.Pattern;

/**
 * 文件操作类
 * @author etb
 *
 */
public class FileOperation {
	
	/**
	 * webAppRootKey 在web.xml 文件中配置的
	 */
	private static final String WEB_APP_ROOT_KEY = "un-general";
	/**
	 * 获取应用的根目录
	 * 如：E:\MyWorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp3\wtpwebapps\eztportal\
	 * @return
	 */
	public static String getWebAppRoot(){
		return System.getProperty(WEB_APP_ROOT_KEY);
		
	}
	
	/** 
	 *  根据路径删除指定的目录或文件，无论存在与否 
	 *@param sPath  要删除的目录或文件 
	 *@return 删除成功返回 true，否则返回 false。 
	 */  
	public static boolean deleteFolder(String sPath) {  
		boolean flag = false;  
	    File file = new File(sPath);  
	    // 判断目录或文件是否存在  
	    if (!file.exists()) {  // 不存在返回 false  
	        return flag;  
	    } else {  
	        // 判断是否为文件  
	        if (file.isFile()) {  // 为文件时调用删除文件方法  
	            return deleteFile(sPath);  
	        } else {  // 为目录时调用删除目录方法  
	            return deleteDirectory(sPath);  
	        }  
	    }  
	}  
	
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public static boolean deleteFile(String sPath) {  
		boolean flag = false;  
		File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  
	
	
	/** 
	 * 删除目录（文件夹）以及目录下的文件 
	 * @param   sPath 被删除目录的文件路径 
	 * @return  目录删除成功返回true，否则返回false 
	 */  
	public static boolean deleteDirectory(String sPath) {  
	    //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
	    if (!sPath.endsWith(File.separator)) {  
	        sPath = sPath + File.separator;  
	    }  
	    File dirFile = new File(sPath);  
	    //如果dir对应的文件不存在，或者不是一个目录，则退出  
	    if (!dirFile.exists() || !dirFile.isDirectory()) {  
	        return false;  
	    }  
	    boolean flag = true;  
	    //删除文件夹下的所有文件(包括子目录)  
	    File[] files = dirFile.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        //删除子文件  
	        if (files[i].isFile()) {  
	            flag = deleteFile(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        } //删除子目录  
	        else {  
	            flag = deleteDirectory(files[i].getAbsolutePath());  
	            if (!flag) break;  
	        }  
	    }  
	    if (!flag) return false;  
	    //删除当前目录  
	    if (dirFile.delete()) {  
	        return true;  
	    } else {  
	        return false;  
	    }  
	}
	
	/**
     * 获取配置文件中的path属性
     * @return
     * <br>----------------------------------------------------变更记录--------------------------------------------------
     * <br> 序号      |           时间                          |   作者      |                          描述                                                         
     * <br> 0     | 2014年5月3日 下午3:22:00    |  张峰    | 创建
     */
    public static String filePath(String type) {
    	String returnPath = "";
    	String osName = System.getProperty("os.name");
    	//1：用户文件存放路径，其他文件存放路径
    	if(type.equals("1")){
    		 if (Pattern.matches("Linux.*", osName)) {
    			 returnPath = PropertyConfigurer.getProperty("vc001.project.file.path.upload.linux");
    	     } else if (Pattern.matches("Windows.*", osName)) {
    	    	 returnPath = PropertyConfigurer.getProperty("vc001.project.file.path.upload.windows");
    	     } else {
    	    	 System.out.println("除windows和linux外,不支持其他操作系统");
    	        return "";
    	     }
    	}else{
    		 if (Pattern.matches("Linux.*", osName)) {
    			 returnPath = PropertyConfigurer.getProperty("vc001.project.file.path.upload.linux");
    	     } else if (Pattern.matches("Windows.*", osName)) {
    	    	 returnPath = PropertyConfigurer.getProperty("vc001.project.file.path.upload.windows");
    	     } else {
    	    	 System.out.println("除windows和linux外,不支持其他操作系统");
    	        return "";
    	     }
    	}
    	return returnPath;
    }
	 
}
