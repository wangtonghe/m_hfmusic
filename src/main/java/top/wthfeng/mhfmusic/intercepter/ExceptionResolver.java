package top.wthfeng.mhfmusic.intercepter;

import net.sf.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理拦截
 * @author wangtonghe
 * @date 2016/4/26 18:05
 * @email wangtonghe@nggirl.com.cn
 */
public class ExceptionResolver extends SimpleMappingExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
            logger.error("未知用户操作异常:" + ex.getMessage() + ";" + request.getPathInfo());
            StringBuffer sb = new StringBuffer();

            Map<String,String[]> paramsMap = request.getParameterMap();
            if(paramsMap != null && !paramsMap.isEmpty()){
                for(String key:paramsMap.keySet()){
                    sb.append("&");
                    sb.append(key);
                    sb.append("=");
                    String [] values = paramsMap.get(key);
                    if(values != null && values.length > 0){
                        for(String v:values){
                            sb.append(v);
                        }
                    }
                }
            }
            sb.append("&exception==**==");
            sb.append(ex.getMessage());

            logger.error(sb.toString());
            try {
                Map<String,Object> result = new HashMap<String,Object>();
                result.put("code", 1);
                result.put("data", ex.getMessage());
                JSONObject jo = JSONObject.fromObject(result);
                response.setHeader("Content-Type","text/html;charset=UTF-8");
                response.getWriter().write(jo.toString());
                response.getWriter().close();
            } catch (Exception e) {
                //e.printStackTrace();
            }
            return null;

        }


}
