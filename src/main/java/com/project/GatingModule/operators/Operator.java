package com.project.GatingModule.operators;

import com.project.GatingModule.operands.Operand;

import java.util.List;

public interface Operator {
    Boolean  evaluate(List<Operand> operandList);
    String[] operatorSymbols();
    Integer  getPrecedence();
}
