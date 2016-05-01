package top.wthfeng.mhfmusic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.mhfmusic.dao.FormDAO;
import top.wthfeng.mhfmusic.model.PageUtil;
import top.wthfeng.mhfmusic.model.param.EditFormParam;
import top.wthfeng.mhfmusic.model.param.FormListParam;
import top.wthfeng.mhfmusic.model.param.SimpleSearchMusicParam;
import top.wthfeng.mhfmusic.model.view.ViewFormDetails;
import top.wthfeng.mhfmusic.model.view.ViewFormList;
import top.wthfeng.mhfmusic.model.view.ViewSimpleMusic;
import top.wthfeng.mhfmusic.service.FormService;
import top.wthfeng.mhfmusic.util.NumberUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangtonghe
 * @date 2016/4/26 22:54
 * @email wthfeng@126.com
 */
@Service("formService")
public class FormServiceImpl implements FormService {

    @Autowired
    private FormDAO formDAO;

    @Override
    public PageUtil<ViewSimpleMusic>  getMusicList(SimpleSearchMusicParam param) {
        PageUtil<ViewSimpleMusic> listData = new PageUtil<>();
        listData.setList(formDAO.getMusicList(param));
        listData.setCurrentPageNum(param.getPageNum());
        listData.setPageSize(param.getPageSize());
        float totalNum=formDAO.getMusicListNum(param);
        int pageNum = Math.round(totalNum/param.getPageSize()+0.5f);
        listData.setTotlePageNum(pageNum);
        return listData;
    }

    @Override
    public List<ViewSimpleMusic> getMusicByIds(int[] musicIds) {
        Map<String,Object> param = new HashMap<>();
        param.put("musicIds",musicIds);
        return formDAO.getMusicByIds(param);
    }

    @Override
    public PageUtil<ViewFormList> list(FormListParam param) {
        List<ViewFormList> list = formDAO.list(param);
        PageUtil<ViewFormList> listData = new PageUtil<>();
        listData.setList(list);
        listData.setCurrentPageNum(param.getPageNum());
        listData.setPageSize(param.getPageSize());
        listData.setTotlePageNum(NumberUtil.getPageNum(formDAO.listNum(param),param.getPageSize()));
        return listData;
    }

    @Override
    public void online(int formId, int flag) {
        Map<String,Integer> param = new HashMap<>();
        param.put("formId",formId);
        param.put("flag",flag);
        formDAO.online(param);

    }

    @Override
    public ViewFormDetails details(int formId) {
        return formDAO.details(formId);
    }

    @Override
    public void edit(EditFormParam param) {
        formDAO.editForm(param);
        if(param.getArrMusicIds()!=null){ //非空则重新添加，为空表示无变化
            formDAO.delFormMusic(param.getId());
            formDAO.addFormMusic(param);
        }
        if(param.getArrLabels()!=null){
            formDAO.delFormLabel(param.getId());
            formDAO.addFormLabel(param);
        }



    }

    @Override
    public void add(EditFormParam param) {
        formDAO.addForm(param);
        if(param.getArrMusicIds()!=null){  //非空则重新添加，为空表示无变化
            formDAO.delFormMusic(param.getId());
            formDAO.addFormMusic(param);
        }
        if(param.getArrLabels()!=null){
            formDAO.delFormLabel(param.getId());
            formDAO.addFormLabel(param);
        }


    }
}
