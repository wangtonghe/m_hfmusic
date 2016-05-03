package top.wthfeng.mhfmusic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.mhfmusic.dao.SingerDAO;
import top.wthfeng.mhfmusic.model.PageUtil;
import top.wthfeng.mhfmusic.model.param.SingerEditParam;
import top.wthfeng.mhfmusic.model.param.SingerListParam;
import top.wthfeng.mhfmusic.model.view.ViewSinger;
import top.wthfeng.mhfmusic.model.view.ViewSingerName;
import top.wthfeng.mhfmusic.service.SingerService;
import top.wthfeng.mhfmusic.util.NumberUtil;

import java.util.List;
import java.util.Map;

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

    @Override
    public PageUtil<ViewSinger> list(SingerListParam param) {
        PageUtil<ViewSinger> list = new PageUtil<>();
        list.setCurrentPageNum(param.getPageNum());
        list.setList(singerDAO.list(param));
        list.setPageSize(param.getPageSize());
        list.setTotlePageNum(NumberUtil.getPageNum(singerDAO.listNum(param),param.getPageSize()));
        return list;
    }

    @Override
    public void add(SingerEditParam param) {
        singerDAO.add(param);

    }

    @Override
    public void edit(SingerEditParam param) {
        singerDAO.equals(param);

    }

    @Override
    public void active(Map<String, Integer> param) {
        singerDAO.active(param);

    }
}
