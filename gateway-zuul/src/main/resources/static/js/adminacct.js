/*
@author YI Ming
*/

$.ajax({
               					type:"GET",
               					url:'./adminservice/v1/admin/account',
               					data:{

               					},
               					datatype:"json",
               					success:function(data){
               //					    alert(data);
               					    for(var i=0;i<data.length;i++){
               					        $("#id"+i).html(data[i].id);
               						    $("#author"+i).html(data[i].author);
               						    $("#name"+i).attr('src',data[i].name;
                                                 $("#price"+i).attr('src',data[i].price);

               					    }
               					}
               			});