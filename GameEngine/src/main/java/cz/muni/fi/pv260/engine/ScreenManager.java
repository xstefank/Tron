package cz.muni.fi.pv260.engine;

import javax.swing.JFrame;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.image.BufferStrategy;

public class ScreenManager {

    private GraphicsDevice graphicsDevice;

    public ScreenManager() {
        GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        graphicsDevice = localGraphicsEnvironment.getDefaultScreenDevice();
    }

    public DisplayMode[] getCompatibleDisplayModes() {
        return graphicsDevice.getDisplayModes();
    }

    public DisplayMode findFirstCompatibaleMode(DisplayMode[] modes) {

        DisplayMode compatibleDisplayModes[] = getCompatibleDisplayModes();
        for (DisplayMode mode : modes) {
            for (DisplayMode compatibleDisplayMode : compatibleDisplayModes) {
                if (displayModesMatch(mode, compatibleDisplayMode)) {
                    return mode;
                }
            }
        }
        return null;
    }

    public boolean displayModesMatch(DisplayMode mode1, DisplayMode mode2) {
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

    public Graphics2D getGraphics() {
        Window fullScreenWindow = graphicsDevice.getFullScreenWindow();
        if (fullScreenWindow != null) {
            BufferStrategy bufferStrategy = fullScreenWindow.getBufferStrategy();
            return (Graphics2D) bufferStrategy.getDrawGraphics();
        } else {
            return null;
        }
    }

    public void update() {
        Window fullScreenWindow = graphicsDevice.getFullScreenWindow();
        if (fullScreenWindow != null) {
            BufferStrategy bufferStrategy = fullScreenWindow.getBufferStrategy();
            if (!bufferStrategy.contentsLost()) {
                bufferStrategy.show();
            }
        }
    }

    public Window getFullScreenWindow() {
        return graphicsDevice.getFullScreenWindow();
    }

    public int getWidth() {
        Window fullScreenWindow = graphicsDevice.getFullScreenWindow();
        if (fullScreenWindow != null) {
            return fullScreenWindow.getWidth();
        } else {
            return 0;
        }
    }

    public int getHeight() {
        Window fullScreenWindow = graphicsDevice.getFullScreenWindow();
        if (fullScreenWindow != null) {
            return fullScreenWindow.getHeight();
        } else {
            return 0;
        }
    }

    public void restoreScreen() {
        Window fullScreenWindow = graphicsDevice.getFullScreenWindow();
        if (fullScreenWindow != null) {
            fullScreenWindow.dispose();
        }
        graphicsDevice.setFullScreenWindow(null);
    }
}
