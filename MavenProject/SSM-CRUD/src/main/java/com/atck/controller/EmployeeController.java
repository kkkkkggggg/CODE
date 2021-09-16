package com.atck.controller;

import com.atck.bean.Employee;
import com.atck.bean.Massage;
import com.atck.dao.EmployeeMapper;
import com.atck.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理员工的CRUD请求
 */
@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;


    /**
     * 导入JackSon
     * @param pn
     * @return
     */
     @RequestMapping("/emps")
     @ResponseBody
    public Massage getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn)
    {
        //引入pagehelper插件
        //在查询之前只需要调用,传入页码以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的查询就是一个分页查询
        List<Employee> emps = employeeService.getAll();

        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
        //封装了详细的分页信息，包括我们查询出的数据
        //navigatePages:传入连续显示的页数
        PageInfo page = new PageInfo<>(emps,5);



        return Massage.success().add("page",page);
    }



    /**
     * 查询员工数据
     * @return
     */
//    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model)
    {
        //引入pagehelper插件
        //在查询之前只需要调用,传入页码以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的查询就是一个分页查询
        List<Employee> emps = employeeService.getAll();

        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
        //封装了详细的分页信息，包括我们查询出的数据
        //navigatePages:传入连续显示的页数
        PageInfo page = new PageInfo<>(emps,5);

        model.addAttribute("page",page);
        return "list";
    }

    /**
     * 如果直接发送ajax=PUT形式的请求
     * 封装的数据
     *
     * 问题：请求体中有数据，employee对象封装不上
     *
     * 原因：tomcat，将请求体中的数据封装给一个map
     * request.getParameter("empName")就会从这个map中取值，而springMVC封装POJO对象的时候，
     * 会把POJO中的每个属性值，使用request.getParameter(属性名)的方式获取
     *      Tomcat一看是put请求就不会封装请求体中的数据为map，只有POST请求的数据才会封装为map
     * @param employee
     * @param result
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public Massage saveEmp(@Valid Employee employee, BindingResult result)
    {
        System.out.println(employee);
        if (result.hasErrors())
        {
            //校验失败，返回失败,在模态框中
            Map<String,Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors)
            {
                System.out.println("错误的字段"+error.getField());
                System.out.println("错误信息" + error.getDefaultMessage());
                map.put(error.getField(),error.getDefaultMessage());
            }

            return Massage.fail().add("errorField",map);
        }else
        {
            Integer saveEmp = employeeService.saveEmp(employee);
//            System.out.println(employee.getEmpName());
            return Massage.success().add("result",saveEmp);
        }
    }


    /**
     * 检查用户名是否可用
     * @param empName
     * @return
     */
    @RequestMapping("/checkEmpName")
    @ResponseBody
    public Massage checkEmpName(String empName)
    {
        //先判断用户名是否符合表达式
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if (!empName.matches(regx))
        {
            return Massage.fail().add("va_msg","用户名必须是6-16位英文或者2-5位中文");
        }

        //数据库用户名重复校验
        boolean result = employeeService.checkUserName(empName);
        if (result)
        {
            return Massage.success();
        }else
        {
            return Massage.fail().add("va_msg","用户名不可用");
        }

    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    @ResponseBody()
    public Massage getEmpById(@PathVariable("id") Integer empId)
    {
        Employee emp = employeeService.getEmpById(empId);

        return Massage.success().add("emp",emp);
    }

    /**
     * 如果直接发送ajax=PUT形式的请求
     * 封装的数据
     *
     * 问题：请求体中有数据，employee对象封装不上
     *
     * 原因：tomcat，将请求体中的数据封装给一个map
     * request.getParameter("empName")就会从这个map中取值，而springMVC封装POJO对象的时候，
     * 会把POJO中的每个属性值，使用request.getParameter(属性名)的方式获取
     *  Tomcat一看是put请求就不会封装请求体中的数据为map，只有POST请求的数据才会封装为map
     *
     *  我们要能支持直接发送put之类的请求还要封装请求体中的数据，配置上一个HttpPutFormContentFilter
     *  他的作用，将请求体中的数据解析包装成一个map，使用request.getParameter("empName")就能获取到数据
     *  request被重新包装，
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp",method = RequestMethod.PUT)
    @ResponseBody()
    public Massage updateEmpById(Employee employee)
    {

        Integer result = employeeService.updateEmpById(employee);


        return Massage.success();

    }

    /**
     * 单个批量二合一
     * 批量删除1-2-3
     * 单个删除 1
     * @param ids
     * @return
     */
    @RequestMapping(value = "/emp/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Massage deleteEmp(@PathVariable("ids") String ids)
    {
//        System.out.println(empId);
        if (ids.contains("-"))
        {
            //批量删除
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String id : str_ids)
            {
                del_ids.add(Integer.parseInt(id));
            }
            employeeService.deleteBatch(del_ids);
        }else
        {
            //单个删除
            int id = Integer.parseInt(ids);
            Integer result = employeeService.deleteEmpById(id);
        }

        return Massage.success();
    }
}
