package com.project.GatingModule.convertors;

import com.project.GatingModule.element.Element;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.exceptions.InvalidOperatorSymbolException;
import com.project.GatingModule.operators.OperatorRepository;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ConvertInfixToPostfixTest {
    private ConvertInfixToPostfix convertInfixToPostfix;
    public ConvertInfixToPostfixTest(){
        this.convertInfixToPostfix = new ConvertInfixToPostfix(new OperatorRepository());
    }

    @Test
    public void testSimpleInfixToPostfix() throws InvalidOperatorSymbolException {
        List<Element> elementList = new ArrayList();
        elementList.add(new Element("100", ElementType.INTEGER_CONSTANT));
        elementList.add(new Element("==", ElementType.OPERATOR));
        elementList.add(new Element("100", ElementType.INTEGER_CONSTANT));

        List<Element> postFix = convertInfixToPostfix.generatePostFixGeneration(elementList);
        Assert.assertEquals(postFix.get(2).getType(),ElementType.OPERATOR);
    }
}