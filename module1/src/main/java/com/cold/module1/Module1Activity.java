package com.cold.module1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cold.base.Constants;
import com.cold.base.Go;

@Route(path = Constants.TEST_MODULE1)
public class Module1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);
    }

    public void onTest(View view) {
        Go.module2().navigation();
    }
}
