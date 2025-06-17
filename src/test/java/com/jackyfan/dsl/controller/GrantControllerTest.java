package com.jackyfan.dsl.controller;

import com.jackyfan.dsl.statemachine.State;
import org.junit.Test;


public class GrantControllerTest {
    @Test
    public void testGrant() throws Exception {
        Controller controller =GrantController.createDefaultController();
        controller.handle("doorClosed");
        State currentState = controller.getCurrentState();
        System.out.printf("CurrentState %s",currentState.getName());
    }
}
