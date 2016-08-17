<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body>
    <center><h2>用户注册</h2></center>
  <br><hr />
  <form action="userRegistAction" method="post" name="form1" >
  <center> 姓名：<input name="user.username" id="user.username" type="text" /> 
    密码：<input name="user.password" id="user.password" type="password" /> 
    <input type="submit" value="注册" />
    </center>
    </form>
  </body>
</html>
