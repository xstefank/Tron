package cz.muni.fi.pv260;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Window;
import java.awt.image.BufferedImage;

public abstract class AbstractCoreGameEngine {

    private static final DisplayMode DISPLAY_MODES[] =
            {
                    new DisplayMode(1680, 1050, 32, 0),
                    new DisplayMode(800, 600, 32, 0),
                    new DisplayMode(800, 600, 24, 0),
                    new DisplayMode(800, 600, 16, 0),
                    new DisplayMode(640, 480, 32, 0),
                    new DisplayMode(640, 480, 24, 0),
                    new DisplayMode(640, 480, 16, 0),
            };

    private boolean running;
    protected ScreenManager screenManager;

    public void stop() {
        running = false;
    }

    public void run() {
        try {
            init();
            loopGame();
        } finally {
            screenManager.restoreScreen();
        }
    }

    public void init() {
        screenManager = new ScreenManager();
        DisplayMode displayMode = screenManager.findFirstCompatibaleMode(DISPLAY_MODES);
        screenManager.setFullScreen(displayMode);
        Window fullScreenWindow = screenManager.getFullScreenWindow();
        fullScreenWindow.setFont(new Font("Arial", Font.PLAIN, 20));
        fullScreenWindow.setBackground(Color.WHITE);
        fullScreenWindow.setForeground(Color.RED);
        fullScreenWindow.setCursor(fullScreenWindow.getToolkit().createCustomCursor(new BufferedImage(3, 3,
                BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null"));
        running = true;
    }

    public void update(long timePassed) {
    }

    public abstract void draw(Graphics2D graphics);

    private void loopGame() {
        long currentTime = System.currentTimeMillis();

        while (running) {
            long timePassed = System.currentTimeMillis() - currentTime;
            currentTime += timePassed;
            update(timePassed);
            Graphics2D graphics = screenManager.getGraphics();
            draw(graphics);
            graphics.dispose();
            screenManager.update();

            try {
                Thread.sleep(20);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
