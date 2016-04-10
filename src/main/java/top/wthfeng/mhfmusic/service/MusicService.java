package top.wthfeng.mhfmusic.service;

import top.wthfeng.mhfmusic.model.PageUtil;
import top.wthfeng.mhfmusic.model.param.EditMusicParam;
import top.wthfeng.mhfmusic.model.param.SearchMusicParam;
import top.wthfeng.mhfmusic.model.view.ViewMusic;

import java.util.Map;

/**
 * 歌曲管理
 * @Author : wangtonghe
 * @Date : 2016/1/21 23:17
 * @Email : wthfeng@126.com
 */
public interface MusicService {
    /**
     * 根据查询条件列出歌曲
     * @param param
     * @return
     */
    PageUtil<ViewMusic> list(SearchMusicParam param)throws  Exception ;



    /**
     * 编辑歌曲
     * @param param
     */
    void edit(EditMusicParam param)throws Exception;

    /**
     * 添加歌曲
     * @param param
     */
    void add(EditMusicParam param)throws Exception;

    /**
     * 音乐上下线
     * @param param
     */
    void online(Map<String,Object> param)throws Exception;

}
