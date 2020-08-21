package com.project.GatingModule.operators;

import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.operands.Operand;
import com.project.GatingModule.util.Helper;

import java.util.List;

public class NotOperator implements Operator {
    @Override
    public Boolean evaluate(List<Operand> operandList) throws InvalidNoOfOperandsException, InvalidOperandTypeException {
        if(operandList.size()<1){
            throw new InvalidNoOfOperandsException("Not operator needs atleast 1 operand");
        }
        Object one = Helper.getOperandValue(operandList,0);
        if(!(one instanceof Boolean)){
            throw new InvalidOperandTypeException("Boolean",one.getClass().getName());
        }
        return !((Boolean)one);
    }

    @Override
    public String[] operatorSymbols() {
        final String[] notSymbols = new String[]{
                "not",
                "Not",
                "!",
                "nOt",
                "noT",
                "NOT",
        };
        return notSymbols;
    }

    @Override
    public Integer getPrecedence() {
        return 2000;
    }

    @Override
    public Integer getOperandCount() {
        return 1;
    }
}
