package com.cold.arouter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cold.arouter.fragment.TestFragmentActivity;
import com.cold.base.Go;

import cn.cold.router.LoginNavigationCallbackImpl;

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

    /**
     * 这里有问题
     * @param view
     */
    public void onSchame(View view) {
        Intent it = new Intent();
        it.setClass(this, SchameFilterActivity.class);
        startActivity(it);
    }

    /**
     * 拦截测试
     * @param view
     */
    public void onIntercept(View view) {
        Go.base().navigation(this, new LoginNavigationCallbackImpl());
    }

    /**
     * 拦截测试
     * @param view
     */
    public void onIntercept1(View view) {
        Go.module2().navigation();
    }

    /**
     * 拦截测试
     * @param view
     */
    public void onFragment(View view) {
        startActivity(new Intent(this, TestFragmentActivity.class));
    }

}
