package com.jackyfan.dsl.controller;

import com.jackyfan.dsl.statemachine.CommandChannel;
import com.jackyfan.dsl.statemachine.State;
import com.jackyfan.dsl.statemachine.StateMachine;

public class Controller {
    private State currentState;
    private final StateMachine machine;
    private final CommandChannel commandChannel;

    public Controller(StateMachine machine, CommandChannel commandChannel) {
        this.machine = machine;
        this.commandChannel = commandChannel;
        this.currentState = machine.getStart();
    }

    public void handle(String eventCode) {
        if (currentState.hasTransition(eventCode)) {
            transitionTo(currentState.targetState(eventCode));
        } else if (machine.isResetEvent(eventCode)) {
            transitionTo(machine.getStart());
            System.out.printf("Unknown %s event,transitionTo start state.", eventCode);
        }
    }

    private void transitionTo(State targetState) {
        currentState = targetState;
        currentState.executeActions(commandChannel);
    }

    public State getCurrentState() {
        return currentState;
    }

}
