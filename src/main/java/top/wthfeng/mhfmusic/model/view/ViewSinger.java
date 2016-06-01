package top.wthfeng.mhfmusic.model.view;

/**
 * 歌手列表 出参
 * @author wangtonghe
 * @date 2016/5/28 16:31
 * @email wthfeng@126.com
 */
public class ViewSinger {
    private int singerId;
    private String singerName;
    private int sex;
    private int musicNum;
    private String portrait;
    private String info;
    private int active;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

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

    public int getMusicNum() {
        return musicNum;
    }

    public void setMusicNum(int musicNum) {
        this.musicNum = musicNum;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }


}
