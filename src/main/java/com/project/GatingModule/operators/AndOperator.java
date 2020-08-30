package com.project.GatingModule.operators;

import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.operands.Operand;
import com.project.GatingModule.util.Helper;

import java.util.List;

public class AndOperator implements Operator {
    @Override
    public Boolean evaluate(List<Operand> operandList) throws InvalidNoOfOperandsException, InvalidOperandTypeException {
        if(operandList.size()<getOperandCount()){
            throw new InvalidNoOfOperandsException("Or operator needs 2 operands");
        }
        Object one = Helper.getOperandValue(operandList,0);
        if(!(one instanceof Boolean)){
            throw new InvalidOperandTypeException("Boolean",one.getClass().getName());
        }
        Object two = Helper.getOperandValue(operandList,1);
        if(!(two instanceof Boolean)){
            throw new InvalidOperandTypeException("Boolean",two.getClass().getName());
        }
        return ((Boolean)one) && ((Boolean)two);
    }

    @Override
    public String[] operatorSymbols() {
        final String[] orSymbols = {
                "&&",
                "AND",
                "and",
                "And"
        };
        return orSymbols;
    }

    @Override
    public Integer getPrecedence() {
        return 2000;
    }

    @Override
    public Integer getOperandCount() {
        return 2;
    }
}
