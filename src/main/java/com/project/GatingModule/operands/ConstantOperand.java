package com.project.GatingModule.operands;

import java.lang.Class;

public class ConstantOperand<T>  implements Operand {
    private T value;

    public ConstantOperand(T t) {
        this.value = t;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public Class getType() {
        return value.getClass();
    }
}
