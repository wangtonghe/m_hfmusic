package top.wthfeng.mhfmusic.model.param;

import top.wthfeng.mhfmusic.model.PageParam;

/**
 * @author wangtonghe
 * @date 2016/4/26 22:14
 * @email wthfeng@126.com
 */
public class FormListParam extends PageParam{

    /**
     * 歌单名
     */
    private String formName;

    /**
     * 创建者名
     */
    private String creator;

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
