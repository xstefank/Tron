package cz.muni.fi.pv260.control.controller.awt.keyboard;

import cz.muni.fi.pv260.control.controller.InputAction;
import cz.muni.fi.pv260.control.controller.InputController;

import java.awt.event.KeyEvent;
import java.util.Map;

public class KeyboardControllerImpl implements InputController<KeyEvent> {

    private Map<Integer, InputAction<KeyEvent>> keyEvents;

    public KeyboardControllerImpl(Map<Integer, InputAction<KeyEvent>> keyEvents) {
        this.keyEvents = keyEvents;
    }

    @Override
    public void processEvent(KeyEvent event) {
        InputAction<KeyEvent> action = keyEvents.get(event.getKeyCode());

        if (action != null) {
            action.executeAction(event);
        }
    }
}
