package top.wthfeng.mhfmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wthfeng.mhfmusic.model.param.EditFormParam;
import top.wthfeng.mhfmusic.model.param.FormListParam;
import top.wthfeng.mhfmusic.service.FormService;

import javax.annotation.Resource;
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
    public Map<String,Object> edit(EditFormParam param,String musicIds){
        Map<String,Object> result = new HashMap<>();
        param.setMusicIds(str2Array(musicIds));
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
    public Map<String,Object> add(EditFormParam param,String musicIds){
        Map<String,Object> result = new HashMap<>();
        param.setMusicIds(str2Array(musicIds));
        formService.add(param);
        result.put("code",0);
        result.put("data",null);
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
