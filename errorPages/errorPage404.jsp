<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>404 Error page</title>

<link href="/CMS/css/quinstreetCMS.css" rel="stylesheet" type="text/css" media=screen>
</head>
<body><center> <font color="red">
<br><br><br><h1><font color="red">Error 404</font><br>
</h1>


<h2><%=request.getParameter("errorMsg")%></h2>
</font>

</center>
</body>
</html>