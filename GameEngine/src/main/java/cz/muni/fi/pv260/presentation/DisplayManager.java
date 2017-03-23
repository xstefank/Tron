package cz.muni.fi.pv260.presentation;

/**
 * Interface for the arranging displays and the display management
 *
 * @param <T> display mode
 *
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public interface DisplayManager<T> {


    /**
     * Returns the collection of all available display modes
     * @return available display modes
     */
    T[] getCompatibleDisplayModes();

    /**
     * Returns one of the display modes that is
     * compatible with the running screen. if no
     * such mode can be found {@code null} is returned
     * @return compatible display mode or null
     */
    T findCompatibleDisplayMode(T[] displayModes);

    /**
     * Sets the resolution of the display to full screen
     * with the selected display mode
     * @param displayMode mode for the screen setup
     */
    void setFullScreen(T displayMode);

    /**
     * Restores the screen to its original state
     */
    void restoreScreen();
}
