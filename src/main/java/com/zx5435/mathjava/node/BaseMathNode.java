package com.zx5435.mathjava.node;

import com.google.gson.JsonObject;
import com.zx5435.mathjava.MyScope;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
public abstract class BaseMathNode {

    private final JsonObject raw;

    private final MyScope scope;

    public BaseMathNode(JsonObject logic, MyScope scope) {
        this.raw = logic;
        this.scope = scope;
    }

    public static MathNode load(JsonObject logic, MyScope scope) {
        String mathjs = logic.get("mathjs").getAsString();
        switch (mathjs) {
            case "ConstantNode":
                return new ConstantNode(logic, scope);
//            case "FunctionNode":
//                return new FunctionNode(logic, scope);
            case "OperatorNode":
                return new OperatorNode(logic, scope);
//            case "ParenthesisNode":
//                return new ParenthesisNode(logic, scope);
//            case "SymbolNode":
//                return new SymbolNode(logic, scope);
            default:
                return null;
        }
    }

    public MyScope getScope() {
        return this.scope;
    }

    public void setScope(Map<String, Double> scope) {
        for (Map.Entry<String, Double> next : scope.entrySet()) {
            this.scope.put(next.getKey(), next.getValue());
        }
    }

    @Override
    public String toString() {
        return "BaseNode{" + "raw=" + raw + '}';
    }

}
