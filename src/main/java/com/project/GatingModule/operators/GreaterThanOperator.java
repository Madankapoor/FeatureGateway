package com.project.GatingModule.operators;

import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.operands.Operand;
import com.project.GatingModule.util.Helper;

import java.util.List;

public class GreaterThanOperator implements Operator {
    @Override
    public Boolean evaluate(List<Operand> operandList) throws InvalidNoOfOperandsException, InvalidOperandTypeException {
        if(operandList.size()<getOperandCount()){
            throw new InvalidNoOfOperandsException("!= operator needs 2 operands");
        }
        Object one = Helper.getOperandValue(operandList,0);
        Object two = Helper.getOperandValue(operandList,1);
        if(!(one.getClass().toString().equals(two.getClass().toString()))){
            throw new InvalidOperandTypeException(one.getClass().getName(),two.getClass().toString());
        }
        ElementType element = Helper.getObjectElementType(one);
        switch (element){
            case INTEGER_CONSTANT:
                return (Integer)one > (Integer)two;
            case DOUBLE_CONSTANT:
                return (Double)one > (Double)two;
        }
        throw new InvalidOperandTypeException("Number",one.toString());
    }

    @Override
    public String[] operatorSymbols() {
        return new String[]{
                ">"
        };
    }

    @Override
    public Integer getPrecedence() {
        return 1000;
    }
    @Override
    public Integer getOperandCount() {
        return 2;
    }
}
