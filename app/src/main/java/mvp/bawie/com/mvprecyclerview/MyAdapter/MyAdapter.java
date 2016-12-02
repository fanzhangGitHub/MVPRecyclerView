package mvp.bawie.com.mvprecyclerview.MyAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.util.List;
import java.util.Random;

import mvp.bawie.com.mvprecyclerview.R;
import mvp.bawie.com.mvprecyclerview.bean.Bean;

/**
 * Created by ZhangFanfan on 2016/12/2.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public List<Bean.MyData>datas ;
    private Context context;
    private Random random = new Random();
    public MyAdapter(List<Bean.MyData> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = View.inflate(context,R.layout.layout_item,null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
//        viewHolder.mTextView.setText(datas[position]);
        int i = random.nextInt(50)+100;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, i);

        viewHolder.tv1.setText(datas.get(position).title);
        BitmapUtils utils = new BitmapUtils(context);
        utils.display(viewHolder.imageView,datas.get(position).pic);
//        viewHolder.tv2.setText(datas.get(position).content);

    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        private final TextView tv1;
        private final TextView tv2;
        private final ImageView imageView;

        public ViewHolder(View view){
            super(view);
            mTextView = (TextView) view.findViewById(R.id.text);
            tv1 =  (TextView) view.findViewById(R.id.tv1);
            tv2 = (TextView) view.findViewById(R.id.tv2);
            imageView = (ImageView) view.findViewById(R.id.image);
        }
    }
}
