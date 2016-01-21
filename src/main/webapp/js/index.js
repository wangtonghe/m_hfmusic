/**
 * Created by wangtonghe on 2016/1/16.
 * 管理后台管理页面
 */
$(function(){

    $(".sidebar .nav-sidebar li a").eq(0).addClass("active");

    //初始化页面
    $(".sidebar .nav-sidebar li a ").each(function () {
        if($(this).hasClass("active")){
            var choice=$(this).parent().attr("class");
            $(".container-fluid .main > div").each(function(){
                if($(this).hasClass(choice)){
                    $(this).show().siblings().hide();
                }
            })
        }
    });


    //单击左侧菜单，显示对应页面
    $(".sidebar .nav-sidebar li a ").on('click',function(){
        $(this).addClass("active").siblings().removeClass("active");
        var choice=$(this).parent().attr("class");
        $(".container-fluid .main > div").each(function(){
            if($(this).hasClass(choice)){
                $(this).show().siblings().hide();
            }
        })

    });


})