package com.zx5435.mathjava;

import java.util.HashMap;

/**
 * @author admin
 */
public class MyScope extends HashMap<String, Double> {

    public int start;
    public int end;
    public int step;
    public int size;

    public Double getByOne(Object key) {
        return super.get(key);
    }

}
