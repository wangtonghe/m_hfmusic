package top.wthfeng.mhfmusic.model.param;

import top.wthfeng.mhfmusic.model.PageParam;

/**
<<<<<<< HEAD
 * 歌手列表参数
 * @author wangtonghe
 * @date 2016/5/28 16:24
 * @email wthfeng@126.com
 */
public class SingerListParam extends PageParam{
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
=======
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
>>>>>>> e683b10232cbf65a57d598d05769b512b08855e2

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

<<<<<<< HEAD
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
=======
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
>>>>>>> e683b10232cbf65a57d598d05769b512b08855e2
    }
}
