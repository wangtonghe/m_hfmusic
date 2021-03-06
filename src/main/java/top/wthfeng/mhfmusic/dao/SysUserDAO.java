package top.wthfeng.mhfmusic.dao;

import top.wthfeng.mhfmusic.model.SysUser;

import java.util.Map;

/**
 * 系统用户
 * @Author : wangtonghe
 * @Date : 2016/1/19 22:57
 * @Email : wthfeng@126.com
 */
public interface SysUserDAO {
    /**
     * 系统用户登录
     * @param param
     * @return
     */
    SysUser login(Map<String,Object> param);
}

