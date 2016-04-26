package top.wthfeng.mhfmusic.model.form;

/**
 * 歌单详情里的歌曲信息
 * @author wangtonghe
 * @date 2016/4/26 22:50
 * @email wthfeng@126.com
 */
public class Music4Form {

    private int seq;
    private int musicId;
    private String musicName;
    private String singerName;
    private String album;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
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
