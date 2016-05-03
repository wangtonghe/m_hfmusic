package top.wthfeng.mhfmusic.model.param;

import top.wthfeng.mhfmusic.model.PageParam;

/**
 * @author wangtonghe
 * @date 2016/5/3 15:31
 * @email wangtonghe@nggirl.com.cn
 */
public class SingerListParam extends PageParam{
    /**
     * 歌手名称
     */
    private String singerName;
    /**
     * 地区
     */
    private String area;

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
