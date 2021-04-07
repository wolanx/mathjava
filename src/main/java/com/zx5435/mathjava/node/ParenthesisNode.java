//package com.zx5435.mathjava.node;
//
//import com.google.gson.JsonObject;
//import com.zx5435.mathjava.MyScope;
//
//import java.util.List;
//
///**
// * @author admin
// */
//public class ParenthesisNode extends BaseMathNode implements MathNode {
//
//    public MathNode content;
//
//    public ParenthesisNode(JsonObject raw, MyScope scope) {
//        super(raw, scope);
//
//        JsonObject o = raw.get("content").getAsJsonObject();
//        content = load(o, this.getScope());
//    }
//
//    @Override
//    public String genStr() {
//        return "(" + this.content.genStr() + ")";
//    }
//
//    @Override
//    public Double genVal() {
//        return this.content.genVal();
//    }
//
//    @Override
//    public List<Double> genExpr() {
//        return null;
//    }
//
//}
