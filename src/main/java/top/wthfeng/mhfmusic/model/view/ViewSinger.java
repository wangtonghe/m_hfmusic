package top.wthfeng.mhfmusic.model.view;

/**
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
    }
}
