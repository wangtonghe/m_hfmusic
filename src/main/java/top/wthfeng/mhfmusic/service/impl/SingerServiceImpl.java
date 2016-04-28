package top.wthfeng.mhfmusic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.mhfmusic.dao.SingerDAO;
import top.wthfeng.mhfmusic.model.view.ViewSingerName;
import top.wthfeng.mhfmusic.service.SingerService;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/4/28 16:04
 * @email wangtonghe@nggirl.com.cn
 */
@Service("singerService")
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerDAO singerDAO;

    @Override
    public List<ViewSingerName> getMatchSinger(String  singerName) {
        return singerDAO.getMatchSinger(singerName);
    }
}
