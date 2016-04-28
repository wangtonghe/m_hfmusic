package top.wthfeng.mhfmusic.model.view;

/**
 * 歌手id和姓名出参
 * @author wangtonghe
 * @date 2016/4/28 15:58
 * @email wangtonghe@nggirl.com.cn
 */
public class ViewSingerName {
    private Integer singerId;
    private String singerName;

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
}
