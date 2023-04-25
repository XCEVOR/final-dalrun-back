package com.dalrun.util;

import java.io.File;

import jakarta.servlet.http.HttpServletRequest;

public class FileNameListUtil {

    public static String[] getFileNameList (String filepathWebapp) {
//        String fileupload_path = hsreq.getServletContext().getRealPath("/dalrun-hc/uploadtemp");
        String DATA_DIRECTORY = "C:/Development/KDT_projects/SpringBootSamples/final-dalrun-back/src/main/webapp/dalrun-hc/uploadtemp";
//        String DATA_DIRECTORY = hsreq.getServletContext().getRealPath("/dalrun-hc/uploadtemp");
        File dir = new File(filepathWebapp);  // 실제 배포시 문제 가능성 예상. 어떻게 될지 모르겠으니 예의주시 바람. HttpServletRequest 에 따름.

        String[] filenamesList = dir.list();
        for (String filename : filenamesList) {
            System.out.println("filename: " + filename);
        }
        
        return filenamesList;
    }
}
