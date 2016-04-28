package top.wthfeng.mhfmusic.service;

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
    List<ViewSingerName> getMatchSinger(String singerName);
}
