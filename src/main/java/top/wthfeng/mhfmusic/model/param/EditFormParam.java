package top.wthfeng.mhfmusic.model.param;

import java.util.Date;

/**
 * 编辑、添加歌单入参
 * @author wangtonghe
 * @date 2016/4/26 22:39
 * @email wthfeng@126.com
 */
public class EditFormParam {
    private int id;
    private String name;
    private String cover;
    private String[] arrLabels;
    private String info;
    private Date createTime;
    private Integer userId;
    /**
     * 歌曲id集合
     */
    private int []arrMusicIds;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }



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



    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String[] getArrLabels() {
        return arrLabels;
    }

    public void setArrLabels(String[] arrLabels) {
        this.arrLabels = arrLabels;
    }

    public int[] getArrMusicIds() {
        return arrMusicIds;
    }

    public void setArrMusicIds(int[] arrMusicIds) {
        this.arrMusicIds = arrMusicIds;
    }
}
