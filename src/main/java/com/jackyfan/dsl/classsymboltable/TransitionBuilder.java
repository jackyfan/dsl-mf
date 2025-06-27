package com.jackyfan.dsl.classsymboltable;

public class TransitionBuilder {
    private Events trigger;
    private States targetState;
    private States source;

    public TransitionBuilder(States state, Events trigger) {
        this.trigger = trigger;
        this.source = state;
    }

    public States to(States targetState) {
        this.targetState = targetState;
        source.addTransition(this);
        return source;
    }


    void produce() {
        source.getState().addTransition(trigger.getEvent(), targetState.getState());
    }
}
