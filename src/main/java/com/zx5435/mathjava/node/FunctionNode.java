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
public class FunctionNode extends BaseMathNode implements MathNode {

    public MathNode fn;
    public List<MathNode> args = new ArrayList<>();

    public FunctionNode(JsonObject raw, MyScope scope) {
        super(raw, scope);

        fn = load(raw.get("fn").getAsJsonObject(), this.getScope());
        JsonArray args = raw.get("args").getAsJsonArray();
        for (JsonElement arg : args) {
            this.args.add(load(arg.getAsJsonObject(), this.getScope()));
        }
    }

    @Override
    public String genStr() {
        List<String> arr = new ArrayList<>();
        for (MathNode arg : args) {
            arr.add(arg.genStr());
        }
        return this.fn.genStr() + "(" + String.join(", ", arr) + ")";
    }

    @Override
    public Double genVal() {
        try {
            return MyMath.runFn(this.fn.genStr(), args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Double> genExpr() {
        List<List<Double>> argArr = new ArrayList<>();
        for (MathNode arg : args) {
            argArr.add(arg.genExpr());
        }
        List<Double> c = new ArrayList<>(Collections.nCopies(this.getScope().size, null));

        try {
            c = MyMath.runFnExpr(this.fn.genStr(), argArr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return c;
    }

}
