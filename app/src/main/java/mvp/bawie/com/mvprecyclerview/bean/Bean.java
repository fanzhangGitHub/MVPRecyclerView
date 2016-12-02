package mvp.bawie.com.mvprecyclerview.bean;

import java.util.List;

/**
 * Created by ZhangFanfan on 2016/12/2.
 */

public class Bean {
    public MyResult result;
    public class MyResult{
        public List<MyData>list;
    }
public class MyData{
    public String content;
    public String pic;
    public String title;
    public String weburl;
}
}
