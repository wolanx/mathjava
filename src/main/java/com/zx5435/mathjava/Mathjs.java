package com.zx5435.mathjava;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zx5435.mathjava.node.BaseNode;
import com.zx5435.mathjava.node.MathNode;

import java.util.HashMap;
import java.util.List;

/**
 * @author admin
 */
public class Mathjs {

    private MathNode node;

    public static Mathjs compileString(String logic) {
        Mathjs mjs = new Mathjs();

        JsonObject o = new Gson().fromJson(logic, JsonObject.class);
        mjs.node = BaseNode.load(o, new MyScope());

        return mjs;
    }

    public Double evaluate() {
        return evaluate(null);
    }

    public Double evaluate(HashMap<String, Double> scope) {
        if (scope != null) {
            node.setScope(scope);
        }

        Double val = node.genVal();
        System.out.printf("======= %s = %s\n", node.genStr(), val);
        return val;
    }

    public List<Double> evaluateByExpr(int start, int end, int step) {
        MyScope scope = node.getScope();
        scope.start = start;
        scope.end = end;
        scope.step = step;
        scope.size = (end - start) / step;
        List<Double> val = node.genExpr();
        System.out.printf("======= %s = %s\n", node.genStr(), val);
        return val;
    }

}
