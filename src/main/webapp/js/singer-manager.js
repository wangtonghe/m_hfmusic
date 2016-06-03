$(function(){
    initSinger(1,pageSize);

    //弹出添加歌曲对话框
    $(".singer-manager button.addSinger").on("click",function(){
        $("#ms_add-dialog .form-control").val('');
        $('.file-upload').fileinput('reset');
        $("#ms_add-dialog").modal({
            backdrop: true,
            keyboard: true
        });
    });

    //添加头像上传成功的回调函数
    $('#add_portrait').on('fileuploaded', function(event, data, previewId, index) {
        var result =data.response;
        if(result.code==0){
            $("#add_portrait_url").val(result.data.fileUrl);

        }else alert(result.data.error);
    });
    //编辑头像上传成功的回调函数
    $('#e_SingerPortrait').on('fileuploaded', function(event, data, previewId, index) {
        var result =data.response;
        if(result.code==0){
            $("#e_portrait_url").val(result.data.fileUrl);

        }else alert(result.data.error);
    });

    //弹出编辑歌手
    $(".msinger-body").on("click","tr .edit",function () {
        var singerId =$(this).parent("td").siblings(" .ms-id").text();  //歌手id
        var singerName=$(this).parent("td").siblings(" .ms-name").text(); //歌手名字
        var singerInfo=$(this).siblings("input").val();
     //   var singerPortrait=$(this).parent("td").siblings(".ms-img img").attr("src");
        $("#e_SingerName").val(singerName);
        $("#e_SingerId").val(singerId);
        $("#e_singerInfo").val(singerInfo);
        $("#ms_edit-dialog").modal({
            backdrop: true,
            keyboard: false
        });

    });

    //删除歌手
    $(".singer-manager ").on("click","tr .btn-danger",function(){

            var id =$(this).parent("td").siblings(":input").val();
            $.post("admin/singer/delete",{singerId:id},function(data){
                if(data.code==0){
                    initSinger(1,pageSize);
                }
                else{
                    alert("更新失败！");
                }
            },'json')
    });

    //添加歌手保存
    $("#add_singer_save").on("click",function() {
        var singerName= $("#add_singername").val();
        var sex=$("#add_singerSex").find("option:selected").val();
        var info = $("#add_info").val();
        var photoUrl=$("#add_portrait_url").val();

        $.post("admin/singer/add",{singerName:singerName,sex:sex,info:info,portrait:photoUrl},function(data){
            if(data.code==0){
                $("#ms_add-dialog").modal("hide");
                initSinger(1,pageSize);
            }
            else{
                alert("添加歌手失败！");
            }
        },"json");
    });

    //编辑歌手保存
    $("#edit_singer_save").on("click",function() {
        var singerId=$("#e_SingerId").val();
        var singerName= $("#e_SingerName").val();
        var sex=$("#e_singerSex").find("option:selected").val();
        var info = $("#e_singerInfo").val();
        var photoUrl=$("#e_portrait_url").val();

        $.post("admin/singer/edit",{singerId:singerId,singerName:singerName,sex:sex,info:info,portrait:photoUrl},function(data){
            if(data.code==0){
                $("#ms_edit-dialog").modal("hide");
                initSinger(1,pageSize);
            }
            else{
                alert("编辑歌手失败！");
            }
        },"json");
    });

    //搜索歌手
    $(".searchSinger").on("click", function () {
        initSinger(1,pageSize);

    })






});

function initSinger(pageNum,pageSize){
    var singerId=$("#ms_singerId").val();
    var singerName=$("#ms_singerName").val();
    var active=$("#ms_active").find("option:selected").val();

    $.get("admin/singer/list",{singerId:singerId,singerName:singerName,active:active,pageNum: pageNum, pageSize: pageSize}, function (data) {
        $(".msinger-body").empty();
        if(data.code==0){
            var size = data.data.list.length;
            for (var i = 0; i < size; i++) {
                var columnData = $('<tr class="singer-list"><td class="ms-id">' + data.data.list[i].singerId + '</td><td class="ms-name">' +
                    data.data.list[i].singerName + '</td><td class="ms-img"><img src="'+data.data.list[i].portrait+'" width="50px" height="50px" </td><td class="ms-num" >' + data.data.list[i].musicNum +
                    '</td><td><button class="btn btn-sm btn-primary edit' + '">编辑</button> ' +
                    ' <button class="btn btn-sm btn-danger flag">删除</button><input type="hidden" value="'+data.data.list[i].info+'"></td></tr>');
                $(".msinger-body").append(columnData);
              /*  if (data.data.list[i].active == 0) {
                    var a = $(".msinger-body tr:eq(" + i + ")  .online").removeClass("btn-danger online")
                        .addClass("btn-success offline").text("激活");
                }*/

            }
            var total =data.data.totlePageNum;
            if (total> 1) {
                $('#ms-pager .pagination .pager').twbsPagination({
                    totalPages: total,
                    visiblePages: total > 4 ? 4 : 2,
                    first:'首页',
                    prev:'上一页',
                    next:'下一页',
                    last:'尾页',
                    onPageClick: function (event, page) {
                        initSinger(page,pageSize);
                    }
                });
            }
        }
    },"json");
}