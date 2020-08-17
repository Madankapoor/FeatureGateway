package com.project.GatingModule.element.parsers;

import com.project.GatingModule.classifiers.ElementClassifier;
import com.project.GatingModule.constants.RegexConstants;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.enums.Separators;
import com.project.GatingModule.exceptions.InvalidTokenException;
import com.project.GatingModule.element.Element;

import java.util.*;
import java.util.regex.Pattern;

public class DefaultElementParser implements ElementParser {
    private ElementClassifier elementClassifier;
    public DefaultElementParser(ElementClassifier elementClassifier){
        this.elementClassifier = elementClassifier;
    }
    public List<Element> parseElements(String infixExpression) throws InvalidTokenException {
        /*
         *  Split by space and parse all then classify.
         *  For Tokens not Classified: Split with Constants Regex and classify
         *  For Tokens not Classified: Split with separators,Operators and classify
         */
        String[] tokens = getTokens(infixExpression);
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

    private String[] getTokens(String infixExpression){
        ArrayList<String> delimiters = new ArrayList<>();
        ArrayList<String> inputTokens = new ArrayList<>();
        Collections.addAll(inputTokens, infixExpression.trim().split(RegexConstants.ANY_WHITESPACE));
        for(Separators s: Separators.values())
        {
            delimiters.add(s.toString());
        }
        ArrayList<String> tokens = splitTokens(inputTokens,delimiters);
        return tokens.toArray(new String[0]);
    }

    private ArrayList<String> splitTokens(ArrayList<String> src,ArrayList<String> delimiters,Boolean quote){
        for(String delimiter: delimiters){
            ArrayList<String> dst = new ArrayList<>();
            for(String token:src) {
                String quoted_delimiter = quote ? Pattern.quote(delimiter) : delimiter;
                String regexExp = String.format(RegexConstants.WITH_DELIMITER, quoted_delimiter);
                Collections.addAll(dst, token.split(regexExp));
            }
            src = dst;
        }
        return src;
    }
}
