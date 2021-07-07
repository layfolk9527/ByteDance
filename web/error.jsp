<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
     int ret=(int)request.getAttribute("errorCode");//接收数据
     String info="";
     if(ret==0){
         info="验证码正确";
     }
     else if(ret==1){
         info="用户名不存在";
     }
     else if(ret==2){
         info="密码格式错误";
     }
%>
<%=info%>
<%--输出数据  --%>

<a href="${pageContext.request.contextPath}/index.html">返回上一个界面</a>

</body>
</html>