<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>服务器搭建成功</h1>
	<a href="http://localhost:8080/PotCloud/guo">get请求1</a><br/>  
    <!-- 对于一个html页面来说，如果没有以http开始，则默认的前面会加上  
        协议类型://目前这个页面所在的服务器:目前端口/目前项目/你给的这个名称 -->  
    <a href="guo">get请求2</a><hr/>  
    <form method = "post" action="guo">  
        <input type="submit" value="提交"/>  
    </form>  
</body>
</html>