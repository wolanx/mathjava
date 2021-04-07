package com.zx5435.mathjava.node;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zx5435.mathjava.MyScope;

import java.util.Collections;
import java.util.List;

/**
 * @author admin
 */
public class ConstantNode extends BaseMathNode implements MathNode {

    public MathResult value = null;

    public ConstantNode(JsonObject raw, MyScope scope) {
        super(raw, scope);

        JsonElement value1 = raw.get("value");

        this.value = new MathResult(null);

        if (!value1.isJsonNull()) {
            try {
                double asDouble = value1.getAsDouble();
                this.value = new MathResult(asDouble);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String doubleTrans(double d) {
        if (Math.round(d) - d == 0) {
            return String.valueOf((long) d);
        }

        return String.valueOf(d);
    }

    @Override
    public String genStr() {
        Double aDouble = this.genVal().getDouble();
        if (aDouble == null) {
            return null;
        }
        return doubleTrans(aDouble);
    }

    @Override
    public MathResult genVal() {
        return this.value;
    }

    @Override
    public List<MathResult> genExpr() {
        return Collections.nCopies(this.getScope().size, this.genVal());
    }

}
