package top.wthfeng.mhfmusic.model.param;

import top.wthfeng.mhfmusic.model.PageParam;

/**
 * @author wangtonghe
 * @date 2016/4/30 23:59
 * @email wthfeng@126.com
 */
public class SimpleSearchMusicParam extends PageParam{
    private String musicName;
    private String singerName;
    private String album;

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
