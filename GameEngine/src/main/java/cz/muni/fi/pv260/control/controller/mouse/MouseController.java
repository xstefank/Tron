package cz.muni.fi.pv260.control.controller.mouse;

import cz.muni.fi.pv260.control.controller.InputController;

import java.awt.event.MouseEvent;

/**
 * Controller for the processing of mouse events
 *
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public interface MouseController extends InputController<MouseEvent, MouseAction> {

    /**
     * Registers the mouse event with the defined user action
     *
     * @param event  mouse event
     * @param action user action to be performed when event occurs
     */
    void registerEvent(MouseEvent event, MouseAction action);
}
