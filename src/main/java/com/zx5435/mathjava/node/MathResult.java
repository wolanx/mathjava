package com.zx5435.mathjava.node;

/**
 * @author 913332
 */
public class MathResult {

    private Object t;

    public MathResult() {
    }

    public MathResult(Double d) {
        this.t = d;
    }

    public Object get() {
        return t;
    }

    public Double getDouble() {
        if (t == null) {
            return null;
        }
        return (Double) t;
    }

    public Boolean getBoolean() {
        return (Boolean) t;
    }

}
