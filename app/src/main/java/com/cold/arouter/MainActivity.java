package com.cold.arouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cold.base.Go;

//import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ARouter.getInstance().build("/main/mainActivityTest").navigation()
    }

    public void onBase(View view) {
        Go.base().navigation();
    }
}
