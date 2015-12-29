package com.fs.general.common.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

/**
 * 
 * 文件合并工具类，用于将模版zip解压后的文件合并到原目录中
 * 
 * @author caizhiqin
 */

public class FileJoin {

	static int i = 0;

	/**
	 * @param args
	 * @throws Exception
	 */

	// 递归读取文件夹中文件
	public static void read(File file, BufferedWriter bw) {
		try {
			if (file.isFile()) {
				// if(file.getName().indexOf(".sql")>-1||file.getName().indexOf(".SQL")>-1){
				if (true) {
					read_to_write(file, bw);
					bw.newLine();// 断行
					i++;
				}
			} else if (file.isDirectory()) {
				File list[] = file.listFiles();// 取得代表目录中所有文件的File对象数组
				for (int t = 0; t < list.length; t++) {
					read(list[t], bw);
				}
			}
		} catch (Exception e) {
			// TODO 自动生成 catch 块
			System.out.println("错误11==" + file.getName());
			e.printStackTrace();
		}
	}

	// 将文件合并写入一个文件中
	public static void read_to_write(File file, BufferedWriter bw) {
		try {

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);// 建立BufferedReader对象，并实例化为br

			String Line = br.readLine();// 从文件读取一行字符串
			// 判断读取到的字符串是否不为空
			while (Line != null) {
				bw.write(Line);
				bw.newLine();// 断行
				Line = br.readLine();// 从文件中继续读取一行数据
			}
			br.close();// 关闭BufferedReader对象
			fr.close();// 关闭文件

		} catch (Exception e) {
			System.out.println("错误read_to_write==" + file.getName());
			e.printStackTrace();
		}
	}
}
