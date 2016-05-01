package top.wthfeng.mhfmusic.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.mhfmusic.dao.MusicDAO;
import top.wthfeng.mhfmusic.model.PageUtil;
import top.wthfeng.mhfmusic.model.SysUser;
import top.wthfeng.mhfmusic.model.param.EditMusicParam;
import top.wthfeng.mhfmusic.model.param.SearchMusicParam;
import top.wthfeng.mhfmusic.model.view.ViewMusic;
import top.wthfeng.mhfmusic.service.MusicService;
import top.wthfeng.mhfmusic.util.NumberUtil;

import java.util.List;
import java.util.Map;

/**
 * @Author : wangtonghe
 * @Date : 2016/1/21 23:28
 * @Email : wthfeng@126.com
 */
@Service("musicService")
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicDAO musicDAO;

    @Override
    public PageUtil<ViewMusic> list(SearchMusicParam param) throws Exception{
        List<ViewMusic> list = musicDAO.list(param);
        PageUtil<ViewMusic> listData = new PageUtil<>();
        listData.setPageSize(param.getPageSize());
        listData.setList(list);
        listData.setCurrentPageNum(param.getPageNum());
        listData.setTotlePageNum(NumberUtil.getPageNum(musicDAO.listNum(param), param.getPageSize()));
        return listData;
    }

    @Override
    public void edit(EditMusicParam param) throws Exception{
        musicDAO.edit(param);
    }

    @Override
    public void add(EditMusicParam param) throws Exception{
        musicDAO.add(param);
    }

    @Override
    public void online(Map<String,Object> param)throws Exception {
        musicDAO.online(param);

    }



}
