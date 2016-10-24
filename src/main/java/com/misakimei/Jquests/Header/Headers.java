package com.misakimei.Jquests.Header;


import java.util.*;

/**
 * Created by 18754 on 2016/10/23.
 * http的全部首部
 */
public abstract class Headers implements Iterable<Header> {

    //很明显 首部是可以重复的 那么 我们就有两种操作方式 insertoradd insertorreplace
    private Map<String, List<Header>> map = new HashMap<>();

    private void insertOrAdd(String key, String v) {
        if (has(key)) {
            map.get(key).add(new NormalHeader(key, v));
        } else {
            ArrayList<Header> l = new ArrayList<>();
            l.add(new NormalHeader(key, v));
            map.put(key, l);
        }
    }

    private void insertOrReplace(String key, String v) {
        if (has(key)) {
            List<Header> lis = map.get(key);
            lis.clear();
            lis.add(new NormalHeader(key, v));
        } else {
            List<Header> l = new ArrayList<>();
            l.add(new NormalHeader(key, v));
            map.put(key, l);
        }
    }

    private boolean has(String key) {
        return map.get(key) != null;
    }


    public Header getHeader(String key) {
        List<Header> list = getHeaders(key);
        if (list != null && list.size() != 0) {
            return list.get(0);
        }
        return null;
    }

    public List<Header> getHeaders(String key) {
        return map.get(key);
    }

    public Headers set(String k, String v) {
        insertOrReplace(k, v);
        return this;
    }

    public Headers add(String k, String v) {
        insertOrAdd(k, v);
        return this;
    }

    @Override
    public Iterator<Header> iterator() {
        ArrayList<Header> list = new ArrayList<>();
        map.values().forEach(list::addAll);
        return list.iterator();
    }
}

