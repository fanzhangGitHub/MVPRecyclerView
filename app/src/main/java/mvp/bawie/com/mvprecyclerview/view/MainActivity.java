package mvp.bawie.com.mvprecyclerview.view;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.List;

import mvp.bawie.com.mvprecyclerview.MyAdapter.MyAdapter;
import mvp.bawie.com.mvprecyclerview.R;
import mvp.bawie.com.mvprecyclerview.bean.Bean;
import mvp.bawie.com.mvprecyclerview.presenter.MyPresenter;

public class MainActivity extends AppCompatActivity implements  MyView{

    private RecyclerView mRecyclerView;
    private  StaggeredGridLayoutManager mLayoutManager;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        recyclerInit();
    }

    private void recyclerInit() {
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
//创建默认的线性LayoutManager
        //创建布局管理器
        mLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //设置布局管理器
        //设置布局管理器
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
//如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void initViews() {
        //获得presenter对象
        MyPresenter myPresenter = new MyPresenter();
        //创建setter方法
        myPresenter.setMyView(this);
    }
//实现MyView接口剖的方法
    @Override
    public void viewSuccess(List<Bean.MyData> data) {
//        Log.e("MyData   =====     ",data+"");        //设置Item增加、移除动画


//创建并设置Adapter
        mAdapter = new MyAdapter(data,MainActivity.this);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setAdapter(mAdapter);//添加分割线
                mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                    @Override
                    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                        super.getItemOffsets(outRect, view, parent, state);
                        outRect.set(10,10,10,10);

            }
        });


            }
        });
    }

    @Override
    public void viewError(String error) {

    }
}
