package com.jackyfan.dsl.statemachine;

import java.util.*;

public class State {
    private String name;
    private String code;
    private List<Command> commands = new ArrayList<Command>();
    private Map<String, Transition> transitions = new HashMap<String, Transition>();

    public State(String name) {
        this.name = name;
    }

    public State(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void addTransition(Event event, State tragetState) {
        transitions.put(event.getCode(), new Transition(this, event, tragetState));
    }

    public void addAction(Command command) {
        commands.add(command);
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

    public void executeActions(CommandChannel commandChannel) {
        for (Command c : commands) {
            commandChannel.send(c.getCode());
        }
    }

    public String getName() {
        return name;
    }


}
