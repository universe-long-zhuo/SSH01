<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>所有记录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<script type="text/javascript">
		function CheckAll(thisform){
	        for (var i=0;i<thisform.elements.length;i++){
	            var e = thisform.elements[i];
	            if (e.Name != "chkAll"&&e.disabled!=true)
	                e.checked = thisform.chkAll.checked;
	        }
	    }
		</script>
		<style type="text/css">
			*,html,body {font-size: 12px;}			
			.td1 {background: #eeeeee;}			
			.td2 {background: #fefefe;}
			.page {
				PADDING-RIGHT: 3px; PADDING-LEFT: 3px; PADDING-BOTTOM: 3px; MARGIN: 3px; PADDING-TOP: 3px; TEXT-ALIGN: center
			}
			.page A {
				BORDER-RIGHT: #ddd 1px solid; PADDING-RIGHT: 5px; BORDER-TOP: #ddd 1px solid; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px; BORDER-LEFT: #ddd 1px solid; COLOR: #88af3f; MARGIN-RIGHT: 2px; PADDING-TOP: 2px; BORDER-BOTTOM: #ddd 1px solid; TEXT-DECORATION: none
			}
			.page A:hover {
				BORDER-RIGHT: #85bd1e 1px solid; BORDER-TOP: #85bd1e 1px solid; BORDER-LEFT: #85bd1e 1px solid; COLOR: #638425; BORDER-BOTTOM: #85bd1e 1px solid; BACKGROUND-COLOR: #f1ffd6
			}
			.page A:active {
				BORDER-RIGHT: #85bd1e 1px solid; BORDER-TOP: #85bd1e 1px solid; BORDER-LEFT: #85bd1e 1px solid; COLOR: #638425; BORDER-BOTTOM: #85bd1e 1px solid; BACKGROUND-COLOR: #f1ffd6
			}
			.page SPAN.current {
				BORDER-RIGHT: #b2e05d 1px solid; PADDING-RIGHT: 5px; BORDER-TOP: #b2e05d 1px solid; PADDING-LEFT: 5px; FONT-WEIGHT: bold; PADDING-BOTTOM: 2px; BORDER-LEFT: #b2e05d 1px solid; COLOR: #fff; MARGIN-RIGHT: 2px; PADDING-TOP: 2px; BORDER-BOTTOM: #b2e05d 1px solid; BACKGROUND-COLOR: #b2e05d
			}
			.page SPAN.disabled {
				BORDER-RIGHT: #f3f3f3 1px solid; PADDING-RIGHT: 5px; BORDER-TOP: #f3f3f3 1px solid; PADDING-LEFT: 5px; PADDING-BOTTOM: 2px; BORDER-LEFT: #f3f3f3 1px solid; COLOR: #ccc; MARGIN-RIGHT: 2px; PADDING-TOP: 2px; BORDER-BOTTOM: #f3f3f3 1px solid
			}
		</style>
	</head>

	<body>

		<center>
			<h3>
				所有记录
			</h3>
		</center>
		<s:form theme="simple" action="delAllBook" method="post">
			<table cellpadding="6" cellspacing="1" bgcolor="#dddddd"
				align="center" width="600">
				<tr class="td1">
					<td align="center">全/否	</td>
					<td align="center">序号</td>
					<td align="center">书号</td>
					<td align="center">书名</td>
					<td align="center">价格</td>
					<td align="center">作者</td>
					<td align="center">操作</td>
				</tr>
				<s:iterator value="#request.list" id="book" status="b">
					<tr class="td2">
						<td align="center" width="30">
							<s:checkbox name="ids" value="false" fieldValue="%{#book.id}"></s:checkbox>
						</td>
						<td align="center"><s:property value="#b.index+1"/></td>
						<td>${book.bookid}</td>
						<td>${book.bookname}</td>
						<td>${book.bookprice}</td>
						<td>${book.author}</td>
						<td align="center"><s:a href="updateBook?bookInfo.id=%{#book.id}">修改</s:a>	</td>
					</tr>
				</s:iterator>
				<tr class="td1">
					<td align="center"><s:checkbox name="chkAll" onclick="CheckAll(this.form)"></s:checkbox></td>
					<td colspan="6" align="right">
						<s:a href="index.jsp">添加</s:a> |
						<s:submit value="删除"></s:submit>
					</td>
				</tr>
			</table>			
		</s:form>
		<center><div class="page">${bookpage}</div></center>
	</body>
</html>
