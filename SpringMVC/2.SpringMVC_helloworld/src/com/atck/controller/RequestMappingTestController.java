package com.atck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @RequestMapping("/haha")，为当前类的所有方法指定一个基准路径：/haha
 *
 */
@RequestMapping("/haha")
@Controller
public class RequestMappingTestController
{
    @RequestMapping("/hello01")
    public String handle01()
    {
        System.out.println("RequestMappingTestController...handle01");
        return "success";
    }

    /**
     * RequestMapping的其他属性
     * @return
     *
     * method：限定请求方式
     *      http协议中的所有请求方式：
     *              【GET】、HEAD、【POST】、PUT、PATCH、DELETE、OPTIONS、TRACE
     *      GET、POST
     *      method=RequestMethod.POST:只接受post请求，mor所有请求都可以
     *              不是规定的请求方式会报错，HTTP Status 405 - Request method 'GET' not supported
     * params:规定请求参数
     *      params 和 headers支持简单的表达式：
     *          param1: 表示请求必须包含名为 param1 的请求参数
     *              eg: params = {"username"}
     *                  发送请求的时候必须带上一个名为username的参数，没带都会404
     *          !param1: 表示请求不能包含名为 param1 的请求参数
     *              eg：params = {"！username"}
     *                  发送请求的时候不能带上一个名为username的参数，带了都会404
     *          param1 != value1: 表示请求包含名为 param1 的请求参数，但其值不能为 value1
     *              eg: params = {"username != 123"}
     *                  发送请求的时候，携带的username的值必须不是123（不带username或者username的值不是123）
     *          {“param1=value1”, “param2”}: 请求必须包含名为 param1 和param2 的两个请求参数，且 param1 参数的值必须为 value1
     *              eg: params = {"username != 123","pwd","!age"}
     *                  请求参数必须满足以上规则
     *                  请求的username的值不能是123，必须有名字为pwd的参数，不能有名字为age的参数
     *
     * headers：规定请求头，也和params一样
     * consumes：只接受内容类型是哪种的请求，规定请求头中的Context-Type
     * produces：告诉浏览器返回的内容类型是什么，给请求头中加上Context-Type：text/html;charset=utf-8
     */
    @RequestMapping(value = "/hello02",method = RequestMethod.POST)
    public String handle02()
    {
        return "success";
    }

    @RequestMapping(value = "/hello03",params = {"username != 123","pwd","!age"})
    public String handle03()
    {
        System.out.println("handle03........");
        return "success";
    }

    /**
     * USer-Agent:浏览器信息
     * 让火狐能访问，谷歌不能访问
     * 谷歌:User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36
     * 火狐：User-Agent:Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0
     * @return
     */
    @RequestMapping(value = "/hello04",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0"})
    public String handle04()
    {
        System.out.println("hello04.....");
        return "success";
    }
}
