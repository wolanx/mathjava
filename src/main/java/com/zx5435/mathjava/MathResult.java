package com.zx5435.mathjava;

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

    public MathResult(Boolean b) {
        this.t = b;
    }

    public Double getDouble() {
        if (t == null) {
            return null;
        }
        if (t instanceof Boolean) {
            return ((boolean) t) ? 1. : 0.;
        }
        return (Double) t;
    }

    public Boolean getBoolean() {
        return (Boolean) t;
    }

}
