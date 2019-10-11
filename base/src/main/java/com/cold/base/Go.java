package com.cold.base;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;

public class Go {

    public static Postcard base() {
        return ARouter.getInstance().build(Constants.TEST_BASE);
    }

    public static Postcard module1() {
        return ARouter.getInstance().build(Constants.TEST_MODULE1);
    }

    public static Postcard module2() {
        return ARouter.getInstance().build(Constants.TEST_MODULE2);
    }
}
