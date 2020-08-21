package com.project.GatingModule;

import com.project.GatingModule.classifiers.ChainElementClassifier;
import com.project.GatingModule.convertors.InfixToPostfixConverter;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.exceptions.*;
import com.project.GatingModule.operands.ConstantOperandFactory;
import com.project.GatingModule.operators.OperatorRepository;
import com.project.GatingModule.element.Element;
import com.project.GatingModule.element.parsers.ElementParser;
import com.project.GatingModule.element.parsers.DefaultElementParser;
import com.project.GatingModule.convertors.UserLookupToOperandsConverter;
import com.project.GatingModule.util.Helper;

import java.util.*;

public class GatingModule {
    private OperatorRepository operatorRepository;
    private ChainElementClassifier chainElementClassifier;
    private ElementParser elementParser;
    private InfixToPostfixConverter infixToPostfixConverter;

    public GatingModule(){
        // Dependency Injection
        operatorRepository = new OperatorRepository();
        // Element Parser
        elementParser = new DefaultElementParser(operatorRepository);
        // Infix to postfix converter
        infixToPostfixConverter = new InfixToPostfixConverter(operatorRepository);
    }

    public  Boolean IsAllowed(String infixConditionalExpression, HashMap<String,Object> user) {
        try {
            UserLookupToOperandsConverter userLookupToOperandsConverter = new UserLookupToOperandsConverter(user);
            // Parse All elements
            List<Element> elements = elementParser.parseElements(infixConditionalExpression);
            // Substitute User Vars. Convert all lookups to constants
            elements = userLookupToOperandsConverter.convertUserLookuptoConstantOperands(elements);
            // Convert to PostFix
            elements = infixToPostfixConverter.generatePostFixGeneration(elements);
            // Evaluate Expression
            return evaluatePostFixExpression(elements);
        }
        catch (InvalidTokenException | UserPropertyNotFoundException | UserPropertyNotPrimitiveTypeException | InvalidOperatorSymbolException | InvalidOperandTypeException | InvalidNoOfOperandsException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Boolean evaluatePostFixExpression(List<Element> postfix) throws InvalidTokenException, InvalidOperatorSymbolException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Stack<Element> operandStack = new Stack<>();
        for(Element element: postfix){
            switch (element.getType()){
                case SEPARATOR:
                    break;
                case OPERATOR:
                    ArrayList<Element> operands = new ArrayList<>();
                    int operandCount = operatorRepository.getOperandCount(element.getValue());
                    while (!operandStack.empty()){
                        if (Helper.isOpenBracket(operandStack.peek())) {
                            operandStack.pop();
                        }
                        else break;
                    }
                    while (!operandStack.empty()) {
                        Element top = operandStack.peek();
                        operandStack.pop();
                        if (Helper.isOpenBracket(top)) break;
                        operandCount--;
                        operands.add(top);
                        if(operandCount == 0) break;
                    }
                    Collections.reverse(operands);
                    Boolean result = operatorRepository.evaluate(element.getValue(),operands);
                    operandStack.push(new Element(result.toString(), ElementType.BOOLEAN_CONSTANT));
                    break;
                default:
                    operandStack.push(element);
                    break;
            }
        }
        return ConstantOperandFactory.getBooleanValue(operandStack.peek());
    }
}
