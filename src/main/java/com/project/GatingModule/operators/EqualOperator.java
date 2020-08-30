package com.project.GatingModule.operators;

import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.operands.Operand;
import com.project.GatingModule.util.Helper;

import java.util.List;

public class EqualOperator implements Operator {
    @Override
    public Boolean evaluate(List<Operand> operandList)  throws InvalidNoOfOperandsException, InvalidOperandTypeException {
        if(operandList.size()<2){
            throw new InvalidNoOfOperandsException("!= operator needs 2 operands");
        }
        Object one = Helper.getOperandValue(operandList,0);
        Object two = Helper.getOperandValue(operandList,1);
        if(!(one.getClass().toString().equals(two.getClass().toString()))){
            throw new InvalidOperandTypeException(one.getClass().getName(),two.getClass().toString());
        }
        return one.equals(two);
    }

    @Override
    public String[] operatorSymbols() {
        return new String[]{
                "=="
        };
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
