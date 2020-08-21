package com.project.GatingModule;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class GatingModuleTest {
    private GatingModule gatingModule;
    public GatingModuleTest(){
        this.gatingModule = new GatingModule();
    }

    @Test
    public  void testExpressions(){
        HashMap<String,Object> userMap = new HashMap<>();
        userMap.put("Name","Madan Kapoor");
        userMap.put("Age",23);
        userMap.put("Address.no",37);
        userMap.put("Address.street","Gandhi Street");
        userMap.put("Address.nagar","Thenplani Nagar");
        userMap.put("Address.city","Chennai");
        userMap.put("score",10);
        String[] expressions = new String[]{
                "Age<100",
                "(Age<18) && (Address.city==\"Bangalore\")",
                "(Age>18) && (Address.city==\"Chennai\")",
        };

        Boolean[] sol = new Boolean[]{
                true,
                false,
                true
        };
        int st=0;
        for(String expr: expressions){
            Assert.assertEquals(sol[st],gatingModule.IsAllowed(expr,userMap));
            st++;
        }
    }
}