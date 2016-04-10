package top.wthfeng.mhfmusic.model;

import java.util.List;

/**
 * @Author : wangtonghe
 * @Date : 2016/1/21 23:19
 * @Email : wthfeng@126.com
 */
public class PageUtil<T>{
    private List<T> list;
    private Integer currentPageNum;
    private Integer totlePageNum;
    private Integer pageSize;

    public Integer getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(Integer currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public Integer getTotlePageNum() {
        return totlePageNum;
    }

    public void setTotlePageNum(Integer totlePageNum) {
        this.totlePageNum = totlePageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
