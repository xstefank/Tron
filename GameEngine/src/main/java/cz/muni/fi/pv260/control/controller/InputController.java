package cz.muni.fi.pv260.control.controller;

/**
 * Interface for all input methods which can require interaction
 * in the game
 *
 * @param <T1> input event type
 * @param <T2> input action type
 *
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public interface InputController<T1, T2> {

    /**
     * Process the input event
     * @param event occured input event
     */
    void processEvent(T1 event);

    /**
     * Registers the controller event with the defined user action
     *
     * @param event keyboard event
     * @param action user action to be performed when event occurs
     */
    void registerEvent(T1 event, T2 action);
}