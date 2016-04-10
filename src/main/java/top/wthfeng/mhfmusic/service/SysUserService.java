package top.wthfeng.mhfmusic.service;

/**
 * 系统用户Service
 * @Author : wangtonghe
 * @Date : 2016/1/19 22:51
 * @Email : wthfeng@126.com
 */
public interface SysUserService {
    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    public String login(String username,String password);
}
