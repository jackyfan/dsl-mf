package com.jackyfan.dsl.classsymboltable;

import com.jackyfan.dsl.statemachine.Event;

public class Events extends Identifier {
    private Event event;

    public Events(String name, StateMachineBuilder builder) {
        super(name, builder);
    }

    Event getEvent() {
        return event;
    }
    public void code(String code) {
        event = new Event(getName(), code);
    }
}
