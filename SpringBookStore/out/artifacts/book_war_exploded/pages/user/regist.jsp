<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%--静态包含base标签、css样式、jquery文件--%>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {

			//给验证码图片绑定单击事件
			$("#cod_img").click(function () {
				//在事件响应的function对象函数中有一个this对象，这个this对象，是当前正在响应事件的dom对象
				//src属性表示验证码img标签的tup路径，它可读可写
				this.src = "${basePath}kaptcha.jpg?d=" + new Date();
			});


			//给注册绑定单击事件
			$("#sub_btn").click(function () {
				// 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
				//1.获取用户名输入框里的内容
				var usernameText = $("#username").val();
				//2.创建正则表达式对象
				var usernamePatt = /^\w{5,12}$/;
				//3.使用test方法验证
				if (!usernamePatt.test(usernameText))
				{
					//4.提示用户结果
					$("span.errorMsg").text("用户名不合法");
					return false;
				}



				// 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
				//1.获取密码输入框里的内容
				var passwordText = $("#password").val();
				//2.创建正则表达式对象
				var passwordPatt = /^\w{5,12}$/;
				//3.使用test方法验证
				if (!passwordPatt.test(passwordText))
				{
					//4.提示用户结果
					$("span.errorMsg").text("密码不合法");
					return false;
				}

				// 验证确认密码：和密码相同
				//1.获取确认密码内容和密码比较
				var repwd = $("#repwd").val();
				if (repwd != passwordText)
				{
					//2.提示用户
					$("span.errorMsg").text("两次输入的密码不一致");
					return false;
				}


				// 邮箱验证：xxxxx@xxx.com
				//1.获取邮箱输入框里的内容
				var emailText = $("#email").val();
				//2.创建正则表达式对象
				var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
				//3.使用test方法验证是否合法
				if (!emailPatt.test(emailText))
				{
					//4.提示用户
					$("span.errorMsg").text("邮箱不合法");
					return false;
				}



				// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
				var codeText = $("#code").val();

				//去掉验证码前后空格
				let trimText = $.trim(codeText);

				if (trimText == null || trimText == "")
				{
					$("span.errorMsg").text("请输入验证码");
					return false;
				}



				$("span.errorMsg").text("");

			});

			//给用户名输入栏，绑定内容变化事件
			$("#username").change(function () {
				$.post("userServlet",{action:"checkUsername",username:this.value},function (data) {
					// alert(data.result);

					if (data.result == "true")
					{
						$("span.errorMsg").text("用户名不可用");
					}
				},"json");
			});
		});

	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									<%--<%=request.getAttribute("errorMsg")==null?"":request.getAttribute("errorMsg")%>--%>
									${requestScope.errorMsg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist"/>
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username"
									value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password"
										   value="${requestScope.password}"/>
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email"
										   value="${requestScope.email}"/>
									<br />
									<br />


										<label>验证码：</label>
										<input class="itxt" type="text" style="width: 100px;" name="code" id="code"/>
										<img alt="" src="kaptcha.jpg" style="float: right; margin-right: 100px;width: 80px;height: 39px " id="cod_img">


									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--静态包含页面底部标签--%>
		<%@include file="/pages/common/bottom.jsp"%>
</body>
</html>