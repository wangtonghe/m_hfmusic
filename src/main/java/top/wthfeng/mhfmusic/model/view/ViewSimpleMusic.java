package top.wthfeng.mhfmusic.model.view;

/**
 * 歌曲简要信息
 * @author wangtonghe
 * @date 2016/4/30 23:54
 * @email wthfeng@126.com
 */
public class ViewSimpleMusic {
    private Integer musicId;
    private String musicName;
    private String singerName;
    private String album;

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
