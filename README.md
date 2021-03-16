# mathjava
mathjs.org json parse via java

## Install

```xml
<dependency>
  <groupId>com.zx5435</groupId>
  <artifactId>mathjava</artifactId>
  <version>1.0</version>
</dependency>
```
```groovy
implementation 'com.zx5435:mathjava:1.0'
```

## How to use it

```groovy
String a = "{'value': 3, 'mathjs': 'ConstantNode'}";
Double x = Mathjs.compileString(a).evaluate();
// output 3.0
```

```groovy
String a = "{\"fn\": \"multiply\", \"op\": \"*\", \"args\": [{\"value\": 2, \"mathjs\": \"ConstantNode\"}, {\"name\": \"x\", \"mathjs\": \"SymbolNode\"}], \"mathjs\": \"OperatorNode\", \"implicit\": false}";
Double x = Mathjs.compileString(a).evaluate(new HashMap<String, Double>() {{
    put("x", 123.0);
}});
// output 2 * x = 246.0
```

## Mathjs supported nodes
 - [x] ConstantNode
 - [x] FunctionNode `sin cos`
 - [x] OperatorNode `+ - * /`
 - [x] ParenthesisNode `()`
 - [x] SymbolNode `x`
