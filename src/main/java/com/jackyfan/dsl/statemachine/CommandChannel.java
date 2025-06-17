package com.jackyfan.dsl.statemachine;

public class CommandChannel {
    public void send(String code) {
        System.out.printf("send %s command.%n", code);
    }

    public void clearHistory() {
        System.out.printf("clearHistory.%n");
    }
}
