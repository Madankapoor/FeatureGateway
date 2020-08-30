package com.project.GatingModule.operators;

import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.operands.Operand;
import com.project.GatingModule.util.Helper;

import java.util.List;

public class BetweenOperator implements Operator{
    @Override
    public Boolean evaluate(List<Operand> operandList) throws InvalidNoOfOperandsException, InvalidOperandTypeException {
        if(operandList.size()<getOperandCount()){
            throw new InvalidNoOfOperandsException("NoneOf operator needs 2 or more operands");
        }
        Object one = Helper.getOperandValue(operandList,0);
        Object low = Helper.getOperandValue(operandList,1);
        Object high = Helper.getOperandValue(operandList,2);
        ElementType element = Helper.getObjectElementType(one);
        switch (element){
            case INTEGER_CONSTANT:
                return (Integer)low <= (Integer)one && (Integer)one <= (Integer)high;
            case DOUBLE_CONSTANT:
                return (Double)low <= (Double)one && (Double)one <= (Double)high;
        }
        throw new InvalidOperandTypeException("Number",one.toString());
    }

    @Override
    public String[] operatorSymbols() {
        return new String[]{
                "BETWEEN",
                "between",
                "Between"
        };
    }

    @Override
    public Integer getPrecedence() {
        return 1000;
    }

    @Override
    public Integer getOperandCount() {
        return 3;
    }
}
