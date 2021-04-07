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
//public class SymbolNode extends BaseMathNode implements MathNode {
//
//    public String name;
//
//    public SymbolNode(JsonObject raw, MyScope scope) {
//        super(raw, scope);
//        name = raw.get("name").getAsString();
//    }
//
//    @Override
//    public String genStr() {
//        return this.name;
//    }
//
//    @Override
//    public Double genVal() {
//        return this.getScope().getByOne(this.genStr());
//    }
//
//    @Override
//    public List<Double> genExpr() {
//        return null;
//    }
//
//}
