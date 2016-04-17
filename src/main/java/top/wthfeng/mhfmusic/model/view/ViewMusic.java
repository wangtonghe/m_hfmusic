package top.wthfeng.mhfmusic.model.view;

/**
 * 歌曲查询出参
 * @Author : wangtonghe
 * @Date : 2016/1/21 21:51
 * @Email : wthfeng@126.com
 */
public class ViewMusic {
    private Integer id;
    private String singerName;
    private String musicName;
    private String album;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 创建人
     */
    private String creator;

    /**
     * 歌曲上下线，0为下线，1为上线
     */
    private Integer online;


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

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }
}
