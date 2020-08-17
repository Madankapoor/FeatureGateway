package com.project.GatingModule.operators;

import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.operands.Operand;

import java.util.List;

public interface Operator {
    Boolean  evaluate(List<Operand> operandList) throws InvalidNoOfOperandsException, InvalidOperandTypeException;
    String[] operatorSymbols();
    Integer  getPrecedence();
    Integer  getOperandCount();
}
