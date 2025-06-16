package com.jackyfan.dsl.controller;

import com.jackyfan.dsl.statemachine.Command;
import com.jackyfan.dsl.statemachine.Event;
import com.jackyfan.dsl.statemachine.State;
import com.jackyfan.dsl.statemachine.StateMachine;

public class GrantController {

    public static void main(String[] args) {
        Event drawerOpened = new Event("drawerOpened", "D2OP");
        Event lightOn = new Event("lightOn", "L1ON");
        Event doorOpened = new Event("doorOpened", "D1OP");
        Event panelClosed = new Event("panelClosed", "PNCL");
        Event doorClosed = new Event("doorClosed", "D1CL");
        Command unlockPanelCmd = new Command("unlockPanel", "PNUL");
        Command lockPanelCmd = new Command("lockPanel", "PNLK");
        Command lockDoorCmd = new Command("lockDoor", "D1LK");
        Command unlockDoorCmd = new Command("unlockDoor", "D1UL");
        State idle = new State("idle");
        State activeState = new State("active");
        State waitingForLightState = new State("waitingForLight");
        State waitingForDrawerState = new State("waitingForDrawer");
        State unlockedPanelState = new State("unlockedPanel");
        StateMachine machine = new StateMachine(idle);

        idle.addTransition(doorClosed, activeState);
        idle.addAction(unlockDoorCmd);
        idle.addAction(lockPanelCmd);
        activeState.addTransition(drawerOpened, waitingForLightState);
        activeState.addTransition(lightOn, waitingForDrawerState);
        waitingForLightState.addTransition(lightOn, unlockedPanelState);
        waitingForDrawerState.addTransition(drawerOpened, unlockedPanelState);
        unlockedPanelState.addAction(unlockPanelCmd);
        unlockedPanelState.addAction(lockDoorCmd);
        unlockedPanelState.addTransition(panelClosed, idle);
        machine.addResetEvents(doorOpened);
    }

}
