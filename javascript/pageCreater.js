     var popup;

function setText(templateName)
  {
    document.pageCreate.templateNamec.value=templateName;
  } 

      function SetValue() {

        popup = window.createPopup();
        popup.document.body.style.backgroundColor = '#778899';
      }
        function ShowPopupTemp1(){
            SetValue();
          popup.document.body.innerHTML="<img src='/CMS/images/template1.bmp' height='200'></img>";
            popup.show(400,100,200,200,document.body);

      }
      function ShowPopupTemp2() {
           SetValue();
           popup.document.body.innerHTML="<img src='/CMS/images/template2.bmp' height='200'></img>";
           popup.show(400,150,200,200,document.body);
      }
      function ShowPopupTemp3() {
           SetValue();
          popup.document.body.innerHTML="<img src='/CMS/images/template3.bmp' height='200'></img>";
             popup.show(400,200,200,200,document.body);
          }
        function ShowPopupTemp4() {
           SetValue();
          popup.document.body.innerHTML="<img src='/CMS/images/template4.bmp' height='200'></img>";
             popup.show(400,400,200,200,document.body);
        }
        function ShowPopupTemp5() {
           SetValue();
          popup.document.body.innerHTML="<img src='/CMS/images/template5.bmp' height='200'></img>";
             popup.show(400,400,200,200,document.body);
        }
     function userLogout(){

     document.pageCreate.logoutStatus.value='true';
     }
     function defaultPageOverwritePopup(){
    	 
        var defaultPageOverwriteQuery='Are you sure you want to Make this Page As Home Page' ;
   		var ans=confirm(defaultPageOverwriteQuery);
			if(ans)
				{
					document.pageCreate.defaultPageTxt.value='true';
	     		}
			else{
                                      
                                       document.pageCreate.defaultChk.checked=false;     
			}	
      }