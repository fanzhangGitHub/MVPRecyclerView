package mvp.bawie.com.mvprecyclerview.modle;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by ZhangFanfan on 2016/12/2.
 */

public class MyModle {
    String str;
    ModleInterFace modle;
    public void setModle(ModleInterFace modle){
        this.modle = modle;
    }

    public void okHttpNet(){

        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
        final Request request = new Request.Builder()
                .url("http://api.jisuapi.com/news/get?channel=%E5%A4%B4%E6%9D%A1&start=0&num=200&appkey=6942124f925e12cc")
                .build();
//new call
        Call call = mOkHttpClient.newCall(request);
//请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
             str = response.body().string();
              modle.httpGet(str);
//                Log.e("mBean=============",str+"");
            }
        });
    }
}
