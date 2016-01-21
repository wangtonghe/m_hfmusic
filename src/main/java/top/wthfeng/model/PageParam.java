package top.wthfeng.model;

/**
 * @Author : wangtonghe
 * @Date : 2016/1/21 23:00
 * @Email : wthfeng@126.com
 */
public class PageParam {
    private static  Integer DEFAULTPAGE = 1;
    private static Integer DEFAULTNUM =15;
    private Integer page;
    private Integer num;
    private Integer offSet;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getOffSet() {
        page=(page==null?DEFAULTPAGE:page);
        num=(num==null?DEFAULTNUM:num);
        return (page-1)*num;

    }

    public void setOffSet(Integer offSet) {
        this.offSet = page*num;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
