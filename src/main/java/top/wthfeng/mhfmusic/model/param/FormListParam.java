package top.wthfeng.mhfmusic.model.param;

/**
 * @author wangtonghe
 * @date 2016/4/26 22:14
 * @email wthfeng@126.com
 */
public class FormListParam {
    /**
     * 页码
     */
    private int page;
    /**
     * 每页大小
     */
    private int size;
    /**
     * 歌单名
     */
    private String name;
    /**
     * 偏移量
     */
    private int offset;
    /**
     * 标签
     */
    private String label;
    /**
     * 创建时间(0为全部，1为一天内，2为1周内，3为一月内，4为一月外)
     */
    private int createTime;

    public int getPage() {
        if(page<=1){
            return 1;
        }
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        if(size<=0){
            return 20;
        }
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getOffset() {
        return (this.getPage()-1)*this.getSize();
    }


}