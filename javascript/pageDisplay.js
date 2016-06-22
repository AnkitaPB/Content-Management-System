function redirect()
{
   
   location.href="/CMS/pages/pageCreater.jsp";
}
function openViewMySitePopup(){
    var previewSiteQuery='You do not have default home page for this site..Plz create default page.. ';
   	alert(previewSiteQuery);
   
}
function openDeletePopup(){
	
        var pageName=document.pageDisplay.pageNameTxt.value;
        var deletePageQuery='Do you want to Delete "'+pageName+'.jsp?"' ;
   	var ans=confirm(deletePageQuery);
	if(ans)
	{
	
                var url = '/CMS/pages/include/_deletePage.jsp?pageName='+pageName;
	       	location.href=url;
	}
} 
function openRenamePopup(){

	
        var pageName=document.pageDisplay.pageNameTxt.value;
        var deletePageQuery='Do you want to Delete "'+pageName+'.jsp?"' ;
   	var newPageName=prompt("Enter New Page Name:",pageName);
	if(newPageName!=null)
	{
        
	var url = '/CMS/pages/include/_renamePage.jsp?newPageName='+newPageName+'&oldPageName='+pageName;
	location.href=url;
 	}
} 