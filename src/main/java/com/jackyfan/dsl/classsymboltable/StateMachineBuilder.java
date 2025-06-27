package com.jackyfan.dsl.classsymboltable;

import com.jackyfan.dsl.statemachine.Event;
import com.jackyfan.dsl.statemachine.State;
import com.jackyfan.dsl.statemachine.StateMachine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class StateMachineBuilder {
    private State start;

    public StateMachine build() {
        initializeIdentifiers(Events.class, Commands.class, States.class, ResetEvents.class);
        defineStateMachine();
        return produceStateMachine();
    }

    abstract protected void defineStateMachine();

    private void initializeIdentifiers(Class... identifierClasses) {
        List<Class> identifierList = Arrays.asList(identifierClasses);
        for (Field f : this.getClass().getDeclaredFields()) {
            try {
                if (identifierList.contains(f.getType())) {
                    f.setAccessible(true);
                    f.set(this, Identifier.create(f.getType(), f.getName(), this));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private StateMachine produceStateMachine() {
        assert null != start;
        StateMachine result = new StateMachine(start);
        for (States s : getStateIdentifiers())
            s.produce();
        produceResetEvents(result);
        return result;
    }

    private List<States> getStateIdentifiers() {
        return getIdentifiers(States.class);
    }

    private <T extends Identifier> List<T> getIdentifiers(Class<T> klass) {
        List<T> result = new ArrayList<T>();
        for (Field f : this.getClass().getDeclaredFields()) {
            if (f.getType().equals(klass))
                try {
                    f.setAccessible(true);
                    result.add(((T) f.get(this)));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
        }
        return result;
    }

    private void produceResetEvents(StateMachine result) {
        result.addResetEvents(getResetEvents());
    }

    private Event[] getResetEvents() {
        List<Event> result = new ArrayList<Event>();
        for (Events identifier : getIdentifiers(Events.class))
            result.add(identifier.getEvent());
        return result.toArray(new Event[result.size()]);
    }

    protected void definingState(States identifier) {
        if (null == start) start = identifier.getState();
    }
}
