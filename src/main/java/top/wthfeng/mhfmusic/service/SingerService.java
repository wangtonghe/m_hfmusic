package top.wthfeng.mhfmusic.service;

import top.wthfeng.mhfmusic.model.PageUtil;
import top.wthfeng.mhfmusic.model.param.SingerEditParam;
import top.wthfeng.mhfmusic.model.param.SingerListParam;
import top.wthfeng.mhfmusic.model.view.ViewSinger;
import top.wthfeng.mhfmusic.model.view.ViewSingerName;

import java.util.List;
import java.util.Map;

/**
 * @author wangtonghe
 * @date 2016/4/28 16:03
 * @email wangtonghe@nggirl.com.cn
 */
public interface SingerService {
    /**
     * 获取匹配的歌手列表
     * @param singerName
     * @return
     */
    List<ViewSingerName> getMatchSinger(String singerName);

    /**
     * 获取歌手列表
     * @param param
     * @return
     */
    PageUtil<ViewSinger> list(SingerListParam param);

    /**
     * 添加歌手
     * @param param
     */
    void add(SingerEditParam param);

    /**
     * 编辑歌手
     * @param param
     */
    void edit(SingerEditParam param);

    /**
     * 设置歌手可见性
     * @param param
     */
    void active(Map<String,Integer> param);

}
