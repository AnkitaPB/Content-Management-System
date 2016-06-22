function getBrowser()
{
	var browserName=navigator.appName; 
	if (browserName=="Microsoft Internet Explorer")
	{ 
		//window.location="uploadFileIE.jsp";
		window.open('filesUploader.jsp','image','height=450,width=460,toolbar=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,left = 250,top = 150');
	}
	else 
	{ 
 		if (browserName=="Mozilla Firefox")
		{
  			window.location="pageDisplay.jsp";
 		}
 		else
  		{
   			//window.location="filesUploader2.jsp";
			
		window.open('/CMS/pages/filesUploader2.jsp','image','height=550,width=450,toolbar=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,left = 250,top = 150');
   		}
	}
}

function displayImages()
{
	var websiteNameIndex=document.websiteCreate.websiteNameList.selectedIndex;
	var websiteName=document.websiteCreate.websiteNameList.options[websiteNameIndex].text;
	var url='images2.jsp?websiteName='+websiteName;
        location.href=url;
	//window.open(url,'image','height=450,width=460,toolbar=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,left = 250,top = 150');
}




function closeImage()
{
      location.href="/CMS/pages/websiteCreater.jsp?mode=Edit";
}