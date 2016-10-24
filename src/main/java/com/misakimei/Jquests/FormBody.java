package com.misakimei.Jquests;

import com.misakimei.Jquests.Tool.Tool;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by 18754 on 2016/10/24.
 */
public class FormBody implements PostBody {

    List<Pair> list = new ArrayList<>();
    private String res;

    public FormBody add(String key, String v) {
        list.add(new Pair(key, v));
        return this;
    }

    @Override
    public void writeData(OutputStream out) {
        try {
            out.write(toString().getBytes(Charset.forName("UTF-8")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getLength() {
        return toString().length();
    }

    public String toString() {
        if (res == null) {
            StringJoiner sj = new StringJoiner("&");
            for (Pair p : list) {
                sj.add(p.toString());
            }
            res = Tool.unescapeJava(sj.toString());
            return res;
        }
        return res;

    }

    private class Pair implements Map.Entry<String, String> {
        String k;
        String v;

        public Pair(String k, String v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public String getKey() {
            return k;
        }

        @Override
        public String getValue() {
            return v;
        }

        @Override
        public String setValue(String value) {
            v = value;
            return v;
        }

        @Override
        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

}
