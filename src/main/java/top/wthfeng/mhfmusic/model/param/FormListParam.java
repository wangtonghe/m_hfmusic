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

    public int getOffset() {
        return (this.getPage()-1)*this.getSize();
    }


}
