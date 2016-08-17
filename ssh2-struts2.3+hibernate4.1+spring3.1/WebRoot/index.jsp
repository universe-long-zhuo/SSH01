<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Struts2 + Spring3.1 + Hibernate4</title>
  </head>
  <body>
   Struts2 + Spring3.1 + Hibernate4 测试页面
   <hr />
  <form action="getUser" name="form_main" method="post">
      <input type="submit" name="button" value="Test" >
  </form>
  <br />
  <a href="login.jsp">用户登录</a>&nbsp;&nbsp;<a href="JSP/regist.jsp">用户注册</a>&nbsp;&nbsp;<a href="listUserAction">用户列表</a>
  &nbsp;&nbsp;<a href="testAction">测试页面</a>
  </body>
</html>