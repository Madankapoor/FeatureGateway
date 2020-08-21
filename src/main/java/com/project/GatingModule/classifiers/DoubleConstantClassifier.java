package com.project.GatingModule.classifiers;

import com.project.GatingModule.constants.RegexConstants;
import com.project.GatingModule.enums.ElementType;

public class DoubleConstantClassifier implements ElementClassifier {
    @Override
    public ElementType classify(String token) {
        if(token.matches(RegexConstants.DOUBLE_CONSTANT))
            return ElementType.DOUBLE_CONSTANT;
        return ElementType.UNKNOWN;
    }
}
