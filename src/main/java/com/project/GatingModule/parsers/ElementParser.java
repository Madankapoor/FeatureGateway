package com.project.GatingModule.parsers;

import com.project.GatingModule.exceptions.InvalidTokenException;

import java.util.List;

public interface ElementParser {
    public List<Element> parseElements(String infixExpression) throws InvalidTokenException;
}
