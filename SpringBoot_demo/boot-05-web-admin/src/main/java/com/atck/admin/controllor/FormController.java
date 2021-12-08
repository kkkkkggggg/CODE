package com.atck.admin.controllor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormController
{
    /**
     * 不带请求参数或者参数类型不对，400，Bad Request 一般都是浏览器的参数没有正确传递
     * @param a
     * @return
     */
    @GetMapping("/form_layouts")
    public String form_layouts(@RequestParam("a") int a)
    {
        int i = 10 / 0;
        return "form/form_layouts";
    }

    /**
     * MultipartFile自动分装上传来的文件
     * @param email
     * @param userName
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String userName,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException
    {
        log.info("上传的信息:email={"+ email +"}," +
                "userName={"+ userName +"}," +
                "headerImg={"+ headerImg.getOriginalFilename() +"}," +
                "photos={"+ photos.length +"}");

        if (!headerImg.isEmpty())
        {
            headerImg.transferTo(new File("D:\\1.jpg"));
        }

        if (photos.length > 0)
        {
            int i = 2;
            for (MultipartFile photo : photos)
            {
                if (!photo.isEmpty())
                {
                    photo.transferTo(new File("D:\\" + i + ".jpg"));
                }
                i++;
            }
        }

        return "main";
    }
}
