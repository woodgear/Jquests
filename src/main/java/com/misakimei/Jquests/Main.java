package com.misakimei.Jquests;


import com.misakimei.Jquests.Tool.Log;
import com.misakimei.Jquests.Tool.Tool;

/**
 * Created by 18754 on 2016/10/24.
 */
public class Main {
    public static void main(String[] args) {
        Jquests req = new Jquests()
                .url("http://www.baidu.com")
                .get()
                .go();
        Log.d(Tool.transToString(req.rawBody, "UTF-8"));

    }
}
