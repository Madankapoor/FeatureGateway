package com.project.GatingModule.classifiers;

import com.project.GatingModule.constants.RegexConstants;
import com.project.GatingModule.enums.ElementType;

public class OperandClassifier implements ElementClassifier {
    @Override
    public ElementType classify(String token) {
        if(token.matches(RegexConstants.USER_LOOKUP))
            return ElementType.USER_LOOKUP;
        return ElementType.UNKNOWN;
    }
}
