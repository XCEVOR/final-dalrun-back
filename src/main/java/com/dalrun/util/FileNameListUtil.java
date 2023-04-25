package com.dalrun.util;

import java.io.File;

import jakarta.servlet.http.HttpServletRequest;

public class FileNameListUtil {

    public static void getFileNameList (String filepathWebapp) {
//        String fileupload_path = hsreq.getServletContext().getRealPath("/dalrun-hc/uploadtemp");
        String DATA_DIRECTORY = "C:/Development/KDT_projects/SpringBootSamples/final-dalrun-back/src/main/webapp/dalrun-hc/uploadtemp";
//        String DATA_DIRECTORY = hsreq.getServletContext().getRealPath("/dalrun-hc/uploadtemp");
        File dir = new File(filepathWebapp);

        String[] filenames = dir.list();
        for (String filename : filenames) {
            System.out.println("filename : " + filename);
        }
        
    }
}
