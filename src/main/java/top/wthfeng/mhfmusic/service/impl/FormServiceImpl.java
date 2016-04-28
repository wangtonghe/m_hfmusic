package top.wthfeng.mhfmusic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.mhfmusic.dao.FormDAO;
import top.wthfeng.mhfmusic.model.param.EditFormParam;
import top.wthfeng.mhfmusic.model.param.FormListParam;
import top.wthfeng.mhfmusic.model.view.ViewFormDetails;
import top.wthfeng.mhfmusic.model.view.ViewFormList;
import top.wthfeng.mhfmusic.service.FormService;

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
    public List<ViewFormList> list(FormListParam param) {
        return formDAO.list(param);
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
        formDAO.delFormMusic(param.getId());
        formDAO.addFormMusic(param);
        formDAO.delFormLabel(param.getId());
        formDAO.addFormLabel(param);

    }

    @Override
    public void add(EditFormParam param) {
        formDAO.addForm(param);
        formDAO.delFormMusic(param.getId());
        formDAO.addFormMusic(param);
        formDAO.delFormLabel(param.getId());
        formDAO.addFormLabel(param);

    }
}
