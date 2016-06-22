<%@page import="beans.BlurbBean"%>
<%@page import="delegate.BlurbDelegate"%>
<html>
<head>
<title>View Website</title>
<script src="<%=request.getAttribute("javascriptPath")%>" type="text/javascript"></script>
<link href="/CMS/css/template3.css" rel="stylesheet" type="text/css" media=screen>
<link href="<%=request.getAttribute("cssPath")%>" rel="stylesheet" type="text/css" media=screen>
</head>
<body><div align="right">
<a href="/CMS/pages/index.jsp?websiteName=<%=request.getAttribute("websiteName").toString() %>&pageName=<%=request.getAttribute("pageName").toString() %>&mode=edit">Login</a></div>
<div id="editable_header">
<%  BlurbDelegate blurbDelegate=new BlurbDelegate();
    BlurbBean blurbBean=new BlurbBean();
    blurbBean=blurbDelegate.getBlurbByPageKeyAndBlurbTypeKey(request.getAttribute("websiteName").toString(),request.getAttribute("pageName").toString(),"editable_header");%>
    <%=blurbBean.getContent() %></div>
    <div id="editable_content">
    <%blurbBean=blurbDelegate.getBlurbByPageKeyAndBlurbTypeKey(request.getAttribute("websiteName").toString(),request.getAttribute("pageName").toString(),"editable_content");%>
    <%=blurbBean.getContent() %></div>
    <div id="editable_middle">
    <%blurbBean=blurbDelegate.getBlurbByPageKeyAndBlurbTypeKey(request.getAttribute("websiteName").toString(),request.getAttribute("pageName").toString(),"editable_middle");%>
    <%=blurbBean.getContent() %></div>
   <div id="editable_footer"><%blurbBean=blurbDelegate.getBlurbByPageKeyAndBlurbTypeKey(request.getAttribute("websiteName").toString(),request.getAttribute("pageName").toString(),"editable_footer");%>
   <%=blurbBean.getContent() %></div>
</body>
</html>