<%--
  Created by IntelliJ IDEA.
  User: kkkkk
  Date: 2021/8/7
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>员工列表</title>

    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <%--
    web路径：
        不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题
        以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:8080),需要加上项目名
        http://localhost:8080/SSM_CRUD
    --%>

    <%--引入jquery--%>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-1.9.1.min.js"></script>

    <%--引入样式--%>
    <link href="${APP_PATH}/static/bootstrap-3.4.1-dist/css/bootstrap.min.css" rel="stylesheet"/>
    <script src="${APP_PATH}/static/bootstrap-3.4.1-dist/js/bootstrap.min.js"></script>
</head>
<body>

<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加员工</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_add_input" class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="empName" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
                            <span id="helpBlock2" class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="email_add_input" placeholder="email@atck.com">
                            <span id="helpBlock3" class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>

                        <label class="radio-inline">
                            <input type="radio" name="gender" value="M" checked="checked"> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="gender" value="F"> 女
                        </label>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="dId" id="dept_add_select">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<!--员工修改的模态框-->
<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">修改员工</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <input type="hidden" id="empId_update_input" name="empId">
                    <div class="form-group">
                        <label for="empName_add_input" class="col-sm-2 control-label" name="empName">empName</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="empName_update_static"></p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="email_update_input" placeholder="email@atck.com">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>

                        <label class="radio-inline">
                            <input type="radio" name="gender" value="M" checked="checked"> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="gender"  value="F"> 女
                        </label>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="dId" id="dept_update_select">

                            </select>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="emp_update_save_btn">更新</button>
            </div>
        </div>
    </div>
</div>

