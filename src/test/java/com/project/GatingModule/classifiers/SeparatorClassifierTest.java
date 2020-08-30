package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.enums.Separators;
import org.junit.Assert;
import org.junit.Test;


public class SeparatorClassifierTest {
    @Test
    public void testValidSeparatorTokens(){
        ElementClassifier elementClassifier = new SeparatorClassifier();
        for (Separators s : Separators.values()) {
            Assert.assertEquals(ElementType.SEPARATOR,elementClassifier.classify(s.toString()));
        }
    }

    @Test
    public void testInValidSeparatorTokens(){
        ElementClassifier elementClassifier = new SeparatorClassifier();
        for (String s : new String[]{"^","&^"}) {
            Assert.assertEquals(ElementType.UNKNOWN,elementClassifier.classify(s));
        }
    }
}