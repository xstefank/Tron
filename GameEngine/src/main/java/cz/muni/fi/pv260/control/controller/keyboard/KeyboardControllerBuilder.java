package cz.muni.fi.pv260.control.controller.keyboard;

import cz.muni.fi.pv260.control.controller.InputControllerBuilder;

import java.util.HashMap;
import java.util.Map;

public class KeyboardControllerBuilder implements InputControllerBuilder<KeyboardAction> {

    private Map<Integer, KeyboardAction> keyEvents = new HashMap<>();

    @Override
    public KeyboardControllerBuilder addEvent(int keyCode, KeyboardAction action) {
        keyEvents.putIfAbsent(keyCode, action);
        return this;
    }

    @Override
    public KeyboardControllerImpl build() {
        return new KeyboardControllerImpl(keyEvents);
    }

}
