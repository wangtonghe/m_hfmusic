package top.wthfeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wthfeng.service.SysUserService;

import javax.annotation.Resource;
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
    public Map<String,Object> login(String username,String password){
        Map<String,Object> result = new HashMap<>();
        String realName = sysUserService.login(username,password);
        if(null==realName||realName.equals("")) {
            result.put("code", 1);
            result.put("data", "用户名或密码错误！");
        }else{
            result.put("code",0);
            result.put("data",realName);
        }
        return  result;
    }

}
