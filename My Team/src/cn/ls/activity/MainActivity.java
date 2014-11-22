package cn.ls.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import cn.ls.view.PageWidget;
import cn.ls.view.PageWidgetAdapter;

public class MainActivity extends Activity {

    private RelativeLayout root;
    private ArrayList<String> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        //	setContentView(root);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
//		init();
        setContentView(root);
    }

    private void init() {
        list = new ArrayList<String>();
        list.add("0.png");
        list.add("1.png");
        list.add("2.png");
        list.add("3.png");
        list.add("4.png");
        list.add("5.png");
        list.add("6.png");
        list.add("7.png");
        list.add("8.png");
        list.add("9.png");
        list.add("10.png");
        list.add("11.png");
        list.add("12.png");
        list.add("13.png");
        list.add("14.png");
        list.add("15.png");
        list.add("16.png");
        list.add("17.png");
        // TODO Auto-generated method stub
        root = new RelativeLayout(this);
        RelativeLayout.LayoutParams pageParams = new RelativeLayout.LayoutParams(
                -1, -1);
        root.setLayoutParams(pageParams);
        PageWidgetAdapter adapter = new PageWidgetAdapter(this, list);

        // PageWidget
        PageWidget pageWidget = new PageWidget(this);
        pageWidget.setFocusable(true);
        pageWidget.setId(1);
        pageWidget.setAdapter(adapter);

        root.addView(pageWidget, pageParams);
        System.out.println("success!!");
    }

}
