package com.project.GatingModule.element.parsers;

import com.project.GatingModule.classifiers.ChainElementClassifier;
import com.project.GatingModule.classifiers.ElementClassifier;
import com.project.GatingModule.constants.RegexConstants;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.enums.Separators;
import com.project.GatingModule.exceptions.InvalidTokenException;
import com.project.GatingModule.element.Element;
import com.project.GatingModule.operators.OperatorRepository;
import com.project.GatingModule.util.Helper;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultElementParser implements ElementParser {
    private ElementClassifier elementClassifier;
    private OperatorRepository operatorRepository;
    public DefaultElementParser(OperatorRepository operatorRepository){
        this.operatorRepository = operatorRepository;
        this.elementClassifier  = new ChainElementClassifier(operatorRepository);
    }
    public List<Element> parseElements(String infixExpression) throws InvalidTokenException {
        /*
         *  1. Split by space and parse all then classify.
         *  2. For Tokens not Classified: Split with Constants Regex and classify
         *  3. For Tokens not Classified: Split with separators and classify
         */
        ArrayList<Element> elements = new ArrayList<Element>();
        // Split by space and parse all then classify.
        for(String token: infixExpression.trim().split(RegexConstants.ANY_WHITESPACE)){
            ElementType type = elementClassifier.classify(token);
            elements.add(new Element(token,type));
        }
        // Split with Separators, then classify.
        elements = splitAndClassifyTokens(elements, new String[]{
                Separators.OPEN_ANGLE_BRACKET.toString(),
                Separators.CLOSE_ANGLE_BRACKET.toString()
        },true);
        // Split with Constant Regex and Classify
        elements = splitAndClassifyTokens(elements,new String[]{
                RegexConstants.STRING_CONSTANT,
                RegexConstants.DOUBLE_CONSTANT,
                RegexConstants.INTEGER_CONSTANT
        },false);
        // Split with Operators, then classify.
        elements = splitAndClassifyTokens(elements,operatorRepository.operatorSymbols(),true);
        // Check for UNKNOWN tokens and throw exception.
        for(Element element: elements){
            if(element.getType() == ElementType.UNKNOWN){
                throw new InvalidTokenException(element.getValue());
            }
        }
        return elements;
    }

    private ArrayList<Element> splitAndClassifyTokens(ArrayList<Element> src,String[] regex,Boolean quote){
        for(String pattern: regex){
            Pattern p = quote ? Pattern.compile(Pattern.quote(pattern)) : Pattern.compile(pattern);
            ArrayList<Element> dst = new ArrayList<>();
            for(Element element : src)
            {
                String token = element.getValue();
                if(element.getType() == ElementType.UNKNOWN){
                    for(String value: Helper.regexSplit(token,p)){
                        ElementType type = elementClassifier.classify(value);
                        dst.add(new Element(value,type));
                    }
                }
                else dst.add(element);
            }
            src = dst;
        }
        return src;
    }
}
