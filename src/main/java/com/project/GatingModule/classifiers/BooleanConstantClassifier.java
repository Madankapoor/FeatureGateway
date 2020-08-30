package com.project.GatingModule.classifiers;

import com.project.GatingModule.constants.RegexConstants;
import com.project.GatingModule.enums.ElementType;

public class BooleanConstantClassifier implements ElementClassifier {
    @Override
    public ElementType classify(String token) {
        if(token.matches(RegexConstants.BOOLEAN_CONSTANT))
            return ElementType.BOOLEAN_CONSTANT;
        return ElementType.UNKNOWN;
    }
}