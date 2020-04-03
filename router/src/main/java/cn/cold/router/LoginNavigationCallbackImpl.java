package cn.cold.router;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.cold.base.Go;

// 拦截的回调
public class LoginNavigationCallbackImpl  implements NavigationCallback {
    @Override //找到了
    public void onFound(Postcard postcard) {
        System.out.println("===============> LoginNavigationCallbackImpl onFound");
    }

    @Override //找不到了
    public void onLost(Postcard postcard) {
        System.out.println("===============> LoginNavigationCallbackImpl onLost");
    }

    @Override    //跳转成功了
    public void onArrival(Postcard postcard) {
        System.out.println("===============> LoginNavigationCallbackImpl onArrival");
    }

    @Override
    public void onInterrupt(Postcard postcard) {
        System.out.println("===============> LoginNavigationCallbackImpl onInterrupt");
        String path = postcard.getPath();

        Bundle bundle = postcard.getExtras();
        // 被登录拦截了下来了
        // 需要调转到登录页面，把参数跟被登录拦截下来的路径传递给登录页面，登录成功后再进行跳转被拦截的页面
        Go.login()
                .with(bundle)
//                .withString(ConfigConstants.PATH, path)
                .navigation();
    }
}