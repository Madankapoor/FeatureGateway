package com.project.GatingModule.operands;

import com.project.GatingModule.exceptions.InvalidTokenException;
import com.project.GatingModule.exceptions.UserPropertyNotFoundException;
import com.project.GatingModule.element.Element;

import java.util.HashMap;

public class ConstantOperandFactory {
    public static Operand getOperand(Element element) throws InvalidTokenException {
        switch (element.getType()){
            case DOUBLE_CONSTANT:
                return new ConstantOperand<Double>(Double.parseDouble(element.getValue()));
            case STRING_CONSTANT:
                return new ConstantOperand<String>(element.getValue());
            case INTEGER_CONSTANT:
                return new ConstantOperand<Integer>(Integer.parseInt(element.getValue()));
            case BOOLEAN_CONSTANT:
                return new ConstantOperand<Boolean>(Boolean.parseBoolean(element.getValue()));
        }
        throw new InvalidTokenException(element.getValue());
    }
}
