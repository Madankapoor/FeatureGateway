package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import org.junit.Assert;
import org.junit.Test;

public class StringConstantClassifierTest {
    @Test
    public void testValidStringConstantTokens(){
        ElementClassifier elementClassifier = new StringConstantClassifier();
        for(String s:new String[]{"\"asdfasdf\"","\"asdfaasdfasdfsdf\""}){
            Assert.assertEquals(ElementType.STRING_CONSTANT,elementClassifier.classify(s));
        }
    }

    @Test
    public void testInvalidStringConstantTokens(){
        ElementClassifier elementClassifier = new StringConstantClassifier();
        for(String s:new String[]{"\"asdfasdf","asdfaasdfasdfsdf\""}){
            Assert.assertEquals(ElementType.UNKNOWN,elementClassifier.classify(s));
        }
    }
}