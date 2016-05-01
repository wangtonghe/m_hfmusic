package top.wthfeng.mhfmusic.model;

/**
 * @Author : wangtonghe
 * @Date : 2016/1/21 23:00
 * @Email : wthfeng@126.com
 */
public class PageParam {
    private static  Integer DEFAULT_PAGE_NUM = 1;
    private static Integer DEFAULT_PAGE_SIZE =20;
    /**
     * 页数，从1开始
     */
    private Integer pageNum;
    /**
     * 每页大小。默认20
     */
    private Integer pageSize;
    /**
     * 偏移量
     */
    private Integer offSet;

    public Integer getPageNum() {
        if(pageNum==null||pageNum<=0){
            return DEFAULT_PAGE_NUM;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if(pageSize==null||pageSize<=0){
            return DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffSet() {
        return (this.getPageNum()-1)*this.getPageSize();
    }

    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }
}
