package cn.ls.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class LogoActivity extends Activity {


    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            if (msg.what == 1) {
                Intent intent = new Intent();
                intent.setClass(LogoActivity.this, MainActivity.class);

                startActivity(intent);
                LogoActivity.this.finish();
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);


        handler.sendEmptyMessageDelayed(1, 2000);
    }
}
