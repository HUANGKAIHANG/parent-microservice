/*
@author YI Ming
*/

function doRegistration(){
    $.ajax({
    	type:"post",
    	url:'./registrationservice/v0/account',
    	data:{
    		username:$('#username').val(),
    		password:$('#password').val(),
    		type: $("input[name='type']:checked").val(),
    	},
    	datatype:"json",
    	success:function(data){
    		if(data=="success"){
    		    window.location.href="./login.html";
    		}else{
    		    alert("The username is exist");
    		}
 		}
    });
}