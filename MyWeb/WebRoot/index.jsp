<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加记录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <center>
    <h3>添加记录</h3>
    <s:form action="saveBook">
    	<s:textfield label="书名" name="bookInfo.bookname"></s:textfield>
    	<s:textfield label="作者" name="bookInfo.author"></s:textfield>
    	<s:textfield label="价格" name="bookInfo.bookprice"></s:textfield>
    	<s:textfield label="书号" name="bookInfo.bookid"></s:textfield>
    	<s:submit value="提交"></s:submit>
    </s:form>
    </center>
  </body>
</html>
