package com.jackyfan.dsl.statemachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StateMachine {
    private final State start;
    private final List<Event> resetEvents = new ArrayList<Event>();

    public StateMachine(State start) {
        this.start = start;
    }

    public Collection<State> getStates() {
        List<State> result = new ArrayList<State>();
        collectStates(result, start);
        return result;
    }

    private void collectStates(Collection<State> result, State s) {
        if (result.contains(s)) return;
        result.add(s);
        for (State next : s.getAllTargets()) {
            collectStates(result, next);
        }
    }

    public void addResetEvents(Event... events) {
        resetEvents.addAll(Arrays.asList(events));
    }

    public boolean isResetEvent(String eventCode) {
        return resetEventCodes().contains(eventCode);
    }

    private List<String> resetEventCodes() {
        List<String> result = new ArrayList<String>();
        for (Event e : resetEvents) {
            result.add(e.getCode());
        }
        return result;
    }

    public State getStart() {
        return start;
    }

}
