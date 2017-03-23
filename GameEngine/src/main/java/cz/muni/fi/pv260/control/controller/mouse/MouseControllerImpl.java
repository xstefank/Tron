package cz.muni.fi.pv260.control.controller.mouse;

import cz.muni.fi.pv260.control.controller.InputController;

import java.awt.event.MouseEvent;
import java.util.Map;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class MouseControllerImpl implements MouseController {

    private Map<Integer, MouseAction> buttonEvents;

    public MouseControllerImpl(Map<Integer, MouseAction> buttonEvents) {
        this.buttonEvents = buttonEvents;
    }

    @Override
    public void processEvent(MouseEvent event) {
        MouseAction action = buttonEvents.get(event.getButton());

        if (action != null) {
            action.executeAction(event);
        }
    }

    @Override
    public void registerEvent(MouseEvent event, MouseAction action) {
        buttonEvents.putIfAbsent(event.getButton(), action);
    }
}
