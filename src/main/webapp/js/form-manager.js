/**
 * Created by wangtonghe on 2016/4/30.
 */
var selected_labels=new Array();
var selected_ids=new Array();
$(function () {
    initForm(1,pageSize); //加载歌曲数据

    /**
     * 搜索歌曲
     */
    $(".form-manager .searchform").on("click",function(){
        initForm(1,pageSize);
    });

    //上下线
    $(".form-manager .table ").on("click","tr .flag",function(){
        if($(this).hasClass("online")){  //要下线
            var formId =$(this).parent().parent().find("td:eq(0)").text();
            $.post("admin/form/online",{flag:0,formId:formId},function(data){
                if(data.code==0){
                    initForm();
                }
                else{
                    alert("更新失败！");
                }
            },'json')
        }
        else{    //要上线
            var formId =$(this).parent().parent().find("td:eq(0)").text();
            $.post("admin/form/online",{flag:1,formId:formId},function(data){
                if(data.code==0){
                    initForm();
                }
                else{
                    alert("更新失败！");
                }
            },'json')
        }
    });

    //添加歌单，弹出添加页面
    $(".form-manager .addform").on("click",function(){
        $(".form-manager").hide();
        $("#form_edit").show();

    });

    //编辑歌单，弹出编辑页面
    $(".form-manager table .mform-body").on("click","tr td .edit", function () {
        $(".form-manager").hide();
        $("#form_edit").show();
        var formId=$(this).parent().parent().find("td:eq(0)").text();
        $.ajax({
            "url": "admin/form/details",
            "data": {formId:formId},
            "dataType": "json",
            "type": "GET",
            "success": function (data) {
                if(data.code==0){
                    var details=data.data;
                   $("#fe_formid").val(details.id);
                   $("#fe_formName").val(details.name);
                   $("#fe_forminfo").val(details.info);
                   $("#fe_formlabel").val(details.label);
                   $("#fe_formcover_url").val(details.cover);
                    var list=details.musicList;
                    for (var i = 0; i <list.length; i++) {
                        var columnData = $('<tr class="form-list"><td>' + list[i].musicId + '</td><td>' +
                            list[i].musicName + '</td><td>' + list[i].singerName + '</td><td>'  +
                            list[i].album +
                            '</td><td> <button class="btn">删除</button> </td></tr>');
                        $("#form_edit .emform-musicList").append(columnData);
                        musicIds.push(list[i].musicId.toString());  //将歌单歌曲id一次放入全局变量
                        musicNames.push(list[i].musicName);

                    }
                }
            }
        });

    });

    //添加编辑歌单封面上传成功的回调函数
    $('#fe_formcover').on('fileuploaded', function(event, data, previewId, index) {
        var result =data.response;
        if(result.code==0){
            $("#fe_formcover_url").val(result.data.fileUrl);

        }else alert(result.data.error);
    });


    //添加歌曲-显示歌曲列表
    $("#fe_musicAdd").on("click",function(){
        $("#form_edit").hide();
        //$(".singer-manager").hide();
        $(".form-music-select").show();

        $("#fe_formselected").val(musicNames.join(",")); //初始化已选择文本框
       getfe_musicList(1,pageSize,musicIds);

    });
    $("#fe_search").on("click",function(){
        getfe_musicList(1,pageSize,musicIds);
    });

    //选择歌曲添加到歌单
    $(".form-music-select .emform-musicList").on("click","tr .flag",function(){
        if($(this).hasClass("off")){  //要添加
            $(this).removeClass("off btn-info").addClass("added btn-danger").text("删除");
            var musicId =$(this).parent().parent().find("td:eq(0)").text();
            var musicName = $(this).parent().parent().find("td:eq(1)").text();
            musicNames.push(musicName);
            $("#fe_formselected").val(musicNames.join(","));
            musicIds.push(musicId);
        } else{    //要删除
            $(this).removeClass("added btn-danger").addClass("off btn-info").text("添加");
            var musicId =$(this).parent().parent().find("td:eq(0)").text();
            musicIds.splice(musicIds.indexOf(musicId),1); //在id数组删除
            var musicName = $(this).parent().parent().find("td:eq(1)").text();
            musicNames=$("#fe_formselected").val().split(",");
            musicNames.splice(musicNames.indexOf(musicName),1);
            $("#fe_formselected").val(musicNames.join(","));
        }
    });

    //歌单选择歌曲确定
    $("#btn-musicList").on("click",function(){
        $(".form-music-select").hide();
        $("#form_edit").show();
        getMusicByIds(musicIds);
    });
    $("#btn-musicList-cancel").on("click",function(){
        $(".form-music-select").hide();
        $("#form_edit").show();
    });

    //删除已选择的歌曲
    $("#form_edit .emform-musicList").on("click","tr td .btn",function(){
        var musicId =$(this).parent().parent().find("td:eq(0)").text();
        var musicName =$(this).parent().parent().find("td:eq(1)").text();
        musicNames.splice(musicNames.indexOf(musicName),1);
        musicIds.splice(musicIds.indexOf(musicId),1);
        getMusicByIds(musicIds);
    });



    //歌单编辑/保存 取消
    $("#btn-ef-cancel").on("click",function(){
        $("#form_edit").hide();
        $(".form-manager").show();

    });



   /* $("#form_edit .select-labels .label").on("click",function(){
     var lab=$(this);
     lab.addClass("btn-danger").removeClass("btn-primary");
     });*/

  /*  $("#form_edit .select-labels").on("click",".save",function(e){

        for(var i=0;i<selected_labels.length;i++){
            var span="<span class='margin-right'>"+selected_labels[i]+"</span>";
            $(".select-label-div").append(span);
        }
        $('[data-toggle=popover]').trigger("click");
        return false;

    });*/


    //歌单编辑保存
    $("#btn-ef-save").on("click",function(){
        var formid= $("#fe_formid").val();
        var formname= $("#fe_formName").val();
        var forminfo= $("#fe_forminfo").val();
        $("#form_edit .select-labels label").each(function(){
            var each=$(this);
            if(each.hasClass("active"))
            {
                selected_ids.push(each.find("input").val());
            }
        });
        var formlabel= selected_ids.join(",");

        var formcoverurl=$("#fe_formcover_url").val();
        console.log(musicIds.toString());
        var url="admin/form/edit";
        if(formid==""||formid<=0){
            url="admin/form/add";
            formid=0;
        }
        $.ajax({
            "url":url,
            "data": {id: formid, name: formname,cover:formcoverurl,info:forminfo,musicIds:musicIds.toString(),labels:formlabel},
            "dataType": "json",
            "type": "POST",
            "success":function(data){
                if(data.code==0){
                    $("#form_edit").hide();
                    $(".form-manager").show();
                    initForm(1,pageSize);
                }
            },
            "error":function(data){
                console.log("请求有误"+data);
            }

        });

    });

});

