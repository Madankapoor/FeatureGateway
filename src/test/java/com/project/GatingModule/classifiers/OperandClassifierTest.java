package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import org.junit.Assert;
import org.junit.Test;

public class OperandClassifierTest {
    @Test
    public void testValidOperandTokens(){
        ElementClassifier elementClassifier = new OperandClassifier();
        for (String s : new String[]{"Age","Address.city","Name","Address.street"}) {
            Assert.assertEquals(ElementType.USER_LOOKUP,elementClassifier.classify(s));
        }
    }
}