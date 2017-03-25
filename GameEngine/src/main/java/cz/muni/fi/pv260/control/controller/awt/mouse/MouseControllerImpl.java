package cz.muni.fi.pv260.control.controller.awt.mouse;

import cz.muni.fi.pv260.control.controller.InputAction;
import cz.muni.fi.pv260.control.controller.InputController;

import java.awt.event.MouseEvent;
import java.util.Map;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class MouseControllerImpl implements InputController<MouseEvent> {

    private Map<Integer, InputAction<MouseEvent>> buttonEvents;

    public MouseControllerImpl(Map<Integer, InputAction<MouseEvent>> buttonEvents) {
        this.buttonEvents = buttonEvents;
    }

    @Override
    public void processEvent(MouseEvent event) {
        InputAction<MouseEvent> action = buttonEvents.get(event.getButton());

        if (action != null) {
            action.executeAction(event);
        }
    }

    @Override
    public void registerEvent(MouseEvent event, InputAction<MouseEvent> action) {
        buttonEvents.putIfAbsent(event.getButton(), action);
    }
}
