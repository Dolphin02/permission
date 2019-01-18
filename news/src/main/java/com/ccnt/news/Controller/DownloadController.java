package com.ccnt.news.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class DownloadController {

    @Value("${savedir}")
    private String filepath;

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public String download(HttpServletResponse response, @RequestParam("filename") String filename) {
//        String filepath = "Files";
//        File file = new File(filepath + "/" + filename);

        File file = new File(filepath + filename);

        String filenameCN = null;  // 解决中文乱码
        try {
            filenameCN = new String(filename.getBytes("utf-8"), "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (file.exists()) {
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filenameCN);
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    os.flush();
                    i = bis.read(buffer);
                }
                return "success";

            } catch (IOException e) {
                e.printStackTrace();
                return "fail";
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return "fail";
                    }
                }
            }
        }
        return "fail";
    }

}
