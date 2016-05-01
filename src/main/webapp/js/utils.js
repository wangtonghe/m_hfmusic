/**
 * Created by wangtonghe on 2016/4/30.
 */
var pageSize = 20;
var rootUrl = "http://wthfeng.top:8080/hfuploadserver/server/upload/file";
var musicIds=new Array();
var musicNames=new Array();

//时间转化
function unix_to_datetime(unix) {
    var date = new Date(parseInt(unix)).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ");
    //return now
    return date;
}

//歌词文件上传
$(".file-upload").fileinput(
    {
        uploadUrl:rootUrl,
        language:"zh",
        allowedFileExtensions:['jpg',  'png', 'lrc','mp3','mp4'],
        showPreview:false,
        showRemove:false
    }
);






