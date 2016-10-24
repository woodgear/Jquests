package com.misakimei.Jquests.Tool;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/**
 * Created by 18754 on 2016/10/24.
 * 工具包
 */
public class Tool {

    static byte[] toByteArray(InputStream in) {
        try {
            return IOUtils.toByteArray(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] toByteArray(InputStream inputStream, String encoding) {
        if (encoding == null) {
            return toByteArray(inputStream);
        }
        switch (encoding) {
            case "gzip":
                try {
                    return toByteArray(new GZIPInputStream(inputStream));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
        return toByteArray(inputStream);

    }


    static String transToString(InputStream in, String encoding) {
        try {
            return IOUtils.toString(in, encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String transToString(byte[] in, String encoding) {
        try {
            return IOUtils.toString(in, encoding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public final static String unescapeJava(String str) {
        return StringEscapeUtils.unescapeJava(str);
    }

}
