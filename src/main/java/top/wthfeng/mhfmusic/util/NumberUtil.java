package top.wthfeng.mhfmusic.util;

/**
 * @author wangtonghe
 * @date 2016/5/1 22:51
 * @email wthfeng@126.com
 */
public class NumberUtil {
    public static int getPageNum(int total,int size) {
        int pageNum = total / size;
        Float f = (float) total / size;
        if (f > pageNum) {
            pageNum+=1;
        }
        return  pageNum;
    }
}
