package com.jackyfan.dsl.classsymboltable;

import com.jackyfan.dsl.statemachine.Command;
import com.jackyfan.dsl.statemachine.Event;

public class Commands extends Identifier {
    private Command command;

    public Commands(String name, StateMachineBuilder builder) {
        super(name, builder);
    }

    Command getCommand() {
        return command;
    }

    public void code(String code) {
        command = new Command(getName(), code);
    }
}
