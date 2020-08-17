package com.project.GatingModule.operators;

import com.project.GatingModule.enums.Separators;
import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.exceptions.InvalidOperatorSymbolException;
import com.project.GatingModule.exceptions.InvalidTokenException;
import com.project.GatingModule.operands.ConstantOperandFactory;
import com.project.GatingModule.operands.Operand;
import com.project.GatingModule.element.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OperatorRepository {
    private List<Operator> operators;
    private HashMap<String, Operator> operatorHashMap;
    public OperatorRepository() {
        operatorHashMap = new HashMap<>();
        operators = new ArrayList<Operator>();
        operators.add(new OrOperator());
        operators.add(new NotOperator());
        operators.add(new AndOperator());
        operators.add(new BetweenOperator());
        operators.add(new AllOfOperator());
        operators.add(new NoneOfOperator());
        operators.add(new LessThanOperator());
        operators.add(new LessThanEqualOperator());
        operators.add(new GreaterThanOperator());
        operators.add(new GreaterThanEqualOperator());
        operators.add(new EqualOperator());
        operators.add(new NotEqualOperator());
        for(Operator operator: operators){
            for(String symbol: operator.operatorSymbols()){
                operatorHashMap.put(symbol,operator);
            }
        }
    }

    public Integer getOperandCount(String s) throws InvalidOperatorSymbolException {
        if(!operatorHashMap.containsKey(s)){
            throw new InvalidOperatorSymbolException();
        }
        return operatorHashMap.get(s).getOperandCount();
    }
    public Boolean isOperator(String s){
        return operatorHashMap.containsKey(s);
    }

    public Integer getPrecedence(String s) throws InvalidOperatorSymbolException {
        if(!operatorHashMap.containsKey(s)){
            throw new InvalidOperatorSymbolException();
        }
        return operatorHashMap.get(s).getPrecedence();
    }

    public Boolean evaluate(String operand,List<Element> elements) throws InvalidOperatorSymbolException, InvalidOperandTypeException, InvalidNoOfOperandsException, InvalidTokenException {
        if(!operatorHashMap.containsKey(operand)){
            throw new InvalidOperatorSymbolException();
        }
        Operator operator = operatorHashMap.get(operand);
        ArrayList<Operand> operands = new ArrayList<Operand>();
        for(Element element: elements){
            operands.add(ConstantOperandFactory.getOperand(element));
        }
        return operator.evaluate(operands);
    }

    public String[] operatorSymbols(){
        return operatorHashMap.keySet().toArray(new String[0]);
    }
}
