/*
@author YI Ming
*/

function addCommodity() {
    var formData = new FormData();
    formData.append('image', $('#image')[0].files[0]);
    formData.append("name",$('#name').val());
    formData.append("author",$('#author').val());
    formData.append("price",$('#price').val());
    formData.append("publisher",$('#publisher').val());
    formData.append("ISBN",$('#ISBN').val());
    formData.append("category",$('#category').val());
    formData.append("language",$('#language').val());
    $.ajax({
        type:"post",
        url:"./commodityservice/v1/commodity",
        data: formData,
        datatype:"json",
        cache: false,
        contentType: false,
        processData: false,
        success:function (data) {
           alert(data);
        },
        error:function(message){
           alert(message.responseText);
           window.location.href="./login.html";
        }
    });
}