package com.project.GatingModule.convertors;

import com.project.GatingModule.element.Element;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.enums.Separators;
import com.project.GatingModule.exceptions.InvalidOperatorSymbolException;
import com.project.GatingModule.operators.OperatorRepository;
import com.project.GatingModule.util.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfixConverter {
    private OperatorRepository operatorRepository;
    public InfixToPostfixConverter(OperatorRepository operatorRepository){
        this.operatorRepository = operatorRepository;
    }
    public List<Element> generatePostFixGeneration(List<Element> elements) throws InvalidOperatorSymbolException {
        ArrayList<Element> postfix = new ArrayList<Element>();
        Stack<Element> opStack = new Stack<Element>();
        for(Element element: elements){
            switch(element.getType()){
                case OPERATOR:
                    while(!opStack.empty()) {
                        Element top = opStack.peek();
                        if(Helper.isOpenBracket(top))
                        {
                            break;
                        }
                        else{
                            int p1 = operatorRepository.getPrecedence(top.getValue());
                            int p2 = operatorRepository.getPrecedence(element.getValue());
                            if(p1 < p2) {
                                break;
                            }
                        }
                        opStack.pop();
                        postfix.add(top);
                    }
                    opStack.push(element);
                    break;
                case SEPARATOR:
                    if(Helper.isOpenBracket(element)){
                        opStack.push(element);
                    }
                    if(Helper.isClosedBracket(element)){
                        // Pop stack till open bracket
                        while(!opStack.empty()){
                            Element top = opStack.peek();
                            opStack.pop();
                            if(Helper.isOpenBracket(top))
                            {
                                break;
                            }
                            postfix.add(top);
                        }
                    }
                    postfix.add(element);
                    break;
                default:
                    postfix.add(element);
                    break;
            }
        }

        while (!opStack.empty()){
            postfix.add(opStack.peek());
            opStack.pop();
        }
        return postfix;
    }
}
