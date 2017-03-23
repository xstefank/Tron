package cz.muni.fi.pv260.control.controller.mouse;

import cz.muni.fi.pv260.control.controller.InputControllerBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class MouseControllerBuilder implements InputControllerBuilder<MouseAction> {

    private Map<Integer, MouseAction> buttonEvents = new HashMap<>();

    @Override
    public MouseControllerBuilder addEvent(int keyCode, MouseAction action) {
        buttonEvents.putIfAbsent(keyCode, action);
        return this;
    }

    @Override
    public MouseControllerImpl build() {
        return new MouseControllerImpl(buttonEvents);    }
}
