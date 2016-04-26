package top.wthfeng.mhfmusic.service;

import top.wthfeng.mhfmusic.model.param.EditFormParam;
import top.wthfeng.mhfmusic.model.param.FormListParam;
import top.wthfeng.mhfmusic.model.view.ViewFormDetails;
import top.wthfeng.mhfmusic.model.view.ViewFormList;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/4/26 22:53
 * @email wthfeng@126.com
 */
public interface FormService {

    /**
     * 获取歌单列表
     * @param param
     * @return
     */
     List<ViewFormList> list(FormListParam param);

    /**
     * 歌单上下线
     * @param formId
     * @param flag
     */
    void online(int formId,int flag);

    /**
     * 获取歌单详情
     * @param formId
     * @return
     */
    ViewFormDetails details(int formId);

    /**
     * 编辑歌单
     * @param param
     */
    void edit(EditFormParam param);

    /**
     * 添加歌单
     * @param param
     */
    void add(EditFormParam param);


}
