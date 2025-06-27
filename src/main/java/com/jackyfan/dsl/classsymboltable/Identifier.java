package com.jackyfan.dsl.classsymboltable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Identifier {
    private String name;
    protected StateMachineBuilder builder;
    public Identifier(String name, StateMachineBuilder builder) {
        this.name = name;
        this.builder = builder;
    }
    public String getName() {
        return name;
    }
    static Identifier create(Class type, String name, StateMachineBuilder builder)
            throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, InstantiationException {
        Constructor ctor = type.getConstructor(String.class, StateMachineBuilder.class);
        return (Identifier) ctor.newInstance(name, builder);
    }
}
