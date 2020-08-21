package com.project.GatingModule.operators;

import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.operands.Operand;
import com.project.GatingModule.util.Helper;

import java.util.List;

public class NoneOfOperator implements Operator {
    @Override
    public Boolean evaluate(List<Operand> operandList) throws InvalidNoOfOperandsException, InvalidOperandTypeException {
        if(operandList.size()<2){
            throw new InvalidNoOfOperandsException("NoneOf operator needs 2 or more operands");
        }
        Object one = Helper.getOperandValue(operandList,0);
        for(int index=1;index<operandList.size();index++){
            Object two = Helper.getOperandValue(operandList,index);
            if(one.equals(two))
                return false;
        }
        return true;
    }

    @Override
    public String[] operatorSymbols() {
        return new String[]{
                "NONEOF","noneof","Noneof","NoneOf"
        };
    }

    @Override
    public Integer getPrecedence() {
        return 1000;
    }

    @Override
    public Integer getOperandCount() {
        return -1;
    }
}
