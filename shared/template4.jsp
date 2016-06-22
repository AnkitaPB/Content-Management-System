<%@page import="beans.BlurbBean"%>
<%@page import="delegate.BlurbDelegate"%>
<%@page import="beans.WebsiteBean"%>
<%@page import="beans.PageBean"%>
<html>
<head><title>Teamplate4</title>
<link href="/CMS/css/templateCss.css" rel="stylesheet" type="text/css" media=screen>
<link href="<%=request.getAttribute("cssPath")%>" rel="stylesheet" type="text/css" media=screen>
</head>
<body>
<div align="right">

 <a href="/CMS/pages/index.jsp?websiteName=<%=request.getAttribute("websiteName").toString()%>&pageName=<%=request.getAttribute("pageName").toString()%>&mode=edit">login</a></div>
 <div id="editable_header">
 <%BlurbDelegate blurbDelegate=new BlurbDelegate();
    BlurbBean blurbBean=new BlurbBean();
    blurbBean=blurbDelegate.getBlurbByPageKeyAndBlurbTypeKey(request.getAttribute("websiteName").toString(),request.getAttribute("pageName").toString(),"editable_header");
   %><%=blurbBean.getContent() %>
   </div>
   <div id="editable_middle1">
   <%blurbBean=blurbDelegate.getBlurbByPageKeyAndBlurbTypeKey(request.getAttribute("websiteName").toString(),request.getAttribute("pageName").toString(),"editable_middle1");
   %>
   <%=blurbBean.getContent() %>
   </div>

   <div id="editable_middle2">
   <%blurbBean=blurbDelegate.getBlurbByPageKeyAndBlurbTypeKey(request.getAttribute("websiteName").toString(),request.getAttribute("pageName").toString(),"editable_middle2");
   %>
   <%=blurbBean.getContent() %>
   </div>

   <div id="editable_middle3">
   <%blurbBean=blurbDelegate.getBlurbByPageKeyAndBlurbTypeKey(request.getAttribute("websiteName").toString(),request.getAttribute("pageName").toString(),"editable_middle3");
   %>
   <%=blurbBean.getContent() %>
   </div>

   <div id="editable_footer">
   <%blurbBean=blurbDelegate.getBlurbByPageKeyAndBlurbTypeKey(request.getAttribute("websiteName").toString(),request.getAttribute("pageName").toString(),"editable_footer");
   %>
   <%=blurbBean.getContent() %>
   </div>
  
   </body></html>