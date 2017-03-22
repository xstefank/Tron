package cz.muni.fi.pv260.control.controller.keyboard;

import java.awt.event.KeyEvent;

/**
 * Interface representing action to be performed on
 * the {@link KeyboardController} when the key is pressed
 */
public interface KeyboardAction {

    /**
     * Execute the registered action when the key is pressed
     * @param event event object associated with the keypressed action
     */
    void executeAction(KeyEvent event);
}
