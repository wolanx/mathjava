package com.zx5435.mathjava.node;

import com.google.gson.JsonObject;
import com.zx5435.mathjava.MathNode;
import com.zx5435.mathjava.MathResult;
import com.zx5435.mathjava.MathScope;
import com.zx5435.mathjava.node.base.BaseMathNode;

import java.util.List;

/**
 * @author 913332
 */
public class ErrorNode extends BaseMathNode implements MathNode {
    public ErrorNode(JsonObject logic, MathScope scope) {
        super(logic, scope);
    }

    @Override
    public String genStr() {
        return "err:" + this.getRaw().get("mathjs").getAsString();
    }

    @Override
    public MathResult genVal() {
        return null;
    }

    @Override
    public List<MathResult> genExpr() {
        return null;
    }
}
