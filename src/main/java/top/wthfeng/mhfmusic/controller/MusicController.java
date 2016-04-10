package top.wthfeng.mhfmusic.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wthfeng.mhfmusic.model.param.EditMusicParam;
import top.wthfeng.mhfmusic.model.param.SearchMusicParam;
import top.wthfeng.mhfmusic.service.MusicService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 歌曲管理
 * @Author : wangtonghe
 * @Date : 2016/1/21 21:13
 * @Email : wthfeng@126.com
 */
@RequestMapping("/music")
@Controller
public class MusicController {

    @Resource
    private MusicService musicService;



    /**
     * 根据条件查询歌曲
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> list(SearchMusicParam param) throws  Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",musicService.list(param));
        return  result;
    }

    /**
     * 添加歌曲
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> add(EditMusicParam param)throws Exception{
        Map<String,Object> result = new HashMap<>();
        musicService.add(param);
        result.put("code",0);
        result.put("data",null);
        return result;
    }

    /**
     * 编辑歌曲
     * @param param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> edit(EditMusicParam param)throws  Exception{
        Map<String,Object> result = new HashMap<>();
        musicService.edit(param);
        result.put("code",0);
        result.put("data",null);
        return result;
    }

    /**
     * 歌曲上下线
     * @param flag 1为上线，0为下线
     * @return
     */
    @RequestMapping(value = "/online",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> online(Integer id,Byte flag)throws  Exception{
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        param.put("id",id);
        param.put("flag",flag);
        musicService.online(param);
        result.put("code",0);
        result.put("data",null);
        return result;

    }


}
