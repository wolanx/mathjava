package com.zx5435.mathjava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.zx5435.mathjava.node.base.BaseMathNode;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author admin
 */
public class Mathjs {

    private static final Logger log = Logger.getLogger("Mathjs");

    private JsonObject json;
    private MathNode node;

    public static Mathjs compileString(String logic) {
        Mathjs mjs = new Mathjs();

        JsonObject o = new Gson().fromJson(logic, JsonObject.class);
        mjs.json = o;
        mjs.node = BaseMathNode.load(o, new MathScope());

        return mjs;
    }

    public MathResult evaluate() {
        return this.evaluate(null);
    }

    public MathResult evaluate(Map<String, Double> scope) {
        if (scope != null) {
            node.setScope(scope);
        }
        MathResult val = node.genVal();
        if (val == null) {
            val = new MathResult();
        }

        String jsonStr = new GsonBuilder().setPrettyPrinting().create().toJson(json);
        System.out.println(jsonStr);
        log.info(String.format("======= %s = %s\n", node.genStr(), val.getDouble()));
        return val;
    }

    public List<MathResult> evaluateByExpr(int start, int end, int step) {
        MathScope scope = node.getScope();
        scope.start = start;
        scope.end = end;
        scope.step = step;
        scope.size = (end - start) / step;
        List<MathResult> val = node.genExpr();

        log.info(String.format("======= %s = %s\n", node.genStr(), val));
        return val;
    }

}
