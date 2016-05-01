/**
 * @author wangtonghe
 * @date 2016/5/1 22:35
 * @email wthfeng@126.com
 */
public class MusicTet {
    public static void main(String[]args){
        int total =36;
        int size=6;
        int pageNum =total/size;
        Float f=(float)total/size;
        if(f>pageNum){
            System.out.println("pageNum = " + (pageNum+1));
        }else {
            System.out.println("pageNum = " + pageNum);
        }




    }
}
