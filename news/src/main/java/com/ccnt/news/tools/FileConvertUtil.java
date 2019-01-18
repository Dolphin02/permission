package com.ccnt.news.tools;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Jinting on 2018/10/15.
 */
public class FileConvertUtil {
    public static File MfileToFile(String path, MultipartFile mfile) throws IOException {
        File f = null;
        if (mfile.equals("") || mfile.getSize() <= 0) {
            mfile = null;
        } else {
            InputStream ins = mfile.getInputStream();
            f = new File(path + "temp/" + mfile.getOriginalFilename());
            inputStreamToFile(ins, f);
            System.out.println("hahahah");
//            File del = new File(f.toURI());  //删除临时文件
//            del.delete();
        }
        return f;
    }

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
