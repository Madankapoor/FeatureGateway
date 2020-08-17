package com.project.GatingModule.element.parsers;

import com.project.GatingModule.exceptions.InvalidTokenException;
import com.project.GatingModule.element.Element;

import java.util.List;

public interface ElementParser {
    public List<Element> parseElements(String infixExpression) throws InvalidTokenException;
}
