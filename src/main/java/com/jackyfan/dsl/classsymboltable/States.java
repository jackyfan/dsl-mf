package com.jackyfan.dsl.classsymboltable;

import com.jackyfan.dsl.statemachine.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class States extends Identifier {
    private State content;
    private final List<TransitionBuilder> transitions = new ArrayList<TransitionBuilder>();
    private final List<Commands> commands = new ArrayList<Commands>();

    public States(String name, StateMachineBuilder builder) {
        super(name, builder);
        content = new State(name);
    }

    State getState() {
        return content;
    }

    public void code(String code) {
        content = new State(getName(), code);
    }

    public States actions(Commands... identifiers) {
        builder.definingState(this);
        commands.addAll(Arrays.asList(identifiers));
        return this;
    }

    public States transition(Events events) {
        //todo
        return this;
    }

    public States to(States states) {
        //todo
        return this;
    }

    public void produce() {
        //todo
    }

    public void addTransition(TransitionBuilder transitionBuilder) {
        transitions.add(transitionBuilder);
    }
}
