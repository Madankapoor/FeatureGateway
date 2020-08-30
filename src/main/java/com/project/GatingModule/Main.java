package com.project.GatingModule;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        GatingModule gatingModule = new GatingModule();
        HashMap<String,Object> userMap = new HashMap<>();
        userMap.put("Name","Madan Kapoor");
        userMap.put("Age",23);
        userMap.put("Address.no",37);
        userMap.put("Address.street","Gandhi Street");
        userMap.put("Address.nagar","Thenplani Nagar");
        userMap.put("Address.city","Chennai");
        userMap.put("score",10);
        System.out.println(userMap.toString());
        String[] expressions = new String[]{
                "Age<100",
                "(Age<18) && (Address.city==\"Bangalore\")",
                "(Age>18) && (Address.city==\"Chennai\")",
        };
        for(String expr: expressions){
            System.out.println("Exp: " + expr);
            System.out.println(gatingModule.IsAllowed(expr,userMap));
        }
    }
}
