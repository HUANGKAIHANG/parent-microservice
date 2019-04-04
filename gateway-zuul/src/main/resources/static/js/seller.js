/*
@author YI Ming
*/

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

$(document).ready(function(){
    $.ajax({
            type:"get",
            url:"./commodityservice/v1/commodity",
            datatype:"json",
            beforeSend:function(){
                $('#msg').html("loading...");
            },
            success:function (data) {
                if (data=="") {
                    $("#myCommodity").html("you don't have any commodity now.");
                }
                else{
                    var tableView = "<table id='product'><tr><td>Name</td><td>Edit</td><td>Delete</td></tr>";
                    for (var i=0;i<data.length;i++){
                        var oneRow = "<tr>" +
                                     "<td>"+data[i].name+"</td>" +
                                     "<td><button button class='btn_login' onclick="+""+
                                     "window.location.href="+""+
                                     "'./editcommodity.html?id="+data[i].id+
                                     "'>edit</button></td>" +
                                     "<td><button button class='btn_login' onclick='"+
                                     "deleteIt(this)'"+
                                     " value='"+data[i].id+
                                     "'>delete</button></td>" +
                                     "</tr>";
                        tableView=tableView+oneRow;
                    }
                    tableView = tableView + "</table>";
                    $("#myCommodity").append(tableView);
                }
                $('#msg').html("");
            },
        });
})

function deleteIt(it){
    var xx = $(it).attr("value");

       $.ajax({
           type:"put",
           url:"./commodityservice/v1/commodity/"+xx,
           datatype:"json",
           success:function (data) {
               alert("success");
               window.location.href="./seller.html";
           },
       });

}

