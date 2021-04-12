package com.zx5435.mathjava.node;

import com.google.gson.JsonObject;
import com.zx5435.mathjava.MathNode;
import com.zx5435.mathjava.MathResult;
import com.zx5435.mathjava.MathScope;
import com.zx5435.mathjava.node.base.BaseMathNode;

import java.util.List;

/**
 * @author admin
 */
public class SymbolNode extends BaseMathNode implements MathNode {

    public String name;

    public SymbolNode(JsonObject raw, MathScope scope) {
        super(raw, scope);
        name = raw.get("name").getAsString();
    }

    @Override
    public String genStr() {
        return this.name;
    }

    @Override
    public MathResult genVal() {
        Double res = this.getScope().getByOne(this.genStr());
        return new MathResult(res);
    }

    @Override
    public List<MathResult> genExpr() {
        return null;
    }

}
