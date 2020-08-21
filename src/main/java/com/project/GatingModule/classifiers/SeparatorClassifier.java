package com.project.GatingModule.classifiers;


import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.enums.Separators;

public class SeparatorClassifier implements ElementClassifier {
    @Override
    public ElementType classify(String token) {
        for (Separators s : Separators.values()) {
            if(s.toString().equals(token)) {
               return ElementType.SEPARATOR;
            }
        }
        return ElementType.UNKNOWN;
    }
}
