package leap.example.mvc.controller;

import leap.lang.resource.Resources;
import leap.web.download.FileDownload;
import leap.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by kael on 2016/12/27.
 * 
 * 文件上传下载示例
 * 
 */
public class FileController {
    
    public FileDownload download1() {
        File file = Resources.getResource("/download.txt").getFile();
        return new FileDownload(file);
    }

    public String download2() {
        return "download:classpath:/download.txt";
    }


    /**
     * 前端使用form-post，看/WEB-INF/views/file/index.html
     * <p>
     * <form action="/file/upload" method="post" enctype="multipart/form-data">
     *      <input type="file" name="file"/>
     *      <button type="submit">提交</button>
     * </form>
     */
    public String upload(MultipartFile file) {
        try {
            InputStream is = file.getInputStream();
            do {
                int i = is.read();
                if (i == -1) {
                    break;
                }
                System.out.println((char) i);
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
