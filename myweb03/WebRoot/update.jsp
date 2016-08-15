<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
	<center>
	<s:form action="saveUpdate">
		<s:textfield value="%{bookInfo.bookid}" label="书号" name="bookInfo.bookid"></s:textfield>
		<s:textfield value="%{bookInfo.bookname}" label="书名" name="bookInfo.bookname"></s:textfield>
		<s:textfield value="%{bookInfo.bookprice}" label="价格" name="bookInfo.bookprice"></s:textfield>
		<s:textfield value="%{bookInfo.author}" label="作者" name="bookInfo.author"></s:textfield>
		<s:hidden value="%{bookInfo.id}" name="bookInfo.id"></s:hidden>
		<s:submit value="修改"></s:submit>
	</s:form>
	</center>
  </body>
</html>
