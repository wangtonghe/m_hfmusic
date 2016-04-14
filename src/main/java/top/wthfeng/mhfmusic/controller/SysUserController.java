package top.wthfeng.mhfmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wthfeng.mhfmusic.model.SysUser;
import top.wthfeng.mhfmusic.service.SysUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统用户controller
 * @Author : wangtonghe
 * @Date : 2016/1/19 22:40
 * @Email : wthfeng@126.com
 */
@Controller
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request,String username, String password){
        Map<String,Object> result = new HashMap<>();
        SysUser  sysUser = sysUserService.login(username,password);
        if(null==sysUser||sysUser.equals("")) {
            result.put("code", 1);
            result.put("data", "用户名或密码错误！");
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("sysUser",sysUser);
            result.put("code",0);
            result.put("data",sysUser);
        }
        return  result;
    }

}
