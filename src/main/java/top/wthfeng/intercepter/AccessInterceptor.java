package top.wthfeng.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.wthfeng.model.SysUser;
import top.wthfeng.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 访问验证
 * @Author : wangtonghe
 * @Date : 2016/1/19 21:52
 * @Email : wthfeng@126.com
 */
public class AccessInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        SysUser sysUser =(SysUser) httpServletRequest.getSession().getAttribute("sysUser");
       boolean flag = false;
        if(sysUser==null){
           Map<String, Object> result = new HashMap<>();
            result.put("code",1);
            result.put("data","请重新登陆！");
            httpServletResponse.getWriter().write(StringUtil.map2json(result));
            httpServletResponse.getWriter().close();
            flag=false;
        }else {
            flag=true;
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
