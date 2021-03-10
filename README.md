# mathjava
adapt mathjs.org

## How to use it

```java
String a = "{'value': 3, 'mathjs': 'ConstantNode'}";
Double x = Mathjs.compileString(a).evaluate();
// output 3.0
```

```java
String a = "{\"fn\": \"multiply\", \"op\": \"*\", \"args\": [{\"value\": 2, \"mathjs\": \"ConstantNode\"}, {\"name\": \"x\", \"mathjs\": \"SymbolNode\"}], \"mathjs\": \"OperatorNode\", \"implicit\": false}";
Double x = Mathjs.compileString(a).evaluate(new HashMap<String, Double>() {{
    put("x", 123.0);
}});
// output 2 * x = 246
```

## Mathjs supported nodes
 - [x] ConstantNode
 - [x] FunctionNode `sin cos`
 - [x] OperatorNode `+ - * /`
 - [x] ParenthesisNode `()`
 - [x] SymbolNode `x`
