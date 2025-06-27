package com.jackyfan.dsl.classsymboltable;

/**
 * 简单开关
 */
public class SimpleSwitchStateMachine extends StateMachineBuilder {
    Events switchUp, switchDown;
    States on, off;

    protected void defineStateMachine() {
        on.transition(switchDown).to(off);
        off.transition(switchUp).to(on);
    }
}
