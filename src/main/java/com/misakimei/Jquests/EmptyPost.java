package com.misakimei.Jquests;

import java.io.OutputStream;

/**
 * Created by 18754 on 2016/10/24.
 */
public class EmptyPost implements PostBody {
    @Override
    public void writeData(OutputStream out) {
    }

    @Override
    public int getLength() {
        return 0;
    }
}
