package com.project.GatingModule.util;

import com.project.GatingModule.element.Element;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.enums.Separators;
import com.project.GatingModule.operands.Operand;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    public static Object getOperandValue(List<Operand> operands, int index){
        return operands.get(index).getValue();
    }

    public static ElementType getObjectElementType(Object value){
        ElementType type = ElementType.UNKNOWN;
        if(value instanceof Integer){
            type = ElementType.INTEGER_CONSTANT;
        }
        else if(value instanceof Double){
            type = ElementType.DOUBLE_CONSTANT;
        }
        else if(value instanceof String){
            type = ElementType.STRING_CONSTANT;
        }
        else if(value instanceof Boolean){
            type = ElementType.BOOLEAN_CONSTANT;
        }
        return type;
    }

    public static boolean isOpenBracket(Element e){
        return e.getValue().equals(Separators.OPEN_ANGLE_BRACKET.toString());
    }
    public static boolean isClosedBracket(Element s){
        return s.getValue().equals(Separators.CLOSE_ANGLE_BRACKET.toString());
    }

    public static ArrayList<String> regexSplit(String token, Pattern p){
        ArrayList<String> tokens = new ArrayList<String>();
        Matcher m = p.matcher(token);
        int prev=0;
        while(m.find()){
            int st = m.start();
            int ed = m.end();
            if(prev <= st-1){
                String pre = token.substring(prev,st).trim();
                if(!pre.isEmpty())
                    tokens.add(pre);
            }
            String match = token.substring(st,ed).trim();
            tokens.add(match);
            prev = ed;
        }
        if(prev<token.length()){
            String post = token.substring(prev).trim();
            if(!post.isEmpty())
                tokens.add(post);
        }
        return tokens;
    }
}
