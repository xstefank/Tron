package cz.muni.fi.pv260.control.controller.keyboard;

import cz.muni.fi.pv260.control.controller.InputAction;

import java.awt.event.KeyEvent;

/**
 * Interface representing action to be performed on
 * the {@link KeyboardController} when the key is pressed
 */
public interface KeyboardAction extends InputAction<KeyEvent> {

    /**
     * Execute the registered action when the key is pressed
     * @param event event object associated with the keypressed action
     */
    void executeAction(KeyEvent event);
}
