package cz.muni.fi.pv260.presentation.awt;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class AWTScreenManager {

    private AWTDisplayManager displayManager;
    private AWTWindowManager windowManager;
    private AWTGraphicsProvider graphicsProvider;

    public AWTScreenManager() {
        GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice = localGraphicsEnvironment.getDefaultScreenDevice();

        this.displayManager = new AWTDisplayManager(graphicsDevice);
        this.windowManager = new AWTWindowManager(graphicsDevice.getFullScreenWindow());
        this.graphicsProvider = new AWTGraphicsProvider(windowManager.getWindow());
    }

    public AWTDisplayManager getDisplayManager() {
        return displayManager;
    }

    public AWTWindowManager getWindowManager() {
        return windowManager;
    }

    public AWTGraphicsProvider getGraphicsProvider() {
        return graphicsProvider;
    }
}
