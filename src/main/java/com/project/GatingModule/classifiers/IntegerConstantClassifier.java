package com.project.GatingModule.classifiers;

import com.project.GatingModule.constants.RegexConstants;
import com.project.GatingModule.enums.ElementType;

public class IntegerConstantClassifier implements ElementClassifier {
    @Override
    public ElementType classify(String token) {
        if(token.matches(RegexConstants.INTEGER_CONSTANT))
            return ElementType.INTEGER_CONSTANT;
        return ElementType.UNKNOWN;
    }
}
