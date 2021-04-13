package com.zx5435.mathjava;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.HashMap;

class MathjsTest {

    /**
     * @apiNote { "value": 3,"mathjs": "ConstantNode" }
     */
    @Test
    void yml() throws NoSuchMethodException {
        Annotation[] yml = getClass().getDeclaredMethod("yml").getAnnotations();
        System.out.println();

    }

    @Test
    void a3() {
        String a = "{'value': 3, 'mathjs': 'ConstantNode'}";
        Double x = Mathjs.compileString(a).evaluate().getDouble();

        assert x == 3;
    }

    @Test
    void a18() {
        String a = "{'fn': 'multiply', 'op': '*', 'args': [{'value': 3, 'mathjs': 'ConstantNode'}, {'value': 6.1, 'mathjs': 'ConstantNode'}], 'mathjs': 'OperatorNode', 'implicit': false}";
        Double x = Mathjs.compileString(a).evaluate().getDouble();

        assert x == 18.3;
    }

    @Test
    void testNull() {
        String a = "{'fn': 'multiply', 'op': '*', 'args': [{'value': null, 'mathjs': 'ConstantNode'}, {'value': 6, 'mathjs': 'ConstantNode'}], 'mathjs': 'OperatorNode', 'implicit': false}";
        Double x = Mathjs.compileString(a).evaluate().getDouble();

        assert x == null;
    }

    @Test
    void sub() {
        String a = "{\"fn\": \"subtract\", \"op\": \"-\", \"args\": [{\"value\": 1, \"mathjs\": \"ConstantNode\"}, {\"fn\": \"divide\", \"op\": \"/\", \"args\": [{\"value\": 1, \"mathjs\": \"ConstantNode\"}, {\"value\": 2, \"mathjs\": \"ConstantNode\"}], \"mathjs\": \"OperatorNode\", \"implicit\": false}], \"mathjs\": \"OperatorNode\", \"implicit\": false}";
        Double x = Mathjs.compileString(a).evaluate().getDouble();

        assert x == .5;
    }

    @Test
    void sin() {
        String a = "{\"fn\": {\"name\": \"sin\", \"mathjs\": \"SymbolNode\"}, \"args\": [{\"fn\": \"add\", \"op\": \"+\", \"args\": [{\"value\": 1, \"mathjs\": \"ConstantNode\"}, {\"value\": 2, \"mathjs\": \"ConstantNode\"}], \"mathjs\": \"OperatorNode\", \"implicit\": false}], \"mathjs\": \"FunctionNode\"}";
        Double x = Mathjs.compileString(a).evaluate().getDouble();

        assert x == 0.1411200080598672;
    }

    @Test
    void x() {
        String a = "{\"fn\": \"multiply\", \"op\": \"*\", \"args\": [{\"value\": 2, \"mathjs\": \"ConstantNode\"}, {\"name\": \"x\", \"mathjs\": \"SymbolNode\"}], \"mathjs\": \"OperatorNode\", \"implicit\": false}";
        Double x = Mathjs.compileString(a).evaluate(new HashMap<String, Double>() {{
            put("x", 123.0);
        }}).getDouble();
        assert x == 246;
        Double x2 = Mathjs.compileString(a).evaluate(new HashMap<String, Double>() {{
            put("x", 222.);
        }}).getDouble();
        assert x2 == 444;
    }

    @Test
    void a_2() {
        String a = "{\"mathjs\":\"OperatorNode\",\"op\":\">\",\"fn\":\"larger\",\"args\":[{\"mathjs\":\"SymbolNode\",\"name\":\"a\"},{\"mathjs\":\"ConstantNode\",\"value\":2}],\"implicit\":false}";
        Boolean x = Mathjs.compileString(a).evaluate(new HashMap<String, Double>() {{
            put("a", 1.);
        }}).getBoolean();
        assert !x;
        Boolean x2 = Mathjs.compileString(a).evaluate(new HashMap<String, Double>() {{
            put("a", 222.);
        }}).getBoolean();
        assert x2;
    }

}
