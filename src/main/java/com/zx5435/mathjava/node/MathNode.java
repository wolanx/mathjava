package com.zx5435.mathjava.node;

import com.zx5435.mathjava.MyScope;

import java.util.HashMap;
import java.util.List;

/**
 * @author admin
 */
public interface MathNode {

    MyScope getScope();

    void setScope(HashMap<String, Double> map);

    String genStr();

    Double genVal();

    List<Double> genExpr();

}
