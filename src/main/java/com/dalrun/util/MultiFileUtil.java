package com.dalrun.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MultiFileUtil {
	
	public static boolean multiFileUpload(List<MultipartFile> files,
											int size, String path, String newname[]) {
		// 폴더 생성
		File folder = new File(path);
		if(!folder.exists()) {
			try {
				folder.mkdir();
				System.out.println("폴더 생성 성공");				
			} catch (Exception e) {
				System.out.println("폴더 생성 실패");
			}
		}
		
		// 파일 저장
		for(int i = 0; i < size; i++) {
			String filepath = path + "/" + newname[i];
			System.out.println("filepath=" + filepath);
		    
			File file = new File(filepath);
			
			try {
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
				bos.write(files.get(i).getBytes());
				bos.close();
			} catch (Exception e) {
				System.out.println(e);
				return false;
			} 
		}
		return true;
	}
}
