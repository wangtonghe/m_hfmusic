package top.wthfeng.mhfmusic.dao;

import org.apache.ibatis.annotations.Param;
import top.wthfeng.mhfmusic.model.view.ViewSingerName;

import java.util.List;

/**
 * 歌手DAO
 * @author wangtonghe
 * @date 2016/4/28 16:03
 * @email wangtonghe@nggirl.com.cn
 */
public interface SingerDAO {
    /**
     * 获取匹配的歌手列表
     * @param singerName
     * @return
     */
    List<ViewSingerName> getMatchSinger(@Param(value = "singerName") String singerName);
}
