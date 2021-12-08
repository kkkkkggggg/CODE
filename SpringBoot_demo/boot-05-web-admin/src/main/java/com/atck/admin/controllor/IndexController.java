package com.atck.admin.controllor;

import com.atck.admin.bean.City;
import com.atck.admin.bean.Employee;
import com.atck.admin.bean.User;
import com.atck.admin.service.impl.CityServiceImpl;
import com.atck.admin.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class IndexController
{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @Autowired
    CityServiceImpl cityServiceImpl;

    // @Autowired
    // StringRedisTemplate redisTemplate;

    @GetMapping("/city")
    @ResponseBody
    public City getCityById(@RequestParam("id")int id)
    {
        return cityServiceImpl.getCityById(id);
    }

    @PostMapping("/city")
    @ResponseBody
    public City insertCity(City city)
    {

        cityServiceImpl.insertCity(city);

        return city;
    }

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmp(@PathVariable Integer id)
    {
        return employeeServiceImpl.getEmpById(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb()
    {
        String sql = "select count(*) from tbl_user";
        Long aLong = jdbcTemplate.queryForObject(sql, Long.class);
        return aLong.toString();
    }

    /**
     * 来登录页
     * @return
     */
    @GetMapping({"/","/login"})
    public String index()
    {
        return "login";
    }


    @PostMapping("/login")
    public String main(Model model,User user, HttpSession httpSession)
    {

        if (!StringUtils.isEmpty(user.getUserName()) && "123456".equals(user.getPassWord()))
        {

            //将用户信息放到session中，用于判断用户是否登录
            httpSession.setAttribute("loginUser",user);
            //登录成功重定向到main.html
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }


    }

    @GetMapping("main.html")
    public String mainPage(HttpSession session,Model model)
    {
        //是否登录,拦截器，过滤器
        // Object loginUser = session.getAttribute("loginUser");
        // if (loginUser != null)
        // {
        //     return "main";
        // }else
        // {
        //     model.addAttribute("msg","请重新登录");
        //     return "login";
        // }

        // ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        //
        // long main = Long.parseLong(opsForValue.get("/main.html"));
        // long sql = Long.parseLong(opsForValue.get("/sql"));
        //
        // model.addAttribute("mainCount",main);
        // model.addAttribute("sqlCount",sql);
        log.info("当前方法是:{}","mainPage");
        return "main";
    }


}
