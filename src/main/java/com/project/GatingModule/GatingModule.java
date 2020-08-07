package com.project.GatingModule;

import com.project.GatingModule.classifiers.ChainElementClassifier;
import com.project.GatingModule.exceptions.InvalidTokenException;
import com.project.GatingModule.parsers.Element;
import com.project.GatingModule.parsers.ElementParser;
import com.project.GatingModule.parsers.RegexElementParser;

import java.util.HashMap;
import java.util.List;

public class GatingModule {
    private OperatorRepository operatorRepository;
    private ChainElementClassifier chainElementClassifier;
    private ElementParser elementParser;
    public GatingModule(){
        // Dependency Injection
        operatorRepository = new OperatorRepository();
        // Element Classifier
        chainElementClassifier = new ChainElementClassifier(operatorRepository);
        // Element Parser
        elementParser = new RegexElementParser(chainElementClassifier);

    }
    public  Boolean IsAllowed(String infixConditionalExpression, HashMap<String,Object> user) {
        try {
            // Parse All elements
            List<Element> elements = elementParser.parseElements(infixConditionalExpression);
            // Substitute User Vars

            // Convert to PostFix

            // Evaluate Expression
        }
        catch (InvalidTokenException e) {
            e.printStackTrace();
        }
        return false;
    }
}
