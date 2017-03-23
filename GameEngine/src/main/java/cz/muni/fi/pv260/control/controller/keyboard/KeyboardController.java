package cz.muni.fi.pv260.control.controller.keyboard;

import cz.muni.fi.pv260.control.controller.InputController;

import java.awt.event.KeyEvent;

/**
 * Controller for the processing of keyboard events
 */
public interface KeyboardController extends InputController<KeyEvent, KeyboardAction> {

    /**
     * Registers the keyboard event with the defined user action
     *
     * @param event keyboard event
     * @param action user action to be performed when event occurs
     */
    void registerEvent(KeyEvent event, KeyboardAction action);

}