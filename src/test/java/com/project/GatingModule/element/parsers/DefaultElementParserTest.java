package com.project.GatingModule.element.parsers;

import com.project.GatingModule.classifiers.ChainElementClassifier;
import com.project.GatingModule.element.Element;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.exceptions.InvalidTokenException;
import com.project.GatingModule.operators.OperatorRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DefaultElementParserTest {
    @Test
    public void testValidExpressionsParsing() throws InvalidTokenException {
        OperatorRepository operatorRepository = new OperatorRepository();
        ChainElementClassifier chainElementClassifier = new ChainElementClassifier(operatorRepository);
        ElementParser elementParser = new DefaultElementParser(chainElementClassifier);


        String[] expressions = new String[]{
                " Age < 100",
                " (Age < 18) && (Address.city == \"Bangalore\" )",
                "(Age "
        };

        List<Element> elements0 = elementParser.parseElements(expressions[0]);
        Assert.assertEquals(ElementType.USER_LOOKUP,elements0.get(0).getType());
        Assert.assertEquals(ElementType.OPERATOR,elements0.get(1).getType());
        Assert.assertEquals(ElementType.INTEGER_CONSTANT,elements0.get(2).getType());

        List<Element> elements1 = elementParser.parseElements(expressions[1]);
        Assert.assertEquals(ElementType.SEPARATOR,elements1.get(0).getType());
        Assert.assertEquals(ElementType.USER_LOOKUP,elements1.get(1).getType());
        Assert.assertEquals(ElementType.OPERATOR,elements1.get(2).getType());
        Assert.assertEquals(ElementType.INTEGER_CONSTANT,elements1.get(3).getType());
        Assert.assertEquals(ElementType.SEPARATOR,elements1.get(4).getType());
        Assert.assertEquals(ElementType.OPERATOR,elements1.get(5).getType());
        Assert.assertEquals(ElementType.SEPARATOR,elements1.get(6).getType());
        Assert.assertEquals(ElementType.USER_LOOKUP,elements1.get(7).getType());
        Assert.assertEquals(ElementType.OPERATOR,elements1.get(8).getType());
        Assert.assertEquals(ElementType.STRING_CONSTANT,elements1.get(9).getType());
        Assert.assertEquals(ElementType.SEPARATOR,elements1.get(10).getType());
    }
}