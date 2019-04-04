/*
@author YI Ming
*/

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
function editCommodity(){
    var xx = getUrlParam('id');
           $.ajax({
           	type:"put",
           	url:'./commodityservice/v1/commodity',
           	data:{
           	    id:xx,
           		name:$('#name').val(),
           		author:$('#author').val(),
           		price:$('#price').val(),
           		category:$('#category').val(),
           		publisher:$('#publisher').val(),
           		ISBN:$('#ISBN').val(),
           		language:$('#language').val(),
           		imagePath:$('#imagePath').val(),
           		visible:$('#visible').val(),

           	},
           	datatype:"json",
           	success:function(data){
           		alert("success");
        	},
    });
}

$(document).ready(function () {
    var xx = getUrlParam('id');
    $.ajax({
        type:"get",
        url:"./commodityservice/v0/commodity/"+xx,

        datatype:"json",
        success:function (data) {
            $("#name").val(data.name);
            $("#author").val(data.author);
            $("#price").val(data.price);
            $("#category").val(data.category);
            $("#publisher").val(data.publisher);
            $("#ISBN").val(data.isbn);
            $("#language").val(data.language);
            $("#imagePath").val(data.imagePath);
            $("#visible").val(data.visible);
        },
        error:function(message){
            alert(message.responseText);
            window.location.href="./login.html";
        }



    });
})

