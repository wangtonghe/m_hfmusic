package top.wthfeng.util;

import net.sf.json.JSONObject;

import java.util.Map;

/**
 * @Author : wangtonghe
 * @Date : 2016/1/19 22:07
 * @Email : wthfeng@126.com
 */
public class StringUtil {
    public  static String map2json(Map map ){
        return JSONObject.fromObject(map).toString();
    }
}
