package com.zx5435.mathjava;

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
    MathScope getScope();

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
    MathResult genVal();

    /**
     * gen expr
     *
     * @return expr
     */
    List<MathResult> genExpr();

}
