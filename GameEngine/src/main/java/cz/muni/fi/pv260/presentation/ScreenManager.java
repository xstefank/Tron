package cz.muni.fi.pv260.presentation;

/**
 * Aggregate interface for the {@link DisplayManager}, {@link WindowManager}
 * and {@link GraphicsProvider} interfaces
 *
 * @param <T> display mode type
 * @param <U> window type
 *
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public interface ScreenManager<T, U> {

    /**
     * Returns the instance of {@link DisplayManager}
     * associated with this screen
     * @return the display manager
     */
    DisplayManager<T> getDisplayManager();

    /**
     * Returns the instance of {@link WindowManager}
     * associated with this screen
     * @return the window manager
     */
    WindowManager<U> getWindowManager();

    /**
     * Returns the instance of {@link GraphicsProvider}
     * associated with this screen
     * @return the graphics provider
     */
    GraphicsProvider getGraphicsProvider();

}
