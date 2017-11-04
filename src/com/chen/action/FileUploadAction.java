package com.chen.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.imageio.spi.InputStreamImageInputStreamSpi;

public class FileUploadAction extends ActionSupport {
	private List<File> upload;
	private List<String> uploadContentType;
	private List<String> uploadFileName;
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}


	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}


	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@Override
	public String execute() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath("/images");
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		
		for (int i = 0; i < upload.size(); i++) {
			
			FileUtils.copyFile(upload.get(i), new File(file,uploadFileName.get(i)));
		}
		result = "上传成功";
		
		return SUCCESS;
	}
	
}
