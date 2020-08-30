package com.project.GatingModule.classifiers;

import com.project.GatingModule.constants.RegexConstants;
import com.project.GatingModule.enums.ElementType;

public class StringConstantClassifier implements ElementClassifier {
    @Override
    public ElementType classify(String token) {
        if(token.matches(RegexConstants.STRING_CONSTANT))
            return ElementType.STRING_CONSTANT;
        return ElementType.UNKNOWN;
    }
}
