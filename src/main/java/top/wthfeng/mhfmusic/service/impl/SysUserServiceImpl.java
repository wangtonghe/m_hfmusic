package top.wthfeng.mhfmusic.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.mhfmusic.dao.SysUserDAO;
import top.wthfeng.mhfmusic.dao.SysUserDAO;
import top.wthfeng.mhfmusic.model.SysUser;
import top.wthfeng.mhfmusic.service.SysUserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : wangtonghe
 * @Date : 2016/1/19 23:08
 * @Email : wthfeng@126.com
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDAO sysUserDAO;

    @Override
    public SysUser  login(String username, String password) {
        Map<String,Object> param = new HashMap<>();
        param.put("username",username);
        param.put("password",password);
        return sysUserDAO.login(param);
    }
}

