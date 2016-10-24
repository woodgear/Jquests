package com.misakimei.Jquests.Header;

/**
 * Created by 18754 on 2016/10/23.
 * 能返回键值对的就可以看成是http的首部
 */
public interface Header {
    String getKey();

    String getVal();
}
