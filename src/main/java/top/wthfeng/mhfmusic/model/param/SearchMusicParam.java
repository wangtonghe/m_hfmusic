package top.wthfeng.mhfmusic.model.param;

import top.wthfeng.mhfmusic.model.PageParam;

/**查询歌曲入参
 * @Author : wangtonghe
 * @Date : 2016/1/21 21:45
 * @Email : wthfeng@126.com
 */
public class SearchMusicParam extends PageParam {
    private String musicName;
    private String singerName;
    private String album;
    /**
     * 上线状态，离线为0，在线为1，全部为2
     */
    private Integer status;


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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
