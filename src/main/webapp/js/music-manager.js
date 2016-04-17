/**
 * Created by wangtonghe on 2016/1/19.
 */
var pageSize =6;
$(function(){
    initData(1,pageSize); //加载歌曲数据

   /* $('#mm_online').on('shown.bs.dropdown', function (data) {
        alert(data);


    });*/

    /**
     * 搜索歌曲
     */
    $(".music-manager .searchmusic").on("click",function(){
        initData(1,pageSize);
    });

    $(".music-manager .pagination .page-num").on("click","a",function(data) {
        var curpageli = $(this).siblings(".active");
        var curpagenum = curpageli.children("a").text();
        var targetpage = $(this).children("a").text();
        if ($(this).hasClass("pre") && curpagenum > 1) {
            initData(curpagenum - 1, pageSize);
        } else if ($(this).hasClass("next")) {
            initData(curpagenum + 1, pageSize);
        } else {
        if (curpagenum != targetpage) {
            curpageli.removeClass("active");
            $(this).addClass("active");
            initData(targetpage, pageSize);
        }
      }



    });







    //弹出添加歌曲对话框
    $(".music-manager button.addmusic").on("click",function(){
        $("#add-dialog").modal({
            backdrop: true,
            keyboard: false
        });

    });

    //添加歌曲保存
    $("#add_music_save").on("click", function () {
        var musicName=$("#add_musicname").val();

    });

    //歌词文件上传
    $(".file-upload").fileinput(
        {
            uploadUrl:"http://wthfeng.top:8080/hfuploadserver/server/upload/file",
            language:"zh",
            allowedFileExtensions:['jpg',  'png', 'lrc','mp3','mp4'],
            showPreview:false,
            showRemove:false
        }
    );
    //添加歌词文件上传成功的回调函数
    $('#add_lyric').on('fileuploaded', function(event, data, previewId, index) {
        var result =data.response;
        if(result.code==0){
            $("#add_lyric_url").val(result.data.fileUrl);

        }else alert(result.data.error);
    });
    //添加歌曲文件上传成功的回调函数
    $('#add_music').on('fileuploaded', function(event, data, previewId, index) {
        var result =data.response;
        if(result.code==0){
            $("#add_music_url").val(result.data.fileUrl);

        }else alert(result.data.error);
    });
    //添加歌曲封面上传成功的回调函数
    $('#add_cover').on('fileuploaded', function(event, data, previewId, index) {
        var result =data.response;
        if(result.code==0){
            $("#add_cover_url").val(result.data.fileUrl);

        }else alert(result.data.error);
    });


    //编辑歌词文件上传成功的回调函数
    $('#e_lyric').on('fileuploaded', function(event, data, previewId, index) {
        var result =data.response;
        if(result.code==0){
            $("#e_lyric_url").val(result.data.fileUrl);

        }else alert(result.data.error);
    });
    //编辑歌曲文件上传成功的回调函数
    $('#e_music').on('fileuploaded', function(event, data, previewId, index) {
        var result =data.response;
        if(result.code==0){
            $("#e_music_url").val(result.data.fileUrl);

        }else alert(result.data.error);
    });
    //编辑歌曲封面上传成功的回调函数
    $('#e_cover').on('fileuploaded', function(event, data, previewId, index) {
        var result =data.response;
        if(result.code==0){
            $("#e_cover_url").val(result.data.fileUrl);

        }else alert(result.data.error);
    });

    //添加歌曲保存
    $("#add_music_save").on("click",function() {
        var musicName= $("#add_musicname").val();
        var singerId=$("#add_singerId").val();
        var album = $("#add_album").val();
        var lyricUrl=$("#add_lyric_url").val();
        var musicUrl =$("#add_music_url").val();
        var cover =$("#add_cover_url").val();
        $.post("admin/music/add",{musicName:musicName,musicUrl:musicUrl,singerId:singerId,album:album,lyric:lyricUrl,cover:cover},function(data){
            if(data.code==0){
                $("#add-dialog").modal("hide");
                initData();
            }
            else{
                alert("添加歌曲失败！");
            }
        },"json");
    });

    $("#add-dialog #add_singer").on("click",function(){
        $(this).siblings(".add_singer_div").show();
    });

    //上下线
    $(".music-manager ").on("click","tr .flag",function(){
        if($(this).hasClass("online")){  //要下线
            var id =$(this).siblings(":input").val();
            $.post("admin/music/online",{flag:0,id:id},function(data){
                if(data.code==0){
                    initData();
                }
                else{
                    alert("更新失败！");
                }
            },'json')
        }
        else{    //要上线
            var id =$(this).siblings(":input").val();
            $.post("admin/music/online",{flag:1,id:id},function(data){
                if(data.code==0){
                    initData();
                }
                else{
                    alert("更新失败！");
                }
            },'json')
        }
    });

    //编辑
    $(".music-body").on("click","tr .edit",function () {
        var a =$(this).siblings(" .mm_musicId").val();
        var b=$(this).siblings(" .mm_singerId").val();
        $("#e_musicId").val($(this).siblings(" .mm_musicId").val());
        $("#e_singerId").val($(this).siblings(" .mm_singerId").val());
        $("#e_musicName").val($(this).closest("tr").find("td:eq(0)").text());
        $("#e_singer").val($(this).closest("tr").find("td:eq(1)").text());
        $("#e_album").val($(this).closest("tr").find("td:eq(2)").text());

        $("#edit-dialog").modal({
            backdrop: true,
            keyboard: false
        });

    });
    //编辑歌曲中的保存
    $("#edit_music_save").on("click",function () {
        var id=$("#e_musicId").val();
        var musicName= $("#e_musicName").val();
        var singerId=$("#e_singerId").val();
        var album = $("#e_album").val();
        var lyricUrl=$("#e_lyric_url").val();
        var musicUrl =$("#e_music_url").val();
        var cover =$("#e_cover_url").val();
        $.post("admin/music/edit",{id:id,musicName:musicName,musicUrl:musicUrl,singerId:singerId,album:album,lyric:lyricUrl,cover:cover},function(data){
            if(data.code==0){
                $("#edit-dialog").modal("hide");
                initData();
            }
            else{
                alert("编辑歌曲失败！");
            }
        },"json");




    });


});
//加载数据
function initData(pageNum,pageSize){
    var musicName = $("#mm_music").val();
    var singerName =$("#mm_signer").val();
    var album = $("#mm_album").val();
    $.ajax({
        "url":"admin/music/list",
        "data":{musicName:musicName,singerName:singerName,album:album,page:pageNum,num:pageSize},
        "dataType":"json",
        "type":"POST",
        "success":function(data){
            $(".music-body").empty();
            if(data.data.list.length>0){
                var size =data.data.list.length;
                var max =size/pageSize;
                if(max>10) {
                    $("#mm_pager").find("ul li:eq(7) a").text(max);
                    $("#mm_pager").find("ul li:eq(6) a").text(max - 1);
                    $("#mm_pager").find("ul li:eq(5) a").text(max - 2);
                    $("#mm_pager").find("ul li:eq(4) a").text(max - 3);
                }
                for(var i=0;i<data.data.list.length;i++){
                    var columnData = $('<tr class="music-list"><td>'+data.data.list[i].musicName+'</td><td>'+
                        data.data.list[i].singerName+'</td><td>'+data.data.list[i].album+'</td><td>'+data.data.list[i].creator+
                        '</td><td>'+data.data.list[i].createTime+'</td><td>' +
                        '<input type="hidden" class="mm_musicId"  value="'+data.data.list[i].id+'">'+
                        '<input type="hidden" class="mm_singerId" value="'+data.data.list[i].singerId+'">'+
                        '<button class="btn btn-mini btn-primary edit' + '">编辑</button> ' +
                        ' <button class="btn btn-mini btn-danger flag online">下线</button></td></tr>');
                    $(".music-body").append(columnData);
                    if(data.data.list[i].online==0){
                        var a = $(".music-body tr:eq("+i+")  .online").removeClass("btn-danger online")
                            .addClass("btn-success offline").text("上线");
                    }

                }
            }
        },
        "error":function(data){
            alert("请求有误！"+data);
        }

    })

}