//加载歌单
function initForm(pageNum, pageSize) {
    var formname = $("#fm_formname").val();
    var creator = $("#fm_creator").val();
    $.ajax({
        "url": "admin/form/list",
        "data": {name: formname, creator: creator, pageNum: pageNum, pageSize: pageSize},
        "dataType": "json",
        "type": "GET",
        "success": function (data) {
            $(".mform-body").empty();
            if (data.data.list.length > 0) {
                var size = data.data.list.length;
                for (var i = 0; i < data.data.list.length; i++) {
                    var columnData = $('<tr class="form-list"><td>' + data.data.list[i].id + '</td><td>' +
                        data.data.list[i].name + '</td><td><img src="' + data.data.list[i].cover + '" width="50"/></td>'+
                        '<td>' + data.data.list[i].creator + '</td>' + '<td>' + unix_to_datetime(data.data.list[i].createTime) + '</td>' +
                        '<td>' + data.data.list[i].collectNum + '</td>' + '<td>' + data.data.list[i].online + '</td>' +
                        '<td><button class="btn btn-sm btn-primary edit' + '">编辑</button> ' +
                        ' <button class="btn btn-sm btn-danger flag online">下线</button></td></tr>');
                    $(".form-manager .mform-body").append(columnData);
                    if (data.data.list[i].online == 0) {
                        var a = $(".form-manager .mform-body tr:eq(" + i + ")  .online").removeClass("btn-danger online")
                            .addClass("btn-success offline").text("上线");
                    }
                }
            }
            var total = data.data.totlePageNum;
            if(total>1) {
                $('#mf-pager .pagination .pager').twbsPagination({
                    totalPages: total,
                    visiblePages: total > 4 ? 4 : 2,
                    first:'首页',
                    prev:'上一页',
                    next:'下一页',
                    last:'尾页',
                    onPageClick: function (event, page) {
                        initForm(page,pageSize);
                    }
                });
            }
        },
        "error": function (data) {
            alert("请求有误！" + data);
        }
    })
   // var form_type_comtent=$("<div><div class='row labels-list'></div><div class='row labels-btn'></div></div>");
   /* $.get("admin/form/getSysLabels",{},function(data){
        if(data.code!=0){
            return;
        }
        var list =data.data;
        for(var i=0;i<list.length;i++){
            var label="<div class='col-sm-4' ><span  class='form-label-text'>"+list[i].labelName+"</span><input type='hidden' value='"+list[i].labelId+"'></div>";
            form_type_comtent.find(".labels-list").append(label);
        }
        var row="<div class='col-sm-offset-2 col-sm-2'><button class='btn btn-info btn-sm save'>保存</button></div><div class='col-sm-offset-1 col-sm-2'><button class='btn btn-default btn-sm cancel'>取消</button></div>";
        form_type_comtent.find(".labels-btn").append(row);
    },"json");

    $('[data-toggle=popover]').popover({
        content:form_type_comtent,
        placement:"bottom",
        html:true,
        trigger:"click focus"
    });*/
    // 反转按钮状态
    $('#s_labels').button('reset');
}


