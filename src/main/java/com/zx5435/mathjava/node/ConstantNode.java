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

    public Double value = null;

    public ConstantNode(JsonObject raw, MyScope scope) {
        super(raw, scope);

        JsonElement value1 = raw.get("value");
        if (!value1.isJsonNull()) {
            this.value = value1.getAsDouble();
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
        if (this.genVal() == null) {
            return null;
        }
        return doubleTrans(this.genVal());
    }

    @Override
    public Double genVal() {
        return value;
    }

    @Override
    public List<Double> genExpr() {
        return Collections.nCopies(this.getScope().size, this.genVal());
    }

}
