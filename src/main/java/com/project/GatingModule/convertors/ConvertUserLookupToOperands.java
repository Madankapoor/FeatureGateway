package com.project.GatingModule.convertors;

import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.exceptions.UserPropertyNotFoundException;
import com.project.GatingModule.exceptions.UserPropertyNotPrimitiveTypeException;
import com.project.GatingModule.element.Element;
import com.project.GatingModule.util.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvertUserLookupToOperands {
    private HashMap<String,Object> userProperties;
    public ConvertUserLookupToOperands(HashMap<String,Object> userProperties){
        this.userProperties = userProperties;
    }
    public List<Element> convertUserLookuptoConstantOperands(List<Element> elements) throws UserPropertyNotFoundException, UserPropertyNotPrimitiveTypeException {
        List<Element> substitutedElements = new ArrayList<Element>();
        for(Element element:elements){
            if(element.getType()== ElementType.USER_LOOKUP){
                if(userProperties.containsKey(element.getValue())){
                    Object value = userProperties.get(element.getValue());
                    Element parsedElement = Helper.getPrasedElement(value);
                    if(parsedElement.getType()==ElementType.UNKNOWN)
                    {
                        throw new UserPropertyNotPrimitiveTypeException(element.getValue());
                    }
                    substitutedElements.add(parsedElement);
                }
                else throw new UserPropertyNotFoundException(element.getValue());
            }
            else substitutedElements.add(element);
        }
        return substitutedElements;
    }
}
