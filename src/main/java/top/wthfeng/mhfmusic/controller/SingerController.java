package top.wthfeng.mhfmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wthfeng.mhfmusic.model.param.SingerEditParam;
import top.wthfeng.mhfmusic.model.param.SingerListParam;
import top.wthfeng.mhfmusic.model.view.ViewError;
import top.wthfeng.mhfmusic.service.SingerService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 歌手管理
 * @author wangtonghe
 * @date 2016/5/3 15:20
 * @email wangtonghe@nggirl.com.cn
 */
@Controller
@RequestMapping("/singer")
public class SingerController {

    @Resource
    private SingerService singerService;

    /**
     * 获取歌手列表
     * @param param
     * @return
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Map<String,Object> list(SingerListParam param){
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",singerService.list(param));
        return result;

    }

    /**
     * 添加歌手
     * @param param
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Map<String,Object> add(SingerEditParam param){
        Map<String,Object> result = new HashMap<>();
        singerService.add(param);
        result.put("code",0);
        result.put("data",null);
        return result;
    }

    /**
     * 编辑歌手
     * @param param
     * @return
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public Map<String,Object> edit(SingerEditParam param){
        Map<String,Object> result = new HashMap<>();
        if(param.getId()==null){
            result.put("code",1);
            result.put("data",new ViewError("id不能为空"));
            return result;
        }
        singerService.edit(param);
        result.put("code",0);
        result.put("data",null);
        return result;

    }

    /**
     * 设置歌手可见性
     * @param id
     * @param flag
     * @return
     */
    @RequestMapping(value = "/active")
    @ResponseBody
    public Map<String,Object> active(Integer id,Integer flag){
        Map<String,Object> result = new HashMap<>();
        if(id==null||id<=0){
            result.put("code",1);
            result.put("data",new ViewError("id不能为空"));
            return result;
        }
        if(flag==null||(flag!=0&&flag!=1)){
            result.put("code",1);
            result.put("data",new ViewError("flag字段为空或非法"));
            return result;
        }
        Map<String,Integer> param = new HashMap<>();
        param.put("id",id);
        param.put("flag",flag);
        singerService.active(param);
        result.put("code",0);
        result.put("data",null);
        return result;

    }
}
