package com.dalrun.util;

import java.util.Date;

public class EditorUtil {

    // 파일명 -> 변경
    
    // myfile.txt -> 342456232.txt
    public static String getNewFileName(String filename) {
        String newfilename = "";
        String fpost = "";
        
        if (filename.indexOf('.') >= 0) {    // 확장자명이 있음
            fpost = filename.substring(filename.indexOf('.'));  // .txt
            newfilename = new Date().getTime() + fpost;     // 342456232 + .txt
        }
        else {     // 확장자명이 없음
            newfilename = new Date().getTime() + ".back";   // 342456232 + .back
        }
        
        return newfilename;
    }
    
    // myfile.PNG -> ProductCode + Seq.PNG
    public static String getNewProductCodeFileName(String filename, String productcode, int i) {
        String newfilename = "";
        String fpost = "";
        
        if (filename.indexOf('.') >= 0) {    // 확장자명이 있음
            fpost = filename.substring(filename.indexOf('.'));  // .PNG
            if ( (i + 1) < 10 ) {
                newfilename = productcode + "-0" + (i + 1) + fpost;     // ADID-LIRA + -0 + 2 + .PNG
            }
            else {
                newfilename = productcode + "-" + (i + 1) + fpost;     // ADID-LIRA + - + 12 + .PNG
            }
        }
        else {     // 확장자명이 없음
            newfilename = new Date().getTime() + ".back";   // 342456232 + .back
        }
        
        return newfilename;
    }
}
