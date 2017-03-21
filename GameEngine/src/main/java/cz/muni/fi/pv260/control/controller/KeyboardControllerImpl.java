package cz.muni.fi.pv260.control.controller;

import java.awt.event.KeyEvent;
import java.util.Map;

public class KeyboardControllerImpl implements KeyboardController {

    private Map<Integer, KeyboardAction> keyEvents;

    public KeyboardControllerImpl(Map<Integer, KeyboardAction> keyEvents) {
        this.keyEvents = keyEvents;
    }

    @Override
    public void processKeyboardEvent(KeyEvent event) {
        KeyboardAction action = keyEvents.get(event.getKeyCode());

        if (action != null) {
            action.executeAction(event);
        }
    }
}
