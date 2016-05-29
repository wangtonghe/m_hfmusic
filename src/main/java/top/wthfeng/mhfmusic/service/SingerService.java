package top.wthfeng.mhfmusic.service;

import top.wthfeng.mhfmusic.model.PageUtil;
import top.wthfeng.mhfmusic.model.param.SingerEditParam;
import top.wthfeng.mhfmusic.model.param.SingerListParam;
import top.wthfeng.mhfmusic.model.param.SingerParam;
import top.wthfeng.mhfmusic.model.view.ViewSinger;
import top.wthfeng.mhfmusic.model.view.ViewSingerName;

import java.util.List;

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

    List<ViewSingerName> getMatchSinger(String singerName)throws Exception;

    /**
     * 根据条件列出歌手
     * @param param
     * @return
     */
    PageUtil<ViewSinger> list(SingerListParam param)throws Exception;

    /**
     * 删除歌手
     * @param singerId
     * @throws Exception
     */
    void delete(int singerId)throws Exception;

    /**
     * 添加歌手
     * @param param
     * @throws Exception
     */
    void add(SingerParam param)throws Exception;

    /**
     * 编辑歌手
     * @param param
     * @throws Exception
     */
    void edit(SingerParam param)throws Exception;


}
