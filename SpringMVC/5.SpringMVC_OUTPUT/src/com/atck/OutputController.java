package com.atck;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * SpringMVC除了在方法上传入原生的request和session外，还能怎样把数据带给页面
 *
 * 1)、可以在方法处传入一个Map、或者Model或者ModelMap，把这些参数中保存的数据都放在请求域中，可以在页面中获取
 *              关系：
 *                 Map、Model、ModelMap最终都是 BindingAwareModelMap在工作
 *                 相当于给BindingAwareModelMap中保存的东西都会放在request域中
 *
 *                 Map(interface(JDK中的接口))     Model(interface(spring中的接口))
 *                            ||                              //
 *                            ||                             //
 *                            \/                            //
 *                           ModelMap(clas)                //
 *                                      \\                //
 *                                      \\               //
 *                                        ExtendedModelMap
 *                                              ||
 *                                              \/
 *                                         BindingAwareModelMap
 * 2)、方法的返回值可以变为ModelAndView类型
 *              既包含视图信息（页面地址）也包括模型数据（给页面带的数据）
 *              而且数据是放在请求域中的
 * 3）、SpringMVC提供了一种可以临时给session域中保存数据的方式
 *      使用一个注解 @SessionAttributes（只能标在类上）
 *      @SessionAttributes(value = "msg"):给BindingAwareModelMap中保存了数据，同时给session中放一份
 *      value指定保存数据时要给session中的放的数据的key
 *
 *      value={"msg"}:只要保存的是这种key的数据，给session中放一份
 *      types={String.class}:只要保存的是String类型的数据，给session中放一份
 *
 *      后来推荐@SessionAttributes就别用了，可能会引发异常
 *      给session中放数据请使用原生API：
 */
@SessionAttributes(value = "jdkajs",types = {String.class})
@Controller
public class OutputController
{
    @RequestMapping("/handle01")
    public String handle01(Map<String,Object> map)
    {

        map.put("msg","你好");
        System.out.println("map的类型" + map.getClass());
        return "success";
    }

    /**
     *
     * @param model,一个接口
     * @return
     */
    @RequestMapping("/handle02")
    public String handle02(Model model)
    {
        model.addAttribute("msg","你好");
        System.out.println("model的类型" + model.getClass());
        return "success";
    }

    @RequestMapping("/handle03")
    public String handle03(ModelMap modelMap)
    {
        modelMap.addAttribute("msg","你好");
        System.out.println("modelMap的类型" + modelMap.getClass());
        return "success";
    }

    /**
     * 返回值是ModelAndView可以给页面携带数据
     * @return
     */
    @RequestMapping("/handle04")
    public ModelAndView handle04()
    {
        //之前的返回值就是视图名，视图解析器会帮我们拼串得到页面的真实地址
        ModelAndView view = new ModelAndView("success");
        view.addObject("msg","你好");
        return view;
    }


}
