package cz.muni.fi.pv260.snake.presentation;

import cz.muni.fi.pv260.presentation.awt.AWTPresentationAdapter;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class SnakeScreenManager extends AWTPresentationAdapter {

    public void updateWindow() {
        Graphics2D graphics = getGraphics();
        fillBackgroundWithColor(graphics, Color.BLACK);
        graphics.dispose();
        renderWindow();
    }
}
