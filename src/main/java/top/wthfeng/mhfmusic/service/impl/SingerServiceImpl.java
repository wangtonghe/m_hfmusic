package top.wthfeng.mhfmusic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.mhfmusic.dao.SingerDAO;
import top.wthfeng.mhfmusic.model.PageUtil;
import top.wthfeng.mhfmusic.model.param.SingerListParam;
import top.wthfeng.mhfmusic.model.param.SingerParam;
import top.wthfeng.mhfmusic.model.view.ViewSinger;
import top.wthfeng.mhfmusic.model.view.ViewSingerName;
import top.wthfeng.mhfmusic.service.SingerService;
import top.wthfeng.mhfmusic.util.NumberUtil;

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
    public List<ViewSingerName> getMatchSinger(String  singerName)throws Exception {
        return singerDAO.getMatchSinger(singerName);
    }

    @Override
    public PageUtil<ViewSinger> list(SingerListParam param)throws Exception {
        PageUtil pageUtil = new PageUtil();
        pageUtil.setList(singerDAO.list(param));
        pageUtil.setTotlePageNum(NumberUtil.getPageNum(singerDAO.listNum(param), param.getPageSize()));
         return pageUtil;

    }

    @Override
    public void delete(int singerId) throws Exception {
        singerDAO.delete(singerId);

    }

    @Override
    public void add(SingerParam param) throws Exception {
        singerDAO.add(param);
    }

    @Override
    public void edit(SingerParam param) throws Exception {
        singerDAO.edit(param);

    }
}
