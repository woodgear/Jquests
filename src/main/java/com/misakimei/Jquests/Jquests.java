package com.misakimei.Jquests;


import com.misakimei.Jquests.Header.Header;
import com.misakimei.Jquests.Header.Headers;
import com.misakimei.Jquests.Header.RequestHeaders;
import com.misakimei.Jquests.Header.ResponseHeaders;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static com.misakimei.Jquests.Tool.Tool.toByteArray;

/**
 * Created by 18754 on 2016/10/23.
 * Jquest 所有的Api从这里开始
 */
public class Jquests {


    public RequestHeaders reqHead = new RequestHeaders();//请求首部
    public ResponseHeaders resHead = new ResponseHeaders();//响应首部
    public PostBody postBody = new EmptyPost();
    public String message;//响应的msg
    public Status status = Status.WRONG_CODE;
    public byte[] rawBody;
    private HttpURLConnection connection;
    private URL url;//url
    private HttpMethod method = HttpMethod.GET;//http 方法
    private HashMap<HttpMethod, MethodBuild> methodBuilds = new HashMap<>();

    {
        methodBuilds.put(HttpMethod.GET, new MethodBuild() {
            @Override
            public void build(Jquests jquests) {
                try {
                    jquests.connection = (HttpURLConnection) url.openConnection();
                    HttpURLConnection con = jquests.connection;
                    for (Header h : reqHead) {
                        con.addRequestProperty(h.getKey(), h.getVal());
                    }
                    jquests.rawBody = toByteArray(con.getInputStream(), con.getContentEncoding());
                    jquests.status = Status.valueOf(con.getResponseCode());
                    jquests.message = con.getResponseMessage();
                    jquests.resHead.of(con.getHeaderFields());


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        methodBuilds.put(HttpMethod.POST, new MethodBuild() {
            @Override
            public void build(Jquests jquests) {
                try {
                    jquests.connection = (HttpURLConnection) url.openConnection();
                    HttpURLConnection con = jquests.connection;
                    con.setRequestMethod(HttpMethod.POST.name());
                    con.setDoOutput(true);
                    for (Header h : reqHead) {
                        con.addRequestProperty(h.getKey(), h.getVal());
                    }
                    jquests.postBody.writeData(con.getOutputStream());


                    jquests.rawBody = toByteArray(con.getInputStream(), con.getContentEncoding());
                    jquests.status = Status.valueOf(con.getResponseCode());
                    jquests.message = con.getResponseMessage();
                    jquests.resHead.of(con.getHeaderFields());


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });


    }


    public Jquests() {
    }

    //按照http协议格式来解析data 设置请求
    public Jquests(String data) {
    }

    public Jquests url(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Jquests url(URL url) {
        this.url = url;
        return this;
    }

    public Jquests get() {
        method = HttpMethod.GET;
        return this;
    }

    public Jquests post() {
        method = HttpMethod.POST;
        return this;
    }

    public Jquests headers(Headers header) {
        this.reqHead = (RequestHeaders) header;
        return this;
    }

    public Jquests headers(String header) {
        this.reqHead.of(header);
        return this;
    }

    public Jquests cookies(Cookies cookies) {
        reqHead.cookies = cookies;
        return this;
    }

    public Jquests postBody(PostBody body) {
        this.postBody = body;
        return this;
    }

    public Jquests go() {
        methodBuilds.get(method).build(this);
        close();
        return this;
    }

    private void close() {
        connection.disconnect();
    }

    private interface MethodBuild {
        void build(Jquests jquests);
    }
}

