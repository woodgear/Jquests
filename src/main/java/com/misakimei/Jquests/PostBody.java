package com.misakimei.Jquests;

import java.io.OutputStream;

/**
 * Created by 18754 on 2016/10/23.
 */
public interface PostBody {
    void writeData(OutputStream out);

    int getLength();
}
