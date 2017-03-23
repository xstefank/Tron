package cz.muni.fi.pv260.control.controller;

/**
 * Interface to define common input action
 *
 * @param <T> input event type
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public interface InputAction<T> {

    /**
     * Execute the registered action when the input is pressed
     * @param event event object associated with the input trigger action
     */
    void executeAction(T event);
}
