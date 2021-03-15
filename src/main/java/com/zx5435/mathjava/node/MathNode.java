package com.zx5435.mathjava.node;

import com.zx5435.mathjava.MyScope;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
public interface MathNode {

    /**
     * get scope
     *
     * @return scope
     */
    MyScope getScope();

    /**
     * set scope
     *
     * @param map arr
     */
    void setScope(Map<String, Double> map);

    /**
     * gen str
     *
     * @return str
     */
    String genStr();

    /**
     * gen val
     *
     * @return val
     */
    Double genVal();

    /**
     * gen expr
     *
     * @return expr
     */
    List<Double> genExpr();

}
