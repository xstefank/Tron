package cz.muni.fi.pv260.control.controller.awt.keyboard;

import cz.muni.fi.pv260.control.controller.InputAction;
import cz.muni.fi.pv260.control.controller.InputControllerBuilder;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyboardControllerBuilder implements InputControllerBuilder<InputAction<KeyEvent>> {

    private Map<Integer, InputAction<KeyEvent>> keyEvents = new HashMap<>();

    @Override
    public KeyboardControllerBuilder addEvent(int keyCode, InputAction<KeyEvent> action) {
        keyEvents.putIfAbsent(keyCode, action);
        return this;
    }

    @Override
    public KeyboardControllerImpl build() {
        return new KeyboardControllerImpl(keyEvents);
    }

}
