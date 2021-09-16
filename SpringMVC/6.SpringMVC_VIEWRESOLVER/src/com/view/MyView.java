package com.view;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 自定义视图
 */
public class MyView implements View
{

    /**
     * 返回的数据的类型
     * @return
     */
    @Override
    public String getContentType()
    {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception
    {

        System.out.println("之前保存的数据" + model);
        response.setContentType("text/html;charset=UTF-8");
        List<String> video = (List<String>) model.get("video");
        List<String> imgs = (List<String>) model.get("imgs");
        response.getWriter().write("哈哈<h1>即将展现精彩内容</h1>");
        for (String string : video)
        {
            response.getWriter().write("<a>下载" + string + ".avi</a><br/>");
        }

        for (String string : imgs)
        {
            response.getWriter().write("<a>下载" + string + ".jpg</a><br/>");
        }
    }
}
