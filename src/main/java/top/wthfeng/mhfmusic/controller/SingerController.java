package top.wthfeng.mhfmusic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.wthfeng.mhfmusic.model.param.SingerListParam;
import top.wthfeng.mhfmusic.model.param.SingerParam;
import top.wthfeng.mhfmusic.model.view.ViewError;
import top.wthfeng.mhfmusic.service.SingerService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 歌手管理
 * @author wangtonghe
 * @date 2016/5/28 16:22
 * @email wthfeng@126.com
 */
@RestController
@RequestMapping("/singer")
public class SingerController {

    @Resource
    private SingerService singerService;

    /**
     * 按条件查询歌手
     * @param param
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Map<String,Object> list(SingerListParam param)throws Exception{
        Map<String,Object> result = new HashMap<>();

        result.put("code",0);
        result.put("data",singerService.list(param));
        return result;
    }

    /**
     * 删除歌手
     * @param singerId
     * @return
     */
    @RequestMapping(value = "/delete",method =RequestMethod.GET )
    public Map<String,Object> delete(int singerId)throws Exception{
        Map<String,Object> result = new HashMap<>();
        singerService.delete(singerId);
        result.put("code",0);
        result.put("data",null);
        return result;
    }

    /**
     * 添加歌手
     * @param param
     * @return
     */
    @RequestMapping(value = "/add",method =RequestMethod.POST)
    public Map<String,Object> add(SingerParam param)throws Exception{
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
    @RequestMapping(value = "/edit",method =RequestMethod.POST)
    public Map<String,Object> edit(SingerParam param)throws Exception{
        Map<String,Object> result = new HashMap<>();
        if(param.getSingerName()==null){
            result.put("code",1);
            result.put("data",new ViewError("歌手姓名不能为空"));
            return result;
        }
        singerService.edit(param);
        result.put("code",0);
        result.put("data",null);
        return result;
    }

}
