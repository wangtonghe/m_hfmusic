package top.wthfeng.model.param;

import top.wthfeng.model.PageParam;

/**查询歌曲入参
 * @Author : wangtonghe
 * @Date : 2016/1/21 21:45
 * @Email : wthfeng@126.com
 */
public class SearchMusicParam extends PageParam{
    private String musicName;
    private String singerName;
    private String album;


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

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }
}
