package com.project.GatingModule.element;

import com.project.GatingModule.enums.ElementType;

public class Element {
    private  String value;
    private ElementType type;

    public Element(String value, ElementType type){
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public ElementType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
