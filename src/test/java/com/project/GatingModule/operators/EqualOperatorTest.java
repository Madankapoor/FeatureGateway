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

public class EqualOperatorTest {
    @Test
    public void testValidEqualBooleanToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator equalOperator = new EqualOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("true", ElementType.BOOLEAN_CONSTANT)));
        Assert.assertEquals(false,equalOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        Assert.assertEquals(true,equalOperator.evaluate(list2));
    }

    @Test
    public void testValidEqualStringToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator equalOperator = new EqualOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("asdf", ElementType.STRING_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("asdf", ElementType.STRING_CONSTANT)));
        Assert.assertEquals(true,equalOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("make", ElementType.STRING_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("made", ElementType.STRING_CONSTANT)));
        Assert.assertEquals(false,equalOperator.evaluate(list2));
    }

    @Test
    public void testValidEqualIntegerToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator equalOperator = new EqualOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090", ElementType.INTEGER_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090", ElementType.INTEGER_CONSTANT)));
        Assert.assertEquals(true,equalOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("1091", ElementType.INTEGER_CONSTANT)));
        Assert.assertEquals(false,equalOperator.evaluate(list2));
    }

    @Test
    public void testValidEqualDoubleToken()throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator equalOperator = new EqualOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        Assert.assertEquals(true,equalOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("1090.00E10", ElementType.DOUBLE_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("1091.00E10", ElementType.DOUBLE_CONSTANT)));
        Assert.assertEquals(false,equalOperator.evaluate(list2));
    }
}