/*
@author YI Ming
*/

$(document).ready(function () {
    $.ajax({
        type:"get",
        url:"./adminloginoutservice/v0/validatelogin",
        datatype:"json",
        success:function (data) {

        }
    });
})

function adminLogin() {
    $.ajax({
        type:"post",
        url:"./adminloginoutservice/v0/adminlogin",
        data:{
            username:$('#username').val(),
            password:$('#password').val(),
        },
        datatype:"json",
        success:function (data) {
            if(data=="administrator"){
                window.location.href="./admin.html";
            }else{
                alert(data);
            }
        }

    });
}