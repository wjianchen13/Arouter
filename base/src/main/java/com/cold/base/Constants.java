package com.cold.base;

public class Constants {

    public static boolean isLogin = false;

    public static final int TEST_EXTRA_LOGIN = 1;

    public static boolean isNeedLogin(int extra) {
        return (extra & 1) >> 0 > 0;
    }

    /**
     * base
     */
    public static final String TEST_BASE = "/base/activity/test";


    /**
     * module1
     */
    public static final String TEST_MODULE1 = "/module1/activity/test";


    /**
     * module2
     */
    public static final String TEST_MODULE2 = "/module2/activity/test";

    /**
     * login
     */
    public static final String TEST_LOGIN = "/app/activity/login";

}
