<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
houhouhouhou55
<img src="${pageContext.request.contextPath}/code" />44444444444444

<br><br><br><br><br><br><br>
<form method="POST" enctype="multipart/form-data"
	action="${pageContext.request.contextPath}/upload">
	File to upload: <input type="file" name="file"><br /> Name: <input
		type="text" name="name"><br /> <br /> <input type="submit"
		value="Upload"> Press here to upload the file!
</form>
</body>
</html>