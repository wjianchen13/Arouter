package cn.cold.router;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.cold.base.Constants;
import com.cold.base.Go;

// 比较经典的应用就是在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
// 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行,值越小优先级越高，会优先拦截
@Interceptor(name = "login", priority = 6)
public class LoginInterceptorImpl implements IInterceptor {

    private Context mContext;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();
        boolean isLogin = Constants.isLogin;

        // 需要登录
        if (Constants.isNeedLogin(postcard.getExtra())) {

            if (!isLogin) {
                if (postcard.getType() == RouteType.ACTIVITY) {

                    Go.login()
                            .with(postcard.getExtras())
                            .withString("param_skip_path", postcard.getPath())
                            .navigation();

                    callback.onInterrupt(null);

                    return;
                }
            }

        }
        callback.onContinue(postcard);

//        if (isLogin) { // 如果已经登录不拦截
//            callback.onContinue(postcard);
//        } else {  // 如果没有登录
//            switch (path) {
//                // 不需要登录的直接进入这个页面
//                case Constants.TEST_LOGIN:
//                    callback.onContinue(postcard);
//                    break;
//                default:
//                    callback.onInterrupt(null);
//                    // 需要登录的直接拦截下来
//                    break;
//            }
//        }

    }

    @Override
    public void init(Context context) {
        System.out.println("路由登录拦截器初始化成功"); //只会走一次
        this.mContext = context;
    }

}