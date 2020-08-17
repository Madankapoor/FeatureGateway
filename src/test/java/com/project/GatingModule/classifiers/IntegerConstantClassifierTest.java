package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import org.junit.Assert;
import org.junit.Test;

public class IntegerConstantClassifierTest {
    @Test
    public void testValidIntegerTokens(){
        ElementClassifier elementClassifier = new IntegerConstantClassifier();
        String[] tokens = new String[]{ "10", "-809810234", "0","809123" };
        for(String token: tokens){
            Assert.assertEquals(ElementType.INTEGER_CONSTANT,elementClassifier.classify(token));
        }
    }

    @Test
    public void testInValidIntegersTokens(){
        ElementClassifier elementClassifier = new IntegerConstantClassifier();
        String[] tokens = new String[]{ "1asdf.0", "-0.asdf123", "10.0sde10","-9asd01.012asdf20" };
        for(String token: tokens){
            Assert.assertEquals(ElementType.UNKNOWN,elementClassifier.classify(token));
        }
    }
}