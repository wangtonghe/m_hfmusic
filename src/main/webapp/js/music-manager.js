/**
 * Created by wangtonghe on 2016/1/19.
 */
$(function(){
    initData(); //加载歌曲数据

    /**
     * 搜索歌曲
     */
    $(".music-manager .searchmusic").on("click",function(){
        initData();
    });



    //编辑
    $(".music-body").on("click","tr .edit",function () {
        $("#edit-dialog").modal({
            backdrop: true,
            keyboard: false
        });
    });
    //编辑中的保存
    $("#edit_music_save").on("click",function () {


    });

    //添加
    $(".music-manager button.addmusic").on("click",function(){
        $("#add-dialog").modal({
            backdrop: true,
            keyboard: false
        });

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
});

function initData(){
    var musicName = $("#mm_music").val();
    var singerName =$("#mm_signer").val();
    var album = $("#mm_album").val();
    $.ajax({
        "url":"admin/music/list",
        "data":{musicName:musicName,singerName:singerName,alnum:album},
        "dataType":"json",
        "type":"POST",
        "success":function(data){
            $(".music-body").empty();
            if(data.data.list.length>0){

                for(var i=0;i<data.data.list.length;i++){
                    var columnData = $('<tr class="music-list"><td>'+data.data.list[i].musicName+'</td><td>'+
                        data.data.list[i].singerName+'</td><td>'+data.data.list[i].album+'</td><td>'+data.data.list[i].cover+
                        '</td><td>'+data.data.list[i].lyric+'</td><td>' +
                        '<input type="hidden" value="'+data.data.list[i].id+'">'+
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

function clickedit(){

}