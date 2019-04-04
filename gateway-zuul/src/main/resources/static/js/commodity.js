/*
@author YI Ming
*/

function getUrlParam(name) {
var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
var r = window.location.search.substr(1).match(reg);  //匹配目标参数
if (r != null) return unescape(r[2]); return null; //返回参数值
}
$(document).ready(function () {
    var xx = getUrlParam('id');

    $.ajax({
        type:"get",
        url:"./commodityservice/v0/commodity/"+xx,
        datatype:"json",
        success:function (data) {
            $("#img").attr("src",data.imagePath);
            $("#id").val(data.id);
            $("#name").html(data.name);
            $("#author").html(data.author);
            $("#price").html(data.price);
            $("#category").html(data.category);
            $("#publisher").html(data.publisher);
            $("#ISBN").html(data.isbn);
            $("#language").html(data.language);
        }
    });
})

function buy(){
    var xx = getUrlParam('id');
           $.ajax({
           	type:"POST",
           	url:'./cartservice/v1/cart/',
           	data:{
           	    commodityId:xx,
           	},
           	datatype:"json",
           	success:function(data){
           		alert("success");
        	},
        	error:function(message){
                alert(message.responseText);
                window.location.href="./login.html";
           }
    });
}
