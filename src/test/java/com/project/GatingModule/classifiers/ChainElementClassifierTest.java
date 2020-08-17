package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.enums.Separators;
import com.project.GatingModule.operators.OperatorRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChainElementClassifierTest {
    @Test
    public void testValidTokens(){
        OperatorRepository operatorRepository = new OperatorRepository();
        ElementClassifier elementClassifier = new ChainElementClassifier(operatorRepository);
        for(String op:new String[]{
                "OR",
                "AND",
                "<",
                ">",
                "||",
                "=="
        }){
            Assert.assertEquals(ElementType.OPERATOR,elementClassifier.classify(op));
        }

        String[] tokens = new String[]{ "10.0", "-0.123", "10.0e10","-901.012e20" };
        for(String token: tokens){
            Assert.assertEquals(ElementType.DOUBLE_CONSTANT,elementClassifier.classify(token));
        }

        for (String s : new String[]{"Age","Address.city","Name","Address.street"}) {
            Assert.assertEquals(ElementType.USER_LOOKUP,elementClassifier.classify(s));
        }

        for (Separators s : Separators.values()) {
            Assert.assertEquals(ElementType.SEPARATOR,elementClassifier.classify(s.toString()));
        }

        for(String s:new String[]{"\"asdfasdf\"","\"asdfaasdfasdfsdf\""}){
            Assert.assertEquals(ElementType.STRING_CONSTANT,elementClassifier.classify(s));
        }

        String[] booleanTokens = new String[]{ "true","TRUE","false","FALSE"};
        for(String token: booleanTokens){
            Assert.assertEquals( ElementType.BOOLEAN_CONSTANT,elementClassifier.classify(token));
        }
    }

}