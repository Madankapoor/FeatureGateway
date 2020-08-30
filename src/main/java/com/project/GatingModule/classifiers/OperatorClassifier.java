package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.operators.OperatorRepository;

public class OperatorClassifier implements ElementClassifier {
    private OperatorRepository operatorRepository;
    public  OperatorClassifier(OperatorRepository operatorRepository){
        this.operatorRepository = operatorRepository;
    }
    @Override
    public ElementType classify(String token) {
        if(operatorRepository.isOperator(token))
            return ElementType.OPERATOR;
        return ElementType.UNKNOWN;
    }
}
