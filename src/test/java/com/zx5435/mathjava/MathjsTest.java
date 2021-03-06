package com.zx5435.mathjava;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

class MathjsTest {

    @Test
    void a3() {
        String a = "{'value': 3, 'mathjs': 'ConstantNode'}";
        Double x = Mathjs.compileString(a).evaluate();

        assert x == 3;
    }

    @Test
    void a18() {
        String a = "{'fn': 'multiply', 'op': '*', 'args': [{'value': 3, 'mathjs': 'ConstantNode'}, {'value': 6.1, 'mathjs': 'ConstantNode'}], 'mathjs': 'OperatorNode', 'implicit': false}";
        Double x = Mathjs.compileString(a).evaluate();

        assert x == 18.3;
    }

    @Test
    void testNull() {
        String a = "{'fn': 'multiply', 'op': '*', 'args': [{'value': null, 'mathjs': 'ConstantNode'}, {'value': 6, 'mathjs': 'ConstantNode'}], 'mathjs': 'OperatorNode', 'implicit': false}";
        Double x = Mathjs.compileString(a).evaluate();

        assert x == null;
    }

    @Test
    void sub() {
        String a = "{\"fn\": \"subtract\", \"op\": \"-\", \"args\": [{\"value\": 1, \"mathjs\": \"ConstantNode\"}, {\"fn\": \"divide\", \"op\": \"/\", \"args\": [{\"value\": 1, \"mathjs\": \"ConstantNode\"}, {\"value\": 2, \"mathjs\": \"ConstantNode\"}], \"mathjs\": \"OperatorNode\", \"implicit\": false}], \"mathjs\": \"OperatorNode\", \"implicit\": false}";
        Double x = Mathjs.compileString(a).evaluate();

        assert x == .5;
    }

    @Test
    void sin() {
        String a = "{\"fn\": {\"name\": \"sin\", \"mathjs\": \"SymbolNode\"}, \"args\": [{\"fn\": \"add\", \"op\": \"+\", \"args\": [{\"value\": 1, \"mathjs\": \"ConstantNode\"}, {\"value\": 2, \"mathjs\": \"ConstantNode\"}], \"mathjs\": \"OperatorNode\", \"implicit\": false}], \"mathjs\": \"FunctionNode\"}";
        Double x = Mathjs.compileString(a).evaluate();

        assert x == 0.1411200080598672;
    }

    @Test
    void x() {
        String a = "{\"fn\": \"multiply\", \"op\": \"*\", \"args\": [{\"value\": 2, \"mathjs\": \"ConstantNode\"}, {\"name\": \"x\", \"mathjs\": \"SymbolNode\"}], \"mathjs\": \"OperatorNode\", \"implicit\": false}";
        Double x = Mathjs.compileString(a).evaluate(new HashMap<String, Double>() {{
            put("x", 123.0);
        }});
        assert x == 246;
        Double x2 = Mathjs.compileString(a).evaluate(new HashMap<String, Double>() {{
            put("x", 222.);
        }});
        assert x2 == 444;
    }

}
