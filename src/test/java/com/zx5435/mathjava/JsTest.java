package com.zx5435.mathjava;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsTest {

    static ScriptEngine js;

    @BeforeAll
    static void before() throws Exception {
        URL url = ClassLoader.getSystemClassLoader().getResource("math.js");

        if (url == null) {
            return;
        }

        ScriptEngineManager manager = new ScriptEngineManager();
        js = manager.getEngineByName("nashorn");
        js.eval(Files.newBufferedReader(Paths.get(url.toURI()), StandardCharsets.UTF_8));
    }

    @Test
    void mathjs() throws Exception {
        js.eval("var a = math.parse('3 + 2 > 1')");
        js.eval("output = JSON.stringify(a, math.replacer)");
        String jsonStr = (String) js.get("output");
        System.out.println("o = " + jsonStr);
    }

}
