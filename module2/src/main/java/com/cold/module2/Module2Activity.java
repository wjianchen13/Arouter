package com.cold.module2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cold.base.Constants;
import com.cold.base.Go;

@Route(path = Constants.TEST_MODULE2)
public class Module2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);
    }

    public void onTest(View view) {
        Go.module1().navigation();
    }
}
