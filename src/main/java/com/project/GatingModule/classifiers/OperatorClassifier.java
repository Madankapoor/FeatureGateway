package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.OperatorRepository;

public class OperatorClassifier implements ElementClassifier {
    private OperatorRepository operatorRepository;
    public  OperatorClassifier(OperatorRepository operatorRepository){
        this.operatorRepository = operatorRepository;
    }
    @Override
    public ElementType classify(String token) {

        return ElementType.UNKNOWN;
    }
}
