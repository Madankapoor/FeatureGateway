package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;

public interface ElementClassifier {
    public ElementType classify(String token);
}
