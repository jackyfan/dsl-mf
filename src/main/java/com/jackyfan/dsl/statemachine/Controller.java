package com.jackyfan.dsl.statemachine;

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
}
