package top.wthfeng.mhfmusic.dao;

import top.wthfeng.mhfmusic.model.param.EditFormParam;
import top.wthfeng.mhfmusic.model.param.FormListParam;
import top.wthfeng.mhfmusic.model.param.SimpleSearchMusicParam;
import top.wthfeng.mhfmusic.model.view.ViewFormDetails;
import top.wthfeng.mhfmusic.model.view.ViewFormList;
import top.wthfeng.mhfmusic.model.view.ViewSimpleMusic;

import java.util.List;
import java.util.Map;

/**
 * 歌单 DAO
 * @author wangtonghe
 * @date 2016/4/26 23:03
 * @email wthfeng@126.com
 */
public interface FormDAO {
    /**
     * 获取歌单列表
     * @param param
     * @return
     */
    List<ViewFormList> list(FormListParam param);

    /**
     * 获取符合条件下的歌单数
     * @param param
     * @return
     */
    Integer listNum(FormListParam param);




    /**
     * 歌单上下线
     * @param param
     */
    void online(Map<String,Integer> param);

    /**
     * 获取歌单详情
     * @param formId
     * @return
     */
    ViewFormDetails details(int formId);

    /**
     * 编辑歌单(歌单部分)
     * @param param
     */
    void editForm(EditFormParam param);

    /**
     * 删除某歌单的所有歌曲
     * @param formId
     */
    void delFormMusic(Integer formId);

    /**
     * 添加歌单（歌单部分）
     * @param param
     */
    void addForm(EditFormParam param);

    /**
     * 添加歌单（歌曲部分）
     * @param param
     */
    void addFormMusic(EditFormParam param);

    /**
     * 删除歌单标签
     * @param formId
     */
    void delFormLabel(Integer formId);

    /**
     * 添加歌单标签
     * @param param
     */
    void addFormLabel(EditFormParam param);

    /**
     * 获取歌单列表
     * @param param
     * @return
     */
    List<ViewSimpleMusic> getMusicList(SimpleSearchMusicParam param);

    /**
     * 获取歌单列表数目
     * @param param
     * @return
     */
    Integer getMusicListNum(SimpleSearchMusicParam param);

    /**
     *  根据歌曲id集合查询歌曲
     * @param param
     * @return
     */
    List<ViewSimpleMusic> getMusicByIds(Map<String,Object> param);


}
