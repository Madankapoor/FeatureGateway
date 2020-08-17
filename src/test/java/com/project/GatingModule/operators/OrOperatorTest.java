package com.project.GatingModule.operators;

import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.exceptions.InvalidTokenException;
import com.project.GatingModule.operands.ConstantOperandFactory;
import com.project.GatingModule.operands.Operand;
import com.project.GatingModule.element.Element;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class OrOperatorTest {
    @Test
    public void testValidExpressions() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator orOperator = new OrOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("true", ElementType.BOOLEAN_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        Assert.assertEquals(true,orOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        Assert.assertEquals(false,orOperator.evaluate(list2));
    }

}