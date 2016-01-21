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
                    localStorage.setItem('mhf_accesstoken',data.data.accessToken);
                    alert("登陆成功！");

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