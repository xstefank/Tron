package cz.muni.fi.pv260.presentation.awt;

import cz.muni.fi.pv260.control.collision.Point;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Window;

/**
 * Basic adapter for most common use cases of the graphical usage
 * in this game engine. This is a wrapper class of {@link AWTScreenManager} class.
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public abstract class AWTPresentationAdapter {

    protected static final Point UPPER_LEFT_CORNER = new Point(0, 0);

    protected AWTScreenManager screenManager = new AWTScreenManager();

    public Window getWindow() {
        return screenManager.getWindowManager().getWindow();
    }

    public void restoreUserEnvironment() {
        screenManager.getWindowManager().restoreWindow();
        screenManager.getDisplayManager().restoreScreen();
    }

    protected void renderWindow() {
        screenManager.getWindowManager().renderWindow();
    }

    protected Graphics2D getGraphics() {
        return (Graphics2D) screenManager.getGraphicsProvider().getGraphics();
    }

    protected void fillBackgroundWithColor(Graphics2D graphics, Color color) {
        graphics.setColor(color);
        graphics.fillRect(UPPER_LEFT_CORNER.getCoordinateX(), UPPER_LEFT_CORNER.getCoordinateX(),
                getPlayableAreaWidth(), getPlayableAreaHeight());
    }

    protected int getPlayableAreaWidth() {
        return screenManager.getWindowManager().getWindowWidth();
    }

    protected int getPlayableAreaHeight() {
        return screenManager.getWindowManager().getWindowHeight();
    }
}
