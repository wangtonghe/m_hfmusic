package top.wthfeng.mhfmusic.model.view;

import top.wthfeng.mhfmusic.model.form.Music4Form;

import java.util.List;

/**
 * 歌单详情 出参
 * @author wangtonghe
 * @date 2016/4/26 22:47
 * @email wthfeng@126.com
 */
public class ViewFormDetails {
    private int id;
    private String name;
    private String cover;
    private String []label;
    private List<Music4Form> musicList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String[] getLabel() {
        return label;
    }

    public void setLabel(String[] label) {
        this.label = label;
    }

    public List<Music4Form> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music4Form> musicList) {
        this.musicList = musicList;
    }
}
