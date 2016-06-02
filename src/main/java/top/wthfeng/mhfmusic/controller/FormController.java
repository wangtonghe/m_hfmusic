package top.wthfeng.mhfmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wthfeng.mhfmusic.model.param.EditFormParam;
import top.wthfeng.mhfmusic.model.param.FormListParam;
import top.wthfeng.mhfmusic.model.param.SimpleSearchMusicParam;
import top.wthfeng.mhfmusic.model.view.ViewError;
import top.wthfeng.mhfmusic.service.FormService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统歌单管理
 * @author wangtonghe
 * @date 2016/4/26 20:43
 * @email wthfeng@126.com
 */
@Controller
@RequestMapping(value = "/form")
public class FormController {

    @Resource
    private FormService formService;

    private static int   HEFENG_XIAOBIAN_DEFAULT_ID =10;

    /**
     * 歌单列表
     * @param param
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> list(FormListParam param){
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",formService.list(param));
        return result;
    }

    /**
     * 歌单上下线
     * @param flag
     * @return
     */
    @RequestMapping(value = "/online",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> online(int formId,int flag){
        Map<String,Object> result = new HashMap<>();
        formService.online(formId,flag);
        result.put("code",0);
        result.put("data",null);
        return result;
    }

    /**
     * 获取歌单详情
     * @param formId
     * @return
     */
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> details(int formId){
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",formService.details(formId));
        return result;
    }

    /**
     * 编辑歌单
     * @param param
     * @return
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> edit(EditFormParam param,String musicIds,String labelIds){
        Map<String,Object> result = new HashMap<>();
        if(param.getId()<=0){
            result.put("code",1);
            result.put("data",new ViewError("id字段非法！"));
            return result;
        }
        if(musicIds!=null&&musicIds!=""){
            param.setArrMusicIds(str2Array(musicIds));
        }
        if(labelIds!=null&&musicIds!=""){
            param.setLabels(str2Array(labelIds));
        }
        formService.edit(param);
        result.put("code",0);
        result.put("data",null);
        return result;
    }

    /**
     * 添加歌单
     * @param param
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(EditFormParam param,String musicIds,String labelIds, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        if(param.getName()==null){
            result.put("code",1);
            result.put("data",new ViewError("name为必填字段"));
            return result;
        }
        if(param.getCover()==null){
            result.put("code",1);
            result.put("data",new ViewError("cover为必填字段"));
            return result;
        }
        if(param.getInfo()==null){
            result.put("code",1);
            result.put("data",new ViewError("info为必填字段"));
            return result;
        }
//        Integer  sysUserId = ((SysUser) request.getSession().getAttribute("sysUser")).getId();
        param.setUserId(HEFENG_XIAOBIAN_DEFAULT_ID);  //固定为小编id
        if(musicIds!=null&&musicIds!=""){
            param.setArrMusicIds(str2Array(musicIds));
        }
        if(labelIds!=null&&labelIds!=""){
            param.setLabels(str2Array(labelIds));
        }
        formService.add(param);
        result.put("code",0);
        result.put("data",null);
        return result;
    }

    /**
     * 获取简要歌单列表
     * @param param
     * @return
     */
    @RequestMapping(value = "/getMusicList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object>  getMusicList(SimpleSearchMusicParam param){
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",formService.getMusicList(param));
        return result;
    }

    /**
     * 根据歌曲id数组获取歌曲
     * @param musicIds
     * @return
     */
    @RequestMapping(value = "/getMusicByIds",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getMusicByIds(String musicIds){
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",formService.getMusicByIds(str2Array(musicIds)));
        return result;

    }

    /**
     * 获取系统歌单
     * @return
     */
    @RequestMapping(value = "/getSysLabels",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSysLabels(){
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",formService.getSysLabel());
        return result;
    }


    public int[] str2Array(String str){
        String [] ids =str.split(",");
        int []array=new int[ids.length];
        for(int i=0;i<array.length;i++){
            array[i]=Integer.parseInt(ids[i]);
        }
        return array;

    }


}
