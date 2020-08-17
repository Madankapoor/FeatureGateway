package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import org.junit.Assert;
import org.junit.Test;

public class BooleanConstantClassifierTest {

    @Test
    public void testValidBooleanTokens(){
        ElementClassifier elementClassifier = new BooleanConstantClassifier();
        String[] booleanTokens = new String[]{ "true","TRUE","false","FALSE"};
        for(String token: booleanTokens){
            Assert.assertEquals( ElementType.BOOLEAN_CONSTANT,elementClassifier.classify(token));
        }
    }

    @Test
    public void testInValidBooleanTokens(){
        ElementClassifier elementClassifier = new BooleanConstantClassifier();
        String[] nonBooleanTokens = new String[]{ "teas","fase"};
        for(String token: nonBooleanTokens){
            Assert.assertEquals(ElementType.UNKNOWN,elementClassifier.classify(token));
        }
    }
}