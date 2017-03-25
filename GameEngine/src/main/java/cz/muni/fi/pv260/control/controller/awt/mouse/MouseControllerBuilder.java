package cz.muni.fi.pv260.control.controller.awt.mouse;

import cz.muni.fi.pv260.control.controller.InputAction;
import cz.muni.fi.pv260.control.controller.InputControllerBuilder;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class MouseControllerBuilder implements InputControllerBuilder<InputAction<MouseEvent>> {

    private Map<Integer, InputAction<MouseEvent>> buttonEvents = new HashMap<>();

    @Override
    public MouseControllerBuilder addEvent(int keyCode, InputAction<MouseEvent> action) {
        buttonEvents.putIfAbsent(keyCode, action);
        return this;
    }

    @Override
    public MouseControllerImpl build() {
        return new MouseControllerImpl(buttonEvents);
    }
}
