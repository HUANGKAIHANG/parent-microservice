/*
@author YI Ming
*/

$(document).ready(function () {
    $.ajax({
        type:"get",
        url:"./adminservice/v1/admin/account",
        datatype:"json",
        beforeSend:function(){
            $('#message').html('loading data...');
        },
        success:function (data) {
            if (data=="") {
                $("#message").html("No account.");
            }else{
            var tableView = "<table id='product'><tr><td>Id</td><td>Username</td></tr>";
            for (var i=0;i<data.length;i++){
                var oneRow = "<tr>" +
                    "<td>"+data[i].id+"</td>" +
                    "<td>"+data[i].username +"</td>" +
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