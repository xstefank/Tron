package cz.muni.fi.pv260.control.controller;

/**
 * Interface for all input methods which can require interaction
 * in the game
 *
 * @param <T> input event type
 *
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public interface InputController<T> {

    /**
     * Process the input event
     * @param event occured input event
     */
    void processEvent(T event);

    /**
     * Registers the controller event with the defined user action
     *
     * @param event keyboard event
     * @param action user action to be performed when event occurs
     */
    void registerEvent(T event, InputAction<T> action);
}