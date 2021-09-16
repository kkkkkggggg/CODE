<%@ page import="com.atck.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/6/19
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();
        person.setName("kkkk");
        person.setPhones(new String[]{"46546546","4657465132","101657512"});
        List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("上海");
        list.add("深圳");
        person.setCities(list);

        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);

        pageContext.setAttribute("person",person);
    %>

    输出person：${person}<br>
    输出person的name属性：${person.name}<br>
    输出person的phone属性：${person.phones}<br>
    输出person的phone个别属性：${person.phones[1]}<br>
    输出person的cities属性：${person.cities}<br>
    输出person的cities个别属性：${person.cities[0]}<br>
    输出person中的map属性：${person.map}<br>
    输出person中的map的个别属性：${person.map.key1}<br>
    输出person中的age属性：${person.age}
</body>
</html>
