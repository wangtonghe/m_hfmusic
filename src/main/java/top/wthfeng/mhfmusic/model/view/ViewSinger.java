package top.wthfeng.mhfmusic.model.view;

/**
<<<<<<< HEAD
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
=======
 * 歌手 出参
 * @author wangtonghe
 * @date 2016/5/3 15:26
 * @email wangtonghe@nggirl.com.cn
 */
public class ViewSinger {
    private Integer id;
    private String singerName;
    private String area;
    /**
     * 歌曲数
     */
    private Integer musicNum;
    /**
     * 歌曲点赞总数
     */
    private Integer likeNum;
    /**
     * 头像
     */
    private String protrait;
    private Integer active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getMusicNum() {
        return musicNum;
    }

    public void setMusicNum(Integer musicNum) {
        this.musicNum = musicNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getProtrait() {
        return protrait;
    }

    public void setProtrait(String protrait) {
        this.protrait = protrait;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
>>>>>>> e683b10232cbf65a57d598d05769b512b08855e2
    }
}
