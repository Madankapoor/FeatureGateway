package com.project.GatingModule.operators;

import com.project.GatingModule.element.Element;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.exceptions.InvalidNoOfOperandsException;
import com.project.GatingModule.exceptions.InvalidOperandTypeException;
import com.project.GatingModule.exceptions.InvalidTokenException;
import com.project.GatingModule.operands.ConstantOperandFactory;
import com.project.GatingModule.operands.Operand;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class LessThanOperatorTest {
    @Test
    public void testValidIntegerToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator lessThanOperator = new LessThanOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090", ElementType.INTEGER_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        Assert.assertEquals(true,lessThanOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        Assert.assertEquals(false,lessThanOperator.evaluate(list2));
    }

    @Test
    public void testValidDoubleToken()throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator lessThanOperator = new LessThanOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("1090.012", ElementType.DOUBLE_CONSTANT)));
        Assert.assertEquals(true,lessThanOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("1090.00E10", ElementType.DOUBLE_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("1090.00E10", ElementType.DOUBLE_CONSTANT)));
        Assert.assertEquals(false,lessThanOperator.evaluate(list2));
    }
}