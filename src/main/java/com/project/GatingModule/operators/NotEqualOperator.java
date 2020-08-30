package com.project.GatingModule.operators;

import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.operands.Operand;
import com.project.GatingModule.util.Helper;

import java.util.List;

public class NotEqualOperator implements Operator{
    @Override
    public Boolean evaluate(List<Operand> operandList) throws InvalidNoOfOperandsException, InvalidOperandTypeException {
        if(operandList.size() < getOperandCount()){
            throw new InvalidNoOfOperandsException("!= operator needs 2 operands");
        }
        Object one = Helper.getOperandValue(operandList,0);
        Object two = Helper.getOperandValue(operandList,1);
        if(!(one.getClass().toString().equals(two.getClass().toString()))){
            throw new InvalidOperandTypeException(one.getClass().getName(),two.getClass().toString());
        }
        return !(one.equals(two));
    }

    @Override
    public String[] operatorSymbols() {
        final String[] symbols = new String[]{
                "!="
        };
        return symbols;
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
