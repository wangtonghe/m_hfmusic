package top.wthfeng.service;

import top.wthfeng.model.PageUtil;
import top.wthfeng.model.param.EditMusicParam;
import top.wthfeng.model.param.SearchMusicParam;
import top.wthfeng.model.view.ViewMusic;

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
     * @param flag
     */
    void online(Byte flag)throws Exception;

}
