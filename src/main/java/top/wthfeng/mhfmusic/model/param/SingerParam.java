package top.wthfeng.mhfmusic.model.param;

/**
 * @author wangtonghe
 * @date 2016/5/29 13:18
 * @email wthfeng@126.com
 */
public class SingerParam {
    private int singerId;
    private String singerName;
    private int sex;
    private String portrait;
    private String info;

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
