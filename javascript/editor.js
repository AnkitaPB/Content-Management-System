function AddText(form, Action){
var AddTxt="";
var txt="";
if(Action==1){  
txt=prompt("Text for the level 1 header.","Text");      
if(txt!=null)           
AddTxt="<h1>"+txt+"</h1>\r\n";  
}
if(Action==2){  
txt=prompt("Text for the level 2 header.","Text");      
if(txt!=null)           
AddTxt="<h2>"+txt+"</h2>\r\n";  
}
if(Action==3){  
txt=prompt("Text for the level 3 header.","Text");      
if(txt!=null)           
AddTxt="<h3>"+txt+"</h3>\r\n";  
}
if(Action==4) {  
txt=prompt("Text to be made BOLD.","Text");     
if(txt!=null)           
AddTxt="<b>"+txt+"</b>";        
}
if(Action==5) {  
txt=prompt("Text to be italicized","Text");     
if(txt!=null)           
AddTxt="<i>"+txt+"</i>";        
}
if(Action==6) AddTxt="\r\n<p>";
if(Action==7) AddTxt="<BR>\r\n";
if(Action==8) AddTxt="<hr>\r\n";
if(Action==9) {  
txt=prompt("URL for the link.","http://");      
if(txt!=null){          
AddTxt="<a href="+txt+">";              
txt=prompt("Text to be show for the link","Text");              
AddTxt+=txt+"</a>\r\n";         
   }
}
if(Action==10) { 
txt=prompt("URL for graphic","URL");    
if(txt!=null)           
AddTxt="<img src="+txt+">\r\n"; 
}

childForm.textEditor.value+=AddTxt;
}