package com.jackyfan.dsl.statemachine;

public class Command extends AbstractEvent{
    public Command(String code, String name) {
        super(code, name);
    }
}
