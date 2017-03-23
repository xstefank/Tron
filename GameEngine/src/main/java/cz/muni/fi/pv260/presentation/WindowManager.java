package cz.muni.fi.pv260.presentation;

/**
 * Interface representing the management and arrangement of the game window
 *
 * @param <T> window type
 *
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public interface WindowManager<T> {

    /**
     * @return the game window of type {@link T}
     */
    T getWindow();

    /**
     * Returns the width of the associated game window
     * @return the window width
     */
    int getWindowWidth();

    /**
     * Returns the height of the associated fame window
     * @return the window height
     */
    int getWindowHeight();

    /**
     * Updates the window with the new content
     */
    void updateWindow();

    /**
     * Restores the window to its original state
     */
    void restoreWindow();
}
