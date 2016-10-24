package com.misakimei.Jquests.Tool;

/**
 * Created by 18754 on 2016/10/24.
 */
public final class Log {
    public static final String TAG = "=>";

    public static final void d(Object msg) {
        if (msg != null) {
            d(TAG, msg.toString());
        }
    }

    public static final void d(String TAG, Object msg) {
        println(TAG + " " + msg.toString());
    }

    private static final void println(String msg) {
        print(msg);
        print("\n");
    }

    private static final void print(String msg) {
        System.out.print(msg);
    }
}
