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
    private String cover;
    private String musicUrl;
    private String lyric;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }
}
