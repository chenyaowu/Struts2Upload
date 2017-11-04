package com.chen.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {
	private String inputPath;
	
	private String filename;
	
	
	

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	public InputStream getInputStream() throws IOException{
		//return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
		String path = ServletActionContext.getServletContext().getRealPath("/images");
		String filepath = path+"\\"+filename;
		File file = new File(filepath);
		return FileUtils.openInputStream(file);
	}
	
	public String getDownloadFileName() throws IOException{
		filename = URLEncoder.encode(filename, "UTF-8");
		return filename;
	}
	
}
