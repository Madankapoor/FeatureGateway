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

public class NoneOfOperatorTest {
    @Test
    public void testValidNoneOfBooleanToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator noneOfOperator = new NoneOfOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("true", ElementType.BOOLEAN_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        Assert.assertEquals(false,noneOfOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("true", ElementType.BOOLEAN_CONSTANT)));
        Assert.assertEquals(true,noneOfOperator.evaluate(list2));
    }

    @Test
    public void testValidNoneOfStringToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator noneOfOperator = new NoneOfOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("asdf", ElementType.STRING_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("asdfdas", ElementType.STRING_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("asdfasd", ElementType.STRING_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("asdfjlk", ElementType.STRING_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("asdf", ElementType.STRING_CONSTANT)));
        Assert.assertEquals(false,noneOfOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("make", ElementType.STRING_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("made", ElementType.STRING_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("made2", ElementType.STRING_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("made3", ElementType.STRING_CONSTANT)));
        Assert.assertEquals(true,noneOfOperator.evaluate(list2));
    }

    @Test
    public void testValidNoneOfIntegerToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator noneOfOperator = new NoneOfOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090", ElementType.INTEGER_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        Assert.assertEquals(true,noneOfOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        Assert.assertEquals(false,noneOfOperator.evaluate(list2));
    }

    @Test
    public void testValidNoneOfDoubleToken()throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator noneOfOperator = new NoneOfOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.0132", ElementType.DOUBLE_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.0132", ElementType.DOUBLE_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        Assert.assertEquals(false,noneOfOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("1090.00E10", ElementType.DOUBLE_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("1091.00E10", ElementType.DOUBLE_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("10911.00E10", ElementType.DOUBLE_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("12091.00E10", ElementType.DOUBLE_CONSTANT)));
        Assert.assertEquals(true,noneOfOperator.evaluate(list2));
    }
}