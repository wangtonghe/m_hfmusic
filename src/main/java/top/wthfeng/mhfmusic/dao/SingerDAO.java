package top.wthfeng.mhfmusic.dao;

import org.apache.ibatis.annotations.Param;
import top.wthfeng.mhfmusic.model.param.SingerEditParam;
import top.wthfeng.mhfmusic.model.param.SingerListParam;
import top.wthfeng.mhfmusic.model.view.ViewSinger;
import top.wthfeng.mhfmusic.model.view.ViewSingerName;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取歌手列表
     * @param param
     * @return
     */
    List<ViewSinger> list(SingerListParam param);

    /**
     * 获取歌手列表数目
     * @param param
     * @return
     */
    Integer listNum(SingerListParam param);

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