//获取所有歌曲简要信息，用于添加、编辑歌单
function getfe_musicList (pageNum,pageSize,musicIds){
    var musicname = $("#fe_musicname").val();
    var singername = $("#fe_singername").val();
    var album = $("#fe_albumname").val();
    $.ajax({
        "url": "admin/form/getMusicList",
        "data": {musicName: musicname, singerName: singername,album:album,pageNum:pageNum,pageSize:pageSize},
        "dataType": "json",
        "type": "GET",
        "success": function (data) {
            $(".form-music-select .emform-musicList").empty();
            if (data.data.list.length > 0) {
                var size = data.data.list.length;
                for (var i = 0; i <size; i++) {
                    var columnData = $('<tr class="form-list"><td>' + data.data.list[i].musicId + '</td><td>' +
                        data.data.list[i].musicName + '</td><td>' + data.data.list[i].singerName + '</td><td>'  +
                        data.data.list[i].album +
                        '</td><td> <button class="btn btn-info flag off">添加</button> </td></tr>');
                    $(".form-music-select .emform-musicList").append(columnData);
                    if(musicIds.length>0&&musicIds.indexOf(data.data.list[i].musicId.toString())>-1){
                            $(".form-music-select .emform-musicList tr:eq(" + i + ") .btn").removeClass("btn-info off")
                                .addClass("btn-danger added").text("删除");
                    }

                }
            }
            var total = data.data.totlePageNum;
            if( total>1) {
                $('#ef-musiclist-pager .pagination .pager').twbsPagination({
                    totalPages: total,
                    visiblePages: total > 4 ? 4 : 2,
                    first:'首页',
                    prev:'上一页',
                    next:'下一页',
                    last:'尾页',
                    onPageClick: function (event, page) {
                        getfe_musicList(page,pageSize,musicIds);
                    }
                });
            }
        },
        "error": function (data) {
            alert("请求有误！" + data);
        }
    })
}

function getMusicByIds(musicIds){
   if(musicIds.length==0){
       musicIds.push(0);
   }
    $.ajax({
        "url": "admin/form/getMusicByIds",
        "data": {musicIds: musicIds.toString()},
        "dataType": "json",
        "type": "GET",
        "success": function (data) {
            $("#form_edit .emform-musicList").empty();
            if (data.data.length > 0) {
                var size = data.data.length;
                for (var i = 0; i <size; i++) {
                    var columnData = $('<tr class="form-list"><td>' + data.data[i].musicId + '</td><td>' +
                        data.data[i].musicName + '</td><td>' + data.data[i].singerName + '</td><td>'  +
                        data.data[i].album +
                        '</td><td> <button class="btn">删除</button> </td></tr>');
                    $("#form_edit .emform-musicList").append(columnData);

                }
            }
           /* var total = data.data.totlePageNum;
             if( total>1) {
             $('#ef-musiclist-pager .pagination .pager').twbsPagination({
             totalPages: total,
             visiblePages: total > 4 ? 4 : 2,
             first:'首页',
             prev:'上一页',
             next:'下一页',
             last:'尾页',
             onPageClick: function (event, page) {
             getfe_musicList(page,pageSize,musicIds);
             }
             });
             }*/
        },
        "error": function (data) {
            alert("请求有误！" + data);
        }
    })

}


