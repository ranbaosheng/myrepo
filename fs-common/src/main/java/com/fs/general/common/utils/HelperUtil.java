package com.fs.general.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;

public class HelperUtil {


	@Value("#{settings['upload_temp_path']}")
	private String upload_file_path;
	
	/**
	 * 根据当前日期产生图片存放文件夹
	 * 
	 * @param sc
	 * @return
	 * @throws Exception
	 * 
	 */

	private boolean flag;
	private File file;

	private FileOutputStream fs;

	public String getUploadImgFoler(String logoRealPathDir) throws Exception {
		/** 创建日期文件夹 **/
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd/HH");
		String dateFolder = logoRealPathDir+"/" + dateformat.format(new Date());
		File dateFolderFile;

		try {
			dateFolderFile = new File(dateFolder);
			if (!dateFolderFile.exists()) {
				dateFolderFile.mkdirs();
			}
		} catch (Exception e) {
			throw e;
		}

		return dateFolder;
	}

	public void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}

	}

	public boolean deleteFile(String sPath) {
		flag = false;
		file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

	public boolean deleteDirectory(String sPath) {
		// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		if (!sPath.endsWith(File.separator)) {
			sPath = sPath + File.separator;
		}
		File dirFile = new File(sPath);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if (!dirFile.exists() || !dirFile.isDirectory()) {
			return false;
		}
		flag = true;
		// 删除文件夹下的所有文件(包括子目录)
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			} // 删除子目录
			else {
				flag = deleteDirectory(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag)
			return false;
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteFolder(String sPath) {
		flag = false;
		file = new File(sPath);
		// 判断目录或文件是否存在
		if (!file.exists()) { // 不存在返回 false
			return flag;
		} else {
			// 判断是否为文件
			if (file.isFile()) { // 为文件时调用删除文件方法
				return deleteFile(sPath);
			} else { // 为目录时调用删除目录方法
				return deleteDirectory(sPath);
			}
		}
	}
	/**
	 * 下载服务器文件
	 * @param path
	 * @param response
	 */
	public void downloadFile(String path, HttpServletResponse response) {
        try {
        	
            // path是指欲下载的文件的路径。
            File file = new File(path);
            if(file.exists()){
	            // 取得文件名。
	            String filename = file.getName();
	            // 取得文件的后缀名。
	            //String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
	
	            // 以流的形式下载文件。
	            InputStream fis = new BufferedInputStream(new FileInputStream(path));
	            byte[] buffer = new byte[fis.available()];
	            fis.read(buffer);
	            fis.close();
	            // 清空response
	            response.reset();
	            // 设置response的Header
	            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
	            response.addHeader("Content-Length", "" + file.length());
	            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	            response.setContentType("application/octet-stream");
	            toClient.write(buffer);
	            toClient.flush();
	            toClient.close();
            }else{
            	System.out.println(path + "文件不存在");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	/**
	 * 下载网络文件
	 * @param response
	 * @throws MalformedURLException
	 */
	public void downloadNet(String path, HttpServletResponse response) throws MalformedURLException {
		String webroot = System.getProperty("user.dir");
		String filename = path.substring(path.lastIndexOf("/"));
		String fullpath = webroot + filename;
		// 下载网络文件
        int byteread = 0;
        URL url = new URL(path);
        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            if (null != inStream) {
	            FileOutputStream fs = new FileOutputStream(fullpath);
	            byte[] buffer = new byte[1204];
	            while ((byteread = inStream.read(buffer)) != -1) {
	                fs.write(buffer, 0, byteread);
	            }
	            fs.close();
	            downloadFile(fullpath,response);
	            File file = new File(fullpath);  
	            // 路径为文件且不为空则进行删除  
	            if (file.isFile() && file.exists()) {  
	                file.delete();  
	            }  
            }
        } catch (IOException e) {
        	System.out.println(path + "文件不存在");
        }
    }
}
