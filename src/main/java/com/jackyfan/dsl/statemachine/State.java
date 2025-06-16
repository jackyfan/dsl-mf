package com.jackyfan.dsl.statemachine;

import java.util.*;

public class State {
    private String name;
    private List<Command> commands = new ArrayList<Command>();
    private Map<String, Transition> transitions = new HashMap<String, Transition>();


    public void addTransition(Event event, State tragetState) {
        assert null != tragetState;
        transitions.put(event.getCode(), new Transition(this, event, tragetState));
    }

    public Collection<State> getAllTargets() {
        List<State> result = new ArrayList<State>();
        for (Transition t : transitions.values()) {
            result.add(t.getTarget());
        }
        return result;
    }

    public boolean hasTransition(String eventCode) {
        return transitions.containsKey(eventCode);
    }

    public State targetState(String eventCode) {
        return transitions.get(eventCode).getTarget();
    }

    public void executeActions(CommandChanel commandChanel) {
        for (Command c : commands) {
            commandChanel.send(c.getCode());
        }
    }


}
