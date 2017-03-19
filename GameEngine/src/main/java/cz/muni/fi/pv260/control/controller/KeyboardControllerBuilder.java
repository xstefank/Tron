package cz.muni.fi.pv260.control.controller;

import java.util.HashMap;
import java.util.Map;

public class KeyboardControllerBuilder {

    private Map<Integer, KeyboardAction> keyEvents = new HashMap<>();

    public KeyboardControllerBuilder addKeyboardEvent(int keyCode, KeyboardAction action) {
        keyEvents.putIfAbsent(keyCode, action);
        return this;
    }

    public KeyboardController build() {
        return new KeyboardControllerImpl(keyEvents);
    }

}
