package cz.muni.fi.pv260.control.controller.mouse;

import cz.muni.fi.pv260.control.controller.InputAction;

import java.awt.event.MouseEvent;

/**
 * Interface representing action to be performed on
 * the {@link MouseController} when the key is pressed
 *
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public interface MouseAction extends InputAction<MouseEvent> {

    /**
     * Execute the registered action when the button is pressed
     * @param event event object associated with the button pressed action
     */
    void executeAction(MouseEvent event);
}
