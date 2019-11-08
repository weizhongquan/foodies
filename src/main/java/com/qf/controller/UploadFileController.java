package com.qf.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import com.qf.domain.WangEditor;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qf.domain.WangEditor;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class UploadFileController {

    private Logger log = LoggerFactory.getLogger(getClass());

    // 图片上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public WangEditor uploadFile(
            @RequestParam("file") MultipartFile multipartFile,
            HttpServletRequest request) {
//String path = request.getSession().getServletContext().getRealPath("/uploadFiles/");
        try {
            // 上传的位置
            String path = request.getSession().getServletContext().getRealPath("/uploadimgs/");
            System.out.println("上传路径path:"+path);
            // 判断，该路径是否存在
            File file = new File(path);
            if(!file.exists()){
                // 创建该文件夹
                file.mkdirs();
            }

            // 说明上传文件项
            // 获取上传文件的名称
            String filename = multipartFile.getOriginalFilename();


            //截取后缀,从最后一个"."开始到名称末尾截取
            //菊花.jpg
            String extName=filename.substring(filename.lastIndexOf("."));
            //判断是否是jpg,png,gif一员,正则表达式的分组
            if(!extName.matches("^.(jpg|png|gif)$")){
                /*WangEditor we = new WangEditor();
                we.setErrno(1);*/
                return null;
            }

            //
            // 把文件的名称设置唯一值，uuid
            String uuid = UUID.randomUUID().toString().replace("-", "");
            filename = uuid+"_"+filename;
            // 完成文件上传
            multipartFile.transferTo(new File(path,filename));
            System.out.println("文件"+multipartFile);
            // 返回图片访问路径
            String url = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/uploadimgs/" + filename;

            String[] str = { url };


            WangEditor we = new WangEditor(str);

            System.out.println(we);

            return we;
        } catch (IOException e) {
            log.error("上传文件失败", e);
        }
        return null;

    }

    public String getFileName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timeStr = sdf.format(new Date());

        String name = timeStr+ ".jpg";
        System.out.println(name);
        return name;
    }

}