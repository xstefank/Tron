package cz.muni.fi.pv260.presentation.awt;

import cz.muni.fi.pv260.presentation.DisplayManager;
import cz.muni.fi.pv260.presentation.GraphicsProvider;
import cz.muni.fi.pv260.presentation.ScreenManager;
import cz.muni.fi.pv260.presentation.WindowManager;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class AWTScreenManager implements ScreenManager<DisplayMode, Window> {

    private DisplayManager<DisplayMode> displayManager;
    private WindowManager<Window> windowManager;
    private GraphicsProvider graphicsProvider;

    public AWTScreenManager() {
        GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice = localGraphicsEnvironment.getDefaultScreenDevice();

        this.displayManager = new AWTDisplayManager(graphicsDevice);
        this.windowManager = new AWTWindowManager(graphicsDevice.getFullScreenWindow());
        this.graphicsProvider = new AWTGraphicsProvider(windowManager.getWindow());
    }

    @Override
    public DisplayManager<DisplayMode> getDisplayManager() {
        return displayManager;
    }

    @Override
    public WindowManager<Window> getWindowManager() {
        return windowManager;
    }

    @Override
    public GraphicsProvider getGraphicsProvider() {
        return graphicsProvider;
    }
}