<%--搭建显示页面--%>
<div class="container">
    <%--标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
            <button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
        </div>
    </div>
    <%--显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                    <tr>
                        <th>
                            <input type="checkbox" id="check_all">
                        </th>
                        <th>#</th>
                        <th>empName</th>
                        <th>gender</th>
                        <th>email</th>
                        <th>deptName</th>
                        <th>操作</th>
                    </tr>
                </thead>

                <tbody>

                </tbody>

            </table>
        </div>
    </div>
    <%--显示分页信息--%>
    <div class="row">
        <%--分页文字信息--%>
        <div class="col-md-6" id="page_info_area"></div>
        <%--分页条信息--%>
        <div class="col-md-6" id="page_nav_area">

        </div>
    </div>
    <script type="text/javascript">
        var totalRecord;
        var pageNo;
        //1.页面加载完成后，直接去发送一个ajax请求，要到分页数据
        $(function () {
           //去首页
            to_page(1);
        });

        function to_page(pn) {
            //跳转页面时，清空全选按钮的选择状态
            $("#check_all").removeProp("checked");

            $.ajax({
                url:"${APP_PATH}/emps",
                data:"pn="+pn,
                type:"get",
                success:function (result) {
                    // console.log(result);

                    //1.解析并显示员工数据
                    build_emps_table(result);
                    //2.解析并显示分页信息
                    build_page_info(result);

                    build_page_nav(result);
                }
            });
        }

        function build_emps_table(result) {
            //清空table表格
            $("#emps_table tbody").empty();

            var emps = result.extend.page.list;
            $.each(emps,function (index,item) {

                // alert(item.empName);
                var checkBoxTd = $("<td></td>").append($("<input type='checkbox' class='check_item'>"));
                var empIdTd = $("<td></td>").append(item.empId);
                var empNameTd = $("<td></td>").append(item.empName);
                var genderTd = $("<td></td>").append(item.gender == 'M' ? "男" : "女");
                var emailTd = $("<td></td>").append(item.email);
                var deptNameTd = $("<td></td>").append(item.department.deptName);
                /**
                 * <button class="btn btn-primary btn-sm">
                 <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                 编辑
                 </button>
                 * @type {*|jQuery}
                 */
                var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append($("<span></span>"))
                .addClass("glyphicon glyphicon-pencil").append("编辑");
                //为编辑按钮添加一个自定义的属性，来表示当前员工的id
                editBtn.attr("edit_id",item.empId);

                /**
                 * <button class="btn btn-danger btn-sm">
                 <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                 删除
                 </button>
                 * @type {*|jQuery}
                 */
                var deleteBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append($("<span></span>"))
                    .addClass("glyphicon glyphicon-trash").append("删除");
                deleteBtn.attr("delete_empId",item.empId);

                var btnTd = $("<td></td>").append(editBtn).append(deleteBtn);
                //append方法执行完成以后还是返回原来的元素
                $("<tr></tr>").append(checkBoxTd).append(empIdTd).append(empNameTd).append(genderTd).append(emailTd).append(deptNameTd)
                    .append(btnTd).appendTo("#emps_table tbody");
            });
        }

        // <div class="col-md-6">当前第 页,总共 页,共有 条记录</div>
        function build_page_info(result) {
            $("#page_info_area").empty();

            var page = result.extend.page;
            $("#page_info_area").append("当前第"+ page.pageNum +"页,总共"+ page.pages +"页,共有"+ page.total +"条记录")
            totalRecord = page.total;
            pageNo = page.pageNum;
        }

        //解析显示分页条,点击分页条要能去下一页。。。。
        function build_page_nav(result) {
            $("#page_nav_area").empty();

            var ul = $("<ul></ul>").addClass("pagination");

            //构建元素
            var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
            var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
            if (!result.extend.page.hasPreviousPage)
            {
                firstPageLi.addClass("disabled");
                prePageLi.addClass("disabled");
            }else
            {

                //为元素添加点击翻页的事件
                firstPageLi.click(function () {
                    to_page(1);
                });
                prePageLi.click(function () {
                    to_page(result.extend.page.pageNum - 1);
                });
            }

            //构建元素
            var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
            var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
            if (!result.extend.page.hasNextPage)
            {
                nextPageLi.addClass("disabled");
                lastPageLi.addClass("disabled");
            }else
            {

                //为元素添加点击翻页的事件
                nextPageLi.click(function () {
                    to_page(result.extend.page.pageNum + 1);
                });
                lastPageLi.click(function () {
                    to_page(result.extend.page.pages);
                });
            }

            //添加首页和上一页提示
            ul.append(firstPageLi).append(prePageLi);
            //遍历给ul中添加页码提示
            $.each(result.extend.page.navigatepageNums,function (index,item) {

                var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
                if (result.extend.page.pageNum == item)
                {
                    numLi.addClass("active");
                }

                numLi.click(function () {
                    to_page(item);
                });
                ul.append(numLi);
            });
            //添加下一页和末页提示
            ul.append(nextPageLi).append(lastPageLi);
            //把ul加入到nav元素中
            var navEle = $("<nav></nav>").append(ul);

            navEle.appendTo("#page_nav_area");
        }

        function reset_form(ele)
        {
            //重置表单内容
            $(ele)[0].reset();
            //清空表单样式
            $("ele").find("*").removeClass("has-success has-error");
            $(ele).find(".help-block").text("");

        }

        $("#emp_add_modal_btn").click(function () {
            //清除表单数据(表单的完整重置（表单的数据，表单的数据）)
            // $("#empAddModal form")[0].reset();
            reset_form("#empAddModal form");


            //清空选框中的部门选项
            // $("#dept_add_select").empty();

            getDepts("#empAddModal select");

            $("#empAddModal").modal({
                backdrop:"static"
            });

        });

       function getDepts(ele) {
           //清空选框中的部门选项
           $(ele).empty();

            $.ajax(
                {
                    url:"${APP_PATH}/depts",
                    type:"get",
                    success:function (result) {
                        // console.log(result);
                        // $("#empAddModal select").append("")
                        $.each(result.extend.depts,function () {
                            var option = $("<option></option>").append(this.deptName).attr("value",this.deptId);
                            option.appendTo(ele);
                        });
                    }
                }
            );
       }

       function validate_add_form(){
           var empName = $("#empName_add_input").val();
           var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
           if (!regName.test(empName))
           {
               show_validate_msg("#empName_add_input","error","用户名可以是2-5位中文或者6-16位英文");
               // $("#empName_add_input").parent().addClass("has-error");
               // $("#empName_add_input").next("span").text("用户名可以是2-5位中文或者6-16位英文");
               return false;
           }else
           {
               show_validate_msg("#empName_add_input","success","");

               // $("#empName_add_input").parent().addClass("has-success");
               // $("#empName_add_input").next("span").text("");

           }

           var email = $("#email_add_input").val();
           var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
           if (!regEmail.test(email))
           {
               // $("#email_add_input").parent().addClass("has-error");
               // $("#email_add_input").next("span").text("邮箱格式错误");
               show_validate_msg("#email_add_input","error","邮箱格式错误");
               return false;
           }else
           {
               // $("#email_add_input").parent().addClass("has-success");
               // $("#email_add_input").next("span").text("");

               show_validate_msg("#email_add_input","success","");

           }

           return true;
       }

       function show_validate_msg(ele,status,msg)
       {
           $(ele).parent().removeClass("has-success has-error");

           if ("success" == status)
           {
               $(ele).parent().addClass("has-success");
               $(ele).next("span").text(msg);
           }else if ("error" == status)
           {
               $(ele).parent().addClass("has-error");
               $(ele).next("span").text(msg);
           }
       }

       $("#emp_save_btn").click(function () {

           // alert(validate_add_form() && $(this).attr("ajax-validate") == "success");
           if (validate_add_form() && $(this).attr("ajax-validate") == "success")
           {
               $.ajax(
                   {
                       url:"${APP_PATH}/emp",
                       type:"post",
                       data:$("#empAddModal form").serialize(),
                       success:function (result) {
                           if (result.code == 100)
                           {
                               //员工保存成功
                               //1.关闭模态框
                               $("#empAddModal").modal("hide");

                               //2.来到最后一页，显示刚才保存的数据
                               //发送ajax请求显示最后一页数据即可
                               to_page(totalRecord);
                           }else
                           {
                               //显示失败信息
                               // console.log(result);
                               // 有哪个字段的错误信息就显示哪个字段
                               if (result.extend.errorField.email != null)
                               {
                                   show_validate_msg("#email_add_input","error",result.extend.errorField.email);
                               }

                               if (result.extend.errorField.empName != null)
                               {
                                   show_validate_msg("#empName_add_input","error",result.extend.errorField.empName);
                               }
                           }
                       }
                   }
               )
           }

       });

       //检验用户名是否可用
        $("#empName_add_input").change(function () {
            $.ajax(
                {
                    url:"${APP_PATH}/checkEmpName",
                    type:"get",
                    data:$("#empName_add_input").serialize(),
                    success:function (result) {
                        if (result.code == 100)
                        {
                           show_validate_msg("#empName_add_input","success","");
                            $("#emp_save_btn").attr("ajax-validate","success");
                        }else
                        {
                            show_validate_msg("#empName_add_input","error",result.extend.va_msg);
                            $("#emp_save_btn").attr("ajax-validate","error");

                        }

                    }
                }
            )
        });

        //1.我们是按钮创建之前就绑定了click。所以绑定不上，可以使用on方法替代click
        $(document).on("click",".edit_btn",function () {

            //1.查出部门信息，并显示部门列表
            getDepts("#empUpdateModal select");


            //2.查出员工信息，并显示
            get_emp($(this).attr("edit_id"),);
            // alert("hahahah");
            $("#empUpdateModal").modal({
               backdrop: "static"
            });


        });

        function get_emp(id) {
            $.ajax({
                url:"${APP_PATH}/emp/" + id,
                type:"get",
                success:function (result) {
                    // console.log(result);
                    var empData = result.extend.emp;
                    $("#empId_update_input").val(empData.empId);
                    $("#empName_update_static").text(empData.empName);
                    $("#email_update_input").val(empData.email);
                    $("#empUpdateModal input[name=gender]").val([empData.gender]);
                    $("#empUpdateModal select").val([empData.dId]);
                }
            });

        }

        //点击更新，更新员工信息
        $("#emp_update_save_btn").click(function () {
            //验证邮箱是否合法
            var email = $("#email_update_input").val();
            var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if (!regEmail.test(email))
            {
                show_validate_msg("#email_update_input","error","邮箱格式错误");
                return false;
            }else
            {
                show_validate_msg("#email_update_input","success","");
            }

            //2.发送ajax请求，保存更新的员工数据
            $.ajax({
                url:"${APP_PATH}/emp",
                type:"put",
                data:$("#empUpdateModal form").serialize(),
                success:function (result) {
                    if (result.code == 100)
                    {
                        $("#empUpdateModal").modal("hide");
                        to_page(pageNo);
                    }
                }
            })
            // console.log($("#empUpdateModal form").serialize());
        });

        //单个删除
        $(document).on("click",".delete_btn",function () {
            var empId = $(this).attr("delete_empId");


            var comfirmDelete = confirm("确认是否删除员工:" + $(this).parents("tr").find("td:eq(2)").text());

            if (comfirmDelete === true)
            {
                //发送ajax请求删除员工
                 $.ajax({
                     url:"${APP_PATH}/emp/" + empId,
                     type:"delete",
                     success:function (result) {
                         to_page(pageNo);
                     }
                 })
                alert("删除成功");
            }
        });

        $("#check_all").change(function () {

            //attr获取checked是undefined
            //我们这是dom原生的属性，attr获取自定义属性的值
            //prop修改和读取dom原生属性的值
            // alert($(this).is(":checked"));

            $(".check_item").prop("checked",$("#check_all").prop("checked"));
        });

        $(document).on("click",".check_item",function () {
            var flag = $(".check_item:checked").length == $(".check_item").length
                //判断当前选中的元素是否是5个
                $("#check_all").prop("checked",flag);
        });

        //点击删除按钮，选中的员工全部删除
        $("#emp_delete_all_btn").click(function () {
            //组装员工id字符串
            var del_idstr = "";

            var empNames = "";

            $.each($(".check_item:checked"),function () {
                //this代表当前遍历的item

                empNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
                del_idstr += $(this).parents("tr").find("td:eq(1)").text() + "-";
            });
            //去除empNames多余的逗号
            empNames =  empNames.substring(0,empNames.length-1);

            //去除del_idstr多余的-
            del_idstr = del_idstr.substring(0,del_idstr.length-1);

            if (confirm("确认删除【" + empNames + "】吗?"))
            {
                //发送ajax请求删除员工
                $.ajax({
                    url:"${APP_PATH}/emp/" + del_idstr,
                    type:"delete",
                    success:function (result) {
                        alert(result.msg);
                        to_page(pageNo);
                    }
                })
            }

        });

    </script>
</div>
</body>
</html>
