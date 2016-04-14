/**
 * Created by wangtonghe on 2016/1/18.
 */
$(function() {
    $("#login").on('click', function (e) {
        $('#loginForm').bootstrapValidator();
        var username =$("#inputUserName").val();
        var password = $("#inputPassword").val();
        $.ajax({
            url:'admin/sysUser/login',
            data:{username:username,password:password},
            type:'post',
            dataType:'json',
            success: function (data) {
                if(data.code==0){
                    document.location = "index.shtml";
                }else{
                    alert(data.data);
                }
            }
        });
    });

    $("#cancel").on("click",function(){
        $("#inputUserName").val();
        $("#inputPassword").val();
    })

});