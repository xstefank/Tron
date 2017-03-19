package cz.muni.fi.pv260.control.controller;

import java.awt.event.KeyEvent;

/**
 * Controller for processing keyboard events
 */
public interface KeyboardController {

    /**
     * Process the keyboard event with defined user action
     * @param event keyboard event
     */
    void processKeyboardEvent(KeyEvent event);

}
