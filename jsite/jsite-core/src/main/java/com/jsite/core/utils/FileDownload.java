package com.jsite.core.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载
 * 创建人：hjx
 * 创建时间：2017年5月25日
 * @version
 */
public class FileDownload {

	public static void fileDownload(final HttpServletResponse response,String filePath,String fileName){
		try{
			byte[] data = toByteArray(filePath);  
			fileName = URLEncoder.encode(fileName,"UTF-8");
			response.reset();
		
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");  
			response.addHeader("Content-Length", "" + data.length);  
			//解决跨域问题，临时更改权限，正式部署时，需要删除改配置
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("application/octet-stream;charset=UTF-8");  
			OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());  
			outputStream.write(data);  
			outputStream.flush();  
			outputStream.close();
			response.flushBuffer();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取到字节数组1
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray(String filePath) throws IOException {

		File f = new File(filePath);
		if (!f.exists()) {
			throw new FileNotFoundException(filePath);
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(f));
			int buf_size = 1024;
			byte[] buffer = new byte[buf_size];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, buf_size))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			bos.close();
		}
	}
	
}
