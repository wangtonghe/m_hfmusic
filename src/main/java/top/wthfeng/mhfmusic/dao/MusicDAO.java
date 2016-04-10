package top.wthfeng.mhfmusic.dao;

import top.wthfeng.mhfmusic.model.param.EditMusicParam;
import top.wthfeng.mhfmusic.model.param.SearchMusicParam;
import top.wthfeng.mhfmusic.model.view.ViewMusic;

import java.util.List;
import java.util.Map;

/**
 * @Author : wangtonghe
 * @Date : 2016/1/21 22:28
 * @Email : wthfeng@126.com
 */
public interface MusicDAO {
    /**
     * 根据查询条件列出歌曲
     * @param param
     * @return
     */
     List<ViewMusic> list(SearchMusicParam param) ;

    /**
     * 根据查询条件列出歌曲条数
     * @param param
     * @return
     */
    Integer listNum(SearchMusicParam param) ;

    /**
     * 编辑歌曲
     * @param param
     */
     void edit(EditMusicParam param);

    /**
     * 添加歌曲
     * @param param
     */
    void add(EditMusicParam param);

    /**
     * 音乐上下线
     * @param param
     */
    void online(Map<String,Object> param);

}
