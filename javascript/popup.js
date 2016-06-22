$(document).ready( function() {


   $('#editable_header').addClass('pointer');
  
   $('#editable_header').click(function(){
  	openPopup('editable_header');
   });
   $('#editable_left').addClass('pointer');
  
   $('#editable_left').click(function(){
  	openPopup('editable_left');
   });
   $('#editable_right').addClass('pointer');
  
   $('#editable_right').click(function(){
  	openPopup('editable_right');
   });
   $('#editable_middle').addClass('pointer');
  
   $('#editable_middle').click(function(){
  	openPopup('editable_middle');
   });
  
   $('#editable_footer').addClass('pointer');
  
   $('#editable_footer').click(function(){
  	openPopup('editable_footer');
   });
   $('#editable_content').addClass('pointer');
  
   $('#editable_content').click(function(){
   	openPopup('editable_content');
   });
  $('#editable_middle1').addClass('pointer');
$('#editable_middle1').click(function(){
  	openPopup('editable_middle1');
   });

  $('#editable_middle2').addClass('pointer');
$('#editable_middle2').click(function(){
  	openPopup('editable_middle2');
   });


  $('#editable_middle3').addClass('pointer');
$('#editable_middle3').click(function(){
  	openPopup('editable_middle1');
   });
    
});

function openPopup(id){
                          
                           pageName=document.pageDisplay.pageNameTxt.value;
                        
                           var url = '/CMS/pages/editor.jsp?id='+id+'&pageName='+pageName;
                           child=window.open(url,'childWin','height=650,width=820,left = 350,top = 350');
			}

function setPageName(id){
                    var name=document.getElementById(id).innerHTML;
                    document.pageDisplay.pageName.value=name;
              
}
