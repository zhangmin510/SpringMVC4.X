/**
 * 
 */
package cn.springmvc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hzzhangmin2015
 *
 */
@RestController
public class FileUploadController {
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		String fileName = null;
		BufferedOutputStream bos = null;
		String base = this.getClass().getResource("/").getPath().split("WEB-INF")[0] + "upload/images/";
		if (!file.isEmpty()) {
			fileName = file.getOriginalFilename();
			try {
				byte[] bytes = file.getBytes();
				bos = new BufferedOutputStream(new FileOutputStream(new File(base + fileName)));
				bos.write(bytes);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		return "upload file success";
	}
	@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
	public String uploadFiles(@RequestParam("file") MultipartFile[] files) {
		String fileName = null;
		BufferedOutputStream bos = null;
		String base = this.getClass().getResource("/").getPath().split("WEB-INF")[0] + "upload/images/";
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				fileName = files[i].getOriginalFilename();
				try {
					byte[] bytes = files[i].getBytes();
					bos = new BufferedOutputStream(new FileOutputStream(new File(base + fileName)));
					bos.write(bytes);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
			
		}
		return "upload files success";
	}
}
