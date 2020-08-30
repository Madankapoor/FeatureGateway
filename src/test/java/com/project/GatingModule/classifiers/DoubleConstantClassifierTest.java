package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import org.junit.Assert;
import org.junit.Test;

public class DoubleConstantClassifierTest {
    @Test
    public void testValidDoubleTokens(){
        ElementClassifier elementClassifier = new DoubleConstantClassifier();
        String[] tokens = new String[]{ "10.0", "-0.123", "10.0e10","-901.012e20" };
        for(String token: tokens){
            Assert.assertEquals(ElementType.DOUBLE_CONSTANT,elementClassifier.classify(token));
        }
    }

    @Test
    public void testInValidDoubleTokens(){
        ElementClassifier elementClassifier = new DoubleConstantClassifier();
        String[] tokens = new String[]{ "1asdf.0", "-0.asdf123", "10.0sde10","-9asd01.012asdf20" };
        for(String token: tokens){
            Assert.assertEquals(ElementType.UNKNOWN,elementClassifier.classify(token));
        }
    }


}