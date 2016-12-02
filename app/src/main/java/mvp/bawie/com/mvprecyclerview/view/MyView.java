package mvp.bawie.com.mvprecyclerview.view;

import java.util.List;

import mvp.bawie.com.mvprecyclerview.bean.Bean;

/**
 * Created by ZhangFanfan on 2016/12/2.
 */

public interface MyView {
    void viewSuccess(List<Bean.MyData> data);
    void viewError(String error);
}
