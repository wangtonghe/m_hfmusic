package top.wthfeng.mhfmusic.service.impl;

import top.wthfeng.mhfmusic.model.param.EditFormParam;
import top.wthfeng.mhfmusic.model.param.FormListParam;
import top.wthfeng.mhfmusic.model.view.ViewFormDetails;
import top.wthfeng.mhfmusic.model.view.ViewFormList;
import top.wthfeng.mhfmusic.service.FormService;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/4/26 22:54
 * @email wthfeng@126.com
 */
public class FormServiceImpl implements FormService {
    @Override
    public List<ViewFormList> list(FormListParam param) {
        return null;
    }

    @Override
    public void online(int formId, int flag) {

    }

    @Override
    public ViewFormDetails details(int formId) {
        return null;
    }

    @Override
    public void edit(EditFormParam param) {

    }

    @Override
    public void add(EditFormParam param) {

    }
}
