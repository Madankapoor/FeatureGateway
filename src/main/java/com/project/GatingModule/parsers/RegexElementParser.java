package com.project.GatingModule.parsers;

import com.project.GatingModule.classifiers.ElementClassifier;
import com.project.GatingModule.constants.RegexConstants;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.exceptions.InvalidTokenException;

import java.util.ArrayList;
import java.util.List;

public class RegexElementParser implements ElementParser {
    private ElementClassifier elementClassifier;
    public RegexElementParser(ElementClassifier elementClassifier){
        this.elementClassifier = elementClassifier;
    }
    public List<Element> parseElements(String infixExpression) throws InvalidTokenException {
        String[] tokens = infixExpression.split(RegexConstants.ANY_WHITESPACE);
        ArrayList<Element> elements = new ArrayList<Element>();
        for(String token: tokens){
            ElementType type = elementClassifier.classify(token);
            if(type == ElementType.UNKNOWN){
                throw new InvalidTokenException(token);
            }
            elements.add(new Element(token,type));
        }
        return elements;
    }
}
