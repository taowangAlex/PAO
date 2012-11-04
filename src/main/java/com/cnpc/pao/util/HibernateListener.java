package com.cnpc.pao.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		String fileName = arg0.getServletContext().getInitParameter("ddl");
		arg0.getServletContext().log("转换" + fileName + "为：import.sql");
		String srcEnc = fileName.substring(fileName.lastIndexOf(".") + 1);
		// 生成import.sql
		File importFile = null;
		try {
			importFile = new File(new URI(Thread.currentThread()
					.getContextClassLoader().getResource("")
					+ "import.sql"));

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 准备写入
		Reader reader = null;
		Writer writer = null;
		try {
			reader = new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName),srcEnc);
			writer = new OutputStreamWriter(new FileOutputStream(importFile), System.getProperty("file.encoding"));
			
			int c= -1;
			StringBuffer tempSB = new StringBuffer();
			while((c = reader.read())!=-1){
				
				writer.write(c);
				tempSB.append((char)c);
			}
			
			arg0.getServletContext().log(tempSB.toString());
			//写入完成
			arg0.getServletContext().log("生成 import.sql ("+System.getProperty("file.encoding")+")成功");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			try {
				reader.close();
				writer.flush();
				writer.close();
			} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}

	}

}
