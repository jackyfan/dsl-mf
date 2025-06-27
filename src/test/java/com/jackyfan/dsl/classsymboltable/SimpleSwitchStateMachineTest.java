package com.jackyfan.dsl.classsymboltable;

import com.jackyfan.dsl.statemachine.StateMachine;
import org.junit.Test;

public class SimpleSwitchStateMachineTest {
    @Test
    public void test_builder_switch() {
        SimpleSwitchStateMachine machineBuilder = new SimpleSwitchStateMachine();
        StateMachine machine = machineBuilder.build();
        System.out.println(machine.getStart());
        System.out.println(machine.getStates());
    }
}
