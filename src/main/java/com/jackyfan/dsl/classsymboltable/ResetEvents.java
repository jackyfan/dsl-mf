package com.jackyfan.dsl.classsymboltable;

import com.jackyfan.dsl.statemachine.Event;

public class ResetEvents extends Identifier {
    private Event event;

    public ResetEvents(String name, StateMachineBuilder builder) {
        super(name, builder);
    }

    Event getEvent() {
        return event;
    }

    public void code(String code) {
        event = new Event(getName(), code);
    }
}
