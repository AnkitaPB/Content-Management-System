<%@page import="beans.BlurbBean"%>
<%@page import="delegate.BlurbDelegate"%>
<%@page import="beans.WebsiteBean"%>
<%@page import="beans.PageBean"%>
<html>
<head>
<title>Template 5</title>
<link href="/CMS/css/templateCss.css" rel="stylesheet" type="text/css" media=screen>
<link href="<%=request.getAttribute("cssPath")%>" rel="stylesheet" type="text/css" media=screen>
</head>
<body>
<div align="right">

 <a href="/CMS/pages/index.jsp?websiteName=<%=request.getAttribute("websiteName").toString()%>&pageName=<%=request.getAttribute("pageName").toString()%>&mode=edit">login</a></div>
 
 <div id="editable_content">
 <%BlurbDelegate blurbDelegate=new BlurbDelegate();
    BlurbBean blurbBean=new BlurbBean();
    blurbBean=blurbDelegate.getBlurbByPageKeyAndBlurbTypeKey(request.getAttribute("websiteName").toString(),request.getAttribute("pageName").toString(),"content");
   %><%=blurbBean.getContent() %>
   </div>  
   </body></html>