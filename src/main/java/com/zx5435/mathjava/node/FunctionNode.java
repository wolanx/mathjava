package com.zx5435.mathjava.node;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zx5435.mathjava.MathNode;
import com.zx5435.mathjava.MathResult;
import com.zx5435.mathjava.MathScope;
import com.zx5435.mathjava.node.base.BaseMathNode;
import com.zx5435.mathjava.node.function.MathFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
public class FunctionNode extends BaseMathNode implements MathNode {

    public MathNode fn;
    public List<MathNode> args = new ArrayList<>();

    public FunctionNode(JsonObject raw, MathScope scope) {
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
    public MathResult genVal() {
        try {
            return MathFunction.runFn(this.fn.genStr(), args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<MathResult> genExpr() {
        return null;
//        List<List<Double>> argArr = new ArrayList<>();
//        for (MathNode arg : args) {
//            argArr.add(arg.genExpr());
//        }
//        List<Double> c = new ArrayList<>(Collections.nCopies(this.getScope().size, null));
//
//        try {
//            c = MathFunction.runFnExpr(this.fn.genStr(), argArr);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        return c;
    }

}
