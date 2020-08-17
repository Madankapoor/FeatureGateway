package com.project.GatingModule.util;

import com.project.GatingModule.element.Element;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.enums.Separators;
import com.project.GatingModule.operands.Operand;

import java.util.List;

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
}
