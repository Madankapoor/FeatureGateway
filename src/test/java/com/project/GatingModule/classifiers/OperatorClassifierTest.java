package com.project.GatingModule.classifiers;

import com.project.GatingModule.enums.ElementType;
import com.project.GatingModule.operators.OperatorRepository;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorClassifierTest {
    @Test
    public void testValidOperators(){
        OperatorRepository operatorRepository = new OperatorRepository();
        ElementClassifier elementClassifier = new OperatorClassifier(operatorRepository);
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
    }

}