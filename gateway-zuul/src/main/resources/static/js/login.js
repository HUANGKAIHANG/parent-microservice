/*
@author YI Ming
*/

function doLogin(){
       $.ajax({
       	type:"post",
       	url:'./loginoutservice/v0/login',
       	data:{
       		username:$('#username').val(),
       		password:$('#password').val(),
       		type: $("input[name='type']:checked").val(),
       	},
       	datatype:"json",
       	success:function(data){
       		if(data=="seller"){
       		    window.location.href="./seller.html";
       		}else if(data=="buyer"){
       		    window.location.href="./index.html";
       		}else{
       		    alert(data);
       		}
    		}
       });
   }

$(document).ready(function () {
       $.ajax({
           type:"get",
           url:"./loginoutservice/v0/validatelogin",
           datatype:"json",
           success:function (data) {

           }
       });
})
