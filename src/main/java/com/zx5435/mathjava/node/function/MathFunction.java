package com.zx5435.mathjava.node.function;

import com.zx5435.mathjava.node.MathNode;
import com.zx5435.mathjava.node.MathResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author admin
 */
public class MathFunction {

    private static final Map<String, Function<List<MathNode>, MathResult>> FN_MAP = new HashMap<>();
    private static final Map<String, Function<List<List<MathResult>>, List<MathResult>>> FN_MAP_EXPR = new HashMap<>();

    static {
//        FN_MAP.put("sin", list -> Math.sin(list.get(0).genVal()));
//        FN_MAP.put("cos", list -> Math.cos(list.get(0).genVal()));
//
//
//        FN_MAP_EXPR.put("sin", list -> {
//            List<OutMath<?>> doubles = list.get(0);
//            for (int i = 0; i < doubles.size(); i++) {
//                doubles.set(i, Math.sin(doubles.get(i)));
//            }
//            return doubles;
//        });
    }

    public static Double runFn(String fn, List<MathNode> args) throws Exception {
        Function<List<MathNode>, MathResult> func = FN_MAP.get(fn);

        if (func == null) {
            throw new Exception("no fn: " + fn);
        }

//        return func.apply(args);
        return null;
    }

    public static List<MathResult> runFnExpr(String fn, List<List<MathResult>> args) throws Exception {
        Function<List<List<MathResult>>, List<MathResult>> func = FN_MAP_EXPR.get(fn);

        if (func == null) {
            throw new Exception("no fn: " + fn);
        }

        return func.apply(args);
    }

    public static void loadExtFunc(Map<String, Function<List<MathNode>, MathResult>> fnMap) {
        for (Map.Entry<String, Function<List<MathNode>, MathResult>> one : fnMap.entrySet()) {
            FN_MAP.put(one.getKey(), one.getValue());
        }
    }

    public static MathResult runTwo(String fn, MathResult a, MathResult b) throws Exception {
        switch (fn) {
            case "add":
                return new MathResult(add(a.getDouble(), b.getDouble()));
            case "subtract":
                return new MathResult(subtract(a.getDouble(), b.getDouble()));
            case "multiply":
                return new MathResult(multiply(a.getDouble(), b.getDouble()));
            case "divide":
                return new MathResult(divide(a.getDouble(), b.getDouble()));
            default:
                throw new Exception("no fn: " + fn);
        }
    }

    public static double add(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    public static double subtract(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    public static double multiply(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }

    public static double divide(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, RoundingMode.UP).doubleValue();
    }

}
