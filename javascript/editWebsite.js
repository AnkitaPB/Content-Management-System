function openDeleteWebsitePopup(){
	
        var websiteName=document.websiteList.websiteNameTxt.value;
        var deleteWebsiteQuery='Do you want to Delete "'+websiteName+"'?" ;
   	var ans=confirm(deleteWebsiteQuery);
	if(ans)
	{
		//alert(websiteName);
                var url = '/CMS/pages/include/_deleteWebsite.jsp?websiteName='+websiteName;
	       	location.href=url;
	}
} 
function openRenameWebsitePopup(){

	
        var websiteName=document.websiteList.websiteNameTxt.value;
        //var pageName=<%=webName%>;
        //document.websiteList.websiteNameTxt.value=%=webName%>;
       // var deletePageQuery='Do you want to Delete "'+pageName+'.jsp?"' ;
   	var newWebsiteName=prompt("Enter New Website Name:",websiteName);
	if(newWebsiteName!=null)
	{
         //alert("REname  website "+ newWebsiteName+" "+websiteName);
		var url = '/CMS/pages/include/_renameWebsite.jsp?newWebsiteName='+newWebsiteName+'&oldWebsiteName='+websiteName;
		location.href=url;
 	}
} 