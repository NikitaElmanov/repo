package ru.web.app.logic;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class GenLogicTest {

    private GenLogic logic;

    @Before
    public void init(){
        logic = new GenLogic(Arrays.asList("create", "insert", "create2", "secondTable", "AITwof"),
                             Arrays.asList("fld1", "fld2", "fld3", "fld4", "fldtest"),
                             Arrays.asList("VARCHAR", "BOOLEAN", "DATE", "DECIMAL", "VARCHAR"),
                             Arrays.asList("13", "", "1900,2020", "6,2", "20"),
                             Arrays.asList("false", "true", "true", "false", "true"),
                             Arrays.asList("true", "false", "false", "false", "false"),
                             "testdb", "10",
                             Arrays.asList("fld12", "fld22", "fld32"),
                             Arrays.asList("INT", "VARCHAR", "BOOLEAN"),
                             Arrays.asList("", "10", ""),
                             Arrays.asList("false", "true", "true", "false", "true"),
                             Arrays.asList("true", "false", "false"),
                             "testdb2", "fld22", "fld1");

        /*logic = new GenLogic(Arrays.asList("create", "insert", "AIOne"),
                             Arrays.asList("fld1", "fld2", "fld3"),
                             Arrays.asList("INT", "VARCHAR", "DECIMAL"),
                             Arrays.asList("", "25", "6,3"),
                             Arrays.asList("true", "false", "false"),
                             "testdb", "10",
                             null,
                             null,
                             null,
                             null,
                             null, null, null);*/
    }

    @Test
    public void generateScript() {

        System.out.println(logic.generateScript());
        System.out.println(logic.generateScriptConnectTable());
    }
}