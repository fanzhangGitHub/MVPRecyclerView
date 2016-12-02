package mvp.bawie.com.mvprecyclerview.presenter;

import com.google.gson.Gson;

import java.util.List;

import mvp.bawie.com.mvprecyclerview.bean.Bean;
import mvp.bawie.com.mvprecyclerview.modle.ModleInterFace;
import mvp.bawie.com.mvprecyclerview.modle.MyModle;
import mvp.bawie.com.mvprecyclerview.view.MainActivity;
import mvp.bawie.com.mvprecyclerview.view.MyView;

/**
 * Created by ZhangFanfan on 2016/12/2.
 */

public class MyPresenter implements ModleInterFace{
    private MyView myView;
    private MyModle myModle;


    public void setMyView(MainActivity myView) {
        this.myView = myView;
        myModle = new MyModle();
        myModle.setModle(this);
        myModle.okHttpNet();
    }

    @Override
    public void httpGet(String json) {
        Bean mBean = new Gson().fromJson(json,Bean.class);
        List<Bean.MyData>list = mBean.result.list;
//        Log.e("mBean=============",mBean+"");
        myView.viewSuccess(list);
    }
}
