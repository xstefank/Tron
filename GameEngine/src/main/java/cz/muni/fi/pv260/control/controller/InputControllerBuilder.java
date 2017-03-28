package cz.muni.fi.pv260.control.controller;

/**
 * Interface for input controller builders
 *
 * @param <T> action type
 *
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public interface InputControllerBuilder<T> {

    /**
     * Adds action corresponding to Input trigger event
     * @param inputCode numeric input code
     * @param action action to be executed after input is triggered
     */
    InputControllerBuilder addEvent(int inputCode, T action);

    /**
     * @return Built InputController implementation with assigned input events
     */
    InputController build();

}
