/*
@author YI Ming
*/

$(document).ready(function () {
    $.ajax({
        type:"get",
        url:"./loginoutservice/v1/userid",
        datatype:"json",
        success:function (data) {

            $("#id").val(data);
        },
    });
})

$(document).ready(function () {
    $.ajax({
        type:"get",
        url:"./loginoutservice/v0/validatelogin",
        datatype:"json",
        success:function (data) {
            $("#username").html(data);
        },
        error:function(message){
                        alert(message.responseText);
                        window.location.href="./login.html";
                    }
    });
})

$(document).ready(function () {
    var xx = $("#id").val();
    $.ajax({
         type:"get",
         url:'./cartservice/v1/'+xx+'/cart/totalprice',
         datatype:"json",
         success:function (data) {
                     $("#total").html(data);
       },
    });
})

$(document).ready(function () {
    var xx = $("#id").val();
    $.ajax({
        type:"get",
        url:'./cartservice/v1/'+xx+'/cart',
        datatype:"json",
        beforeSend:function(){
           $('#message').html('loading data...');
        },
        success:function (data) {
            if (data=="") {
                $("#message").html("No commodity.");
            }else{
            var tableView = "<table id='ff'><tr><td>Id</td><td>Name</td><td>price</td><td>quantity</td></tr>";
            for (var i=0;i<data.length;i++){
                var oneRow = "<tr>" +
                    "<td>"+data[i].id+"</td>" +
                    "<td>"+data[i].name +"</td>" +
                    "<td>"+data[i].entryPrice +"</td>" +
                    "<td>"+data[i].quantity+"</td>" +
                    "</tr>";
                tableView=tableView+oneRow;
            }
            tableView = tableView + "</table>";
            $("#wyf").append(tableView);
            $("#orderId").html(data[0].orderId);
            $("#message").html("");
            }
        },
    });
})

function pay(){
    var xx = $("#orderId").html();
           $.ajax({
            	type:"put",
            	url:'./cartservice/v1/cart/'+xx,
            	datatype:"json",
            	success:function(data){
            		alert("success");
            		window.location.href="./index.html";
         	},
     });
 }


