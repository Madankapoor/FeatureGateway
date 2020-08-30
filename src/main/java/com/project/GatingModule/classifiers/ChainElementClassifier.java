package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.operators.OperatorRepository;

import java.util.ArrayList;
import java.util.List;

public class ChainElementClassifier implements ElementClassifier {
    private List<ElementClassifier> elementClassifiers;

    public ChainElementClassifier(OperatorRepository operatorRepository){
        elementClassifiers = new ArrayList<ElementClassifier>();
        elementClassifiers.add(new SeparatorClassifier());
        elementClassifiers.add(new OperatorClassifier(operatorRepository));
        elementClassifiers.add(new StringConstantClassifier());
        elementClassifiers.add(new IntegerConstantClassifier());
        elementClassifiers.add(new DoubleConstantClassifier());
        elementClassifiers.add(new BooleanConstantClassifier());
        elementClassifiers.add(new OperandClassifier());
    }

    public ElementType classify(String token) {
        for(ElementClassifier elementClassifier : elementClassifiers){
            ElementType type = elementClassifier.classify(token);
            if(type != ElementType.UNKNOWN)
                return type;
        }
        return ElementType.UNKNOWN;
    }
}
