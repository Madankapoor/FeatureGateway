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

import static org.junit.Assert.*;

public class AllOfOperatorTest {
    @Test
    public void testValidAllOfBooleanToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator allOfOperator = new AllOfOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        Assert.assertEquals(true,allOfOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("true", ElementType.BOOLEAN_CONSTANT)));
        Assert.assertEquals(false,allOfOperator.evaluate(list2));
    }

    @Test
    public void testValidAllOfStringToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator allOfOperator = new AllOfOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("asdf", ElementType.STRING_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("asdfdas", ElementType.STRING_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("asdfasd", ElementType.STRING_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("asdfjlk", ElementType.STRING_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("asdf", ElementType.STRING_CONSTANT)));
        Assert.assertEquals(false,allOfOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("make", ElementType.STRING_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("make", ElementType.STRING_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("make", ElementType.STRING_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("make", ElementType.STRING_CONSTANT)));
        Assert.assertEquals(true,allOfOperator.evaluate(list2));
    }

    @Test
    public void testValidAllOfIntegerToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator allOfOperator = new AllOfOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090", ElementType.INTEGER_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        Assert.assertEquals(false,allOfOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        Assert.assertEquals(true,allOfOperator.evaluate(list2));
    }

    @Test
    public void testValidAllOfDoubleToken()throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator allOfOperator = new AllOfOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        Assert.assertEquals(true,allOfOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("1090.00E10", ElementType.DOUBLE_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("1091.00E10", ElementType.DOUBLE_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("10911.00E10", ElementType.DOUBLE_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("12091.00E10", ElementType.DOUBLE_CONSTANT)));
        Assert.assertEquals(false,allOfOperator.evaluate(list2));
    }
}