package cz.muni.fi.pv260.presentation.awt;

import javax.swing.JFrame;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class AWTDisplayManager {

    private static final DisplayMode DISPLAY_MODES[] = {
            new DisplayMode(1680, 1050, 32, 0),
            new DisplayMode(800, 600, 32, 0),
            new DisplayMode(800, 600, 24, 0),
            new DisplayMode(800, 600, 16, 0),
            new DisplayMode(640, 480, 32, 0),
            new DisplayMode(640, 480, 24, 0),
            new DisplayMode(640, 480, 16, 0),
    };

    private GraphicsDevice graphicsDevice;

    public AWTDisplayManager(GraphicsDevice graphicsDevice) {
        this.graphicsDevice = graphicsDevice;
        DisplayMode displayMode = findCompatibleDisplayMode(DISPLAY_MODES);
        setFullScreen(displayMode);
    }

    public DisplayMode[] getCompatibleDisplayModes() {
        return graphicsDevice.getDisplayModes();
    }

    public DisplayMode findCompatibleDisplayMode(DisplayMode[] displayModes) {

        DisplayMode compatibleDisplayModes[] = getCompatibleDisplayModes();
        for (DisplayMode displayMode : displayModes) {
            for (DisplayMode compatibleDisplayMode : compatibleDisplayModes) {
                if (displayModesMatch(displayMode, compatibleDisplayMode)) {
                    return displayMode;
                }
            }
        }

        return null;
    }

    public void setFullScreen(DisplayMode displayMode) {
        JFrame frame = new JFrame();
        frame.setUndecorated(true);
        frame.setIgnoreRepaint(true);
        frame.setResizable(false);
        graphicsDevice.setFullScreenWindow(frame);

        if (displayMode != null && graphicsDevice.isDisplayChangeSupported()) {
            try {
                graphicsDevice.setDisplayMode(displayMode);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            frame.createBufferStrategy(2);
        }
    }

    public void restoreScreen() {
        graphicsDevice.setFullScreenWindow(null);
    }

    private boolean displayModesMatch(DisplayMode mode1, DisplayMode mode2) {
        if (mode1.getWidth() != mode2.getWidth() || mode1.getHeight() != mode2.getHeight()) {
            return false;
        }
        if (mode1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI && mode2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
                mode1.getBitDepth() != mode2.getBitDepth()) {
            return false;
        }
        return !(mode1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN &&
                mode2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN && mode1.getRefreshRate() != mode2.getRefreshRate());
    }

}
