<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br />
  <center><h2>用户登录</h2></center>
  <br><hr />
  <form action="userLoginAction" method="post" name="form1" >
  <center> 帐号：<input name="username" id="username" type="text" /> 
    密码：<input name="password" id="password" type="password" /> 
    <input type="submit" value="登录" />
    <br />
    <s:property value="fieldErrors.loginError[0]"/>
    <s:debug />
    </center>
  </form>
  </body>
</html>
