package top.wthfeng.mhfmusic.model.param;

/**
 * 添加、编辑歌曲入参
 * @Author : wangtonghe
 * @Date : 2016/1/21 22:01
 * @Email : wthfeng@126.com
 */
public class EditMusicParam {
    private Integer id;
    private String musicName;
    private String musicUrl;
    private String lyric;
    private String cover;
    private Integer singerId;
    private String album;
    private boolean online;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}
