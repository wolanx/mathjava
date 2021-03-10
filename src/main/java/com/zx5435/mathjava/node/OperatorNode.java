package com.zx5435.mathjava.node;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zx5435.mathjava.MyScope;
import com.zx5435.mathjava.node.function.MyMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author admin
 */
public class OperatorNode extends BaseNode implements MathNode {

    public String fn;
    public String op;
    public ArrayList<MathNode> args = new ArrayList<>();
    public boolean implicit;

    public OperatorNode(JsonObject raw, MyScope scope) {
        super(raw, scope);

        fn = raw.get("fn").getAsString();
        op = raw.get("op").getAsString();
        implicit = raw.get("implicit").getAsBoolean();
        JsonArray args = raw.get("args").getAsJsonArray();
        for (JsonElement arg : args) {
            this.args.add(load(arg.getAsJsonObject(), this.getScope()));
        }
    }

    @Override
    public String genStr() {
        String a = args.get(0).genStr();
        String b = args.get(1).genStr();
        return a + " " + this.op + " " + b;
    }

    @Override
    public Double genVal() {
        Double a = args.get(0).genVal();
        Double b = args.get(1).genVal();
        if (a == null || b == null) {
            return null;
        }
        try {
            return MyMath.runTwo(this.fn, a, b);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Double> genExpr() {
        List<Double> a = args.get(0).genExpr();
        List<Double> b = args.get(1).genExpr();

        if (a == null || b == null || a.size() != b.size()) {
            return null;
        }

        List<Double> c = new ArrayList<>(Collections.nCopies(this.getScope().size, null));
        try {
            for (int i = 0; i < c.size(); i++) {
                c.set(i, MyMath.runTwo(this.fn, a.get(i), b.get(i)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

}
