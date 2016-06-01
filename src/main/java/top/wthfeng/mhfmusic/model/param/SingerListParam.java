package top.wthfeng.mhfmusic.model.param;

import top.wthfeng.mhfmusic.model.PageParam;

/**
 * 歌手列表参数
 * @author wangtonghe
 * @date 2016/5/28 16:24
 * @email wthfeng@126.com
 */
public class SingerListParam extends PageParam {
    private Integer singerId;
    private String singerName;
    /**
     * 0为离线，1为在线，2为全部
     */
    private Integer active;

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }
}


