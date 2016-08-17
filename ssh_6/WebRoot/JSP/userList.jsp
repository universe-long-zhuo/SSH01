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
    
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

  </head>
  
  <body>
    <center><h2>用户列表</h2></center>
    <br />
    <hr />
    <s:iterator value="pageBean.list">
    	<s:property value="id"/>&nbsp;&nbsp;
    	<s:property value="username"/><br/>
    </s:iterator>
    	共有<s:property value="pageBean.allRow"/>条记录，
    	共<s:property value="pageBean.totalPage"/>页面，
    	当前第<s:property value="pageBean.currentPage"/>页
    <s:if test="%{pageBean.currentPage==1}">
    	第一页 上一页
    </s:if>
    <s:else>
    	<a href="listUserAction?page=1">第一页</a> <a href="listUserAction?page=<s:property value='%{pageBean.currentPage-1}' />">上一页</a>	
    </s:else>
    <s:if test="%{pageBean.currentPage==pageBean.totalPage}">
    	下一页 最后一页
    </s:if>
    <s:else>
    	<a href="listUserAction?page=<s:property value='%{pageBean.currentPage+1}' />">下一页</a> <a href="listUserAction?page=<s:property value='%{pageBean.totalPage}' />">最后一页</a>	
    </s:else>
    <s:debug />
  </body>
</html>
