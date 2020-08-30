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

public class NotEqualOperatorTest {
    @Test
    public void testValidNotEqualBooleanToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator notEqualOperator = new NotEqualOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("true", ElementType.BOOLEAN_CONSTANT)));
        Assert.assertEquals(true,notEqualOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("false", ElementType.BOOLEAN_CONSTANT)));
        Assert.assertEquals(false,notEqualOperator.evaluate(list2));
    }

    @Test
    public void testValidNotEqualStringToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator notEqualOperator = new NotEqualOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("asdf", ElementType.STRING_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("asdf", ElementType.STRING_CONSTANT)));
        Assert.assertEquals(false,notEqualOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("make", ElementType.STRING_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("made", ElementType.STRING_CONSTANT)));
        Assert.assertEquals(true,notEqualOperator.evaluate(list2));
    }

    @Test
    public void testValidNotEqualIntegerToken() throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator notEqualOperator = new NotEqualOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090", ElementType.INTEGER_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090", ElementType.INTEGER_CONSTANT)));
        Assert.assertEquals(false,notEqualOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("1090", ElementType.INTEGER_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("1091", ElementType.INTEGER_CONSTANT)));
        Assert.assertEquals(true,notEqualOperator.evaluate(list2));
    }

    @Test
    public void testValidNotEqualDoubleToken()throws InvalidTokenException, InvalidOperandTypeException, InvalidNoOfOperandsException {
        Operator notEqualOperator = new NotEqualOperator();
        ArrayList<Operand> list1 = new ArrayList<Operand>();
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        list1.add(ConstantOperandFactory.getOperand(new Element("-1090.012", ElementType.DOUBLE_CONSTANT)));
        Assert.assertEquals(false,notEqualOperator.evaluate(list1));

        ArrayList<Operand> list2 = new ArrayList<Operand>();
        list2.add(ConstantOperandFactory.getOperand(new Element("1090.00E10", ElementType.DOUBLE_CONSTANT)));
        list2.add(ConstantOperandFactory.getOperand(new Element("1091.00E10", ElementType.DOUBLE_CONSTANT)));
        Assert.assertEquals(true,notEqualOperator.evaluate(list2));
    }
}