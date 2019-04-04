/*
@author YI Ming
*/

$(document).ready(function () {
    $.ajax({
        type:"get",
        url:"./adminservice/v1/admin/commodity",
        datatype:"json",
        beforeSend:function(){
           $('#message').html('loading data...');
        },
        success:function (data) {
            if (data=="") {
                $("#message").html("No commodity.");
            }else{
            var tableView = "<table id='product'><tr><td>Id</td><td>Name</td><td>author</td><td>price</td><td>publisher</td></tr>";
            for (var i=0;i<data.length;i++){
                var oneRow = "<tr>" +
                    "<td>"+data[i].id+"</td>" +
                    "<td>"+data[i].name +"</td>" +
                    "<td>"+data[i].author +"</td>" +
                    "<td>"+data[i].price +"</td>" +
                    "<td>"+data[i].publisher +"</td>" +
                    "</tr>";
                tableView=tableView+oneRow;
            }
            tableView = tableView + "</table>";
            $("#info").append(tableView);
            $("#message").html("");
            }
        },
        error:function(message){
           alert(message.responseText);
           window.location.href="./adminlogin.html";
        }
    });
})