package com.project.GatingModule.convertors;

import com.project.GatingModule.element.Element;
import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.exceptions.UserPropertyNotFoundException;
import com.project.GatingModule.exceptions.UserPropertyNotPrimitiveTypeException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvertUserLookupToOperandsTest {

    @Test
    public void testSubstitutionUserLookup() throws UserPropertyNotPrimitiveTypeException, UserPropertyNotFoundException {
        HashMap<String,Object> userMap = new HashMap<>();
        userMap.put("Age",20);
        userMap.put("Address.street","Gandhi Street");
        userMap.put("Address.no",37);
        ConvertUserLookupToOperands convertor = new ConvertUserLookupToOperands(userMap);

        List<Element> elements = new ArrayList<>();
        elements.add(new Element("Age", ElementType.USER_LOOKUP));
        elements.add(new Element("<", ElementType.OPERATOR));
        elements.add(new Element("Address.no", ElementType.INTEGER_CONSTANT));

        List<Element> substitutedList = convertor.convertUserLookuptoConstantOperands(elements);
        Assert.assertEquals(substitutedList.get(0).getType(),ElementType.INTEGER_CONSTANT);
        Assert.assertEquals(substitutedList.get(2).getType(),ElementType.INTEGER_CONSTANT);
    }
}