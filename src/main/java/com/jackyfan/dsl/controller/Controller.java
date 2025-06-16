package com.jackyfan.dsl.controller;

import com.jackyfan.dsl.statemachine.CommandChanel;
import com.jackyfan.dsl.statemachine.State;
import com.jackyfan.dsl.statemachine.StateMachine;

public class Controller {
    private State currentState;
    private StateMachine machine;
    private CommandChanel commandChanel;

    public CommandChanel getCommandChanel() {
        return commandChanel;
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
        currentState.executeActions(commandChanel);
    }

    public void setMachine(StateMachine machine) {
        this.machine = machine;
    }

    public void setCommandChanel(CommandChanel commandChanel) {
        this.commandChanel = commandChanel;
    }
}
