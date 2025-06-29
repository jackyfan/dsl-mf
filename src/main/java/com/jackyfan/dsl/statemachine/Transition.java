package com.jackyfan.dsl.statemachine;

public class Transition {
    private final State source;
    private final State target;
    private final Event trigger;

    public Transition(State source, Event trigger, State target) {
        this.source = source;
        this.target = target;
        this.trigger = trigger;
    }

    public State getSource() {
        return source;
    }

    public Event getTrigger() {
        return trigger;
    }

    public State getTarget() {
        return target;
    }

    public String getEventCode() {
        return trigger.getCode();
    }
}
