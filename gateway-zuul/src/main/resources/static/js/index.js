/*
@author YI Ming
*/

$(document).ready(function () {
    $.ajax({
        type:"get",
        url:"./loginoutservice/v0/validatelogin",
        datatype:"json",
        success:function (data) {
            if (data=="no"){
                $("#username").hide();
                $("#cart").hide();
            } else{
                $("#registration").hide();
                $("#login").hide();
                $("#username").html(data);
            }
        },
    });
})

$(document).ready(function () {
    $.ajax({
        type:"get",
        url:"./commodityservice/v0/commodity",
        datatype:"json",
        success:function (data) {
            var tableView = "<table align='center' id='index'>";
                        for (var i=0;i<data.length;i++){
                                    var oneRow = "<tr>" +
                                        "<td id='pic'><img src='"+data[i].imagePath+
                                        "' id='pho'></img></td>" +
                                        "<td class='info'><a href='./commodity.html?id= "+data[i].id +"'>Name:"+data[i].name+"</a></td>" +
                                        "<td class='info'>Price:"+data[i].price +"</td>" +
                                        "<td class='info'>Author:"+data[i].author +"</td>" +
                                        "</tr>";
                                    tableView=tableView+oneRow;
                        }
                        tableView = tableView + "</table>";
                        $("#information").append(tableView);

        },
    });
})