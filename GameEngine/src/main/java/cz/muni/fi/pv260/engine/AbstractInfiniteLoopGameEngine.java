package cz.muni.fi.pv260.engine;

import cz.muni.fi.pv260.presentation.ScreenManager;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Window;
import java.awt.image.BufferedImage;

public abstract class AbstractInfiniteLoopGameEngine implements InfiniteLoopGameEngine {

    private static final int DEFAULT_SLEEP_TIME = 20;

    private FrameTimer frameTimer = new InfiniteLoopFrameTimer(DEFAULT_SLEEP_TIME);

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

    protected ScreenManager screenManager;

    @Override
    public void run() {
        try {
            init();
            startGame();
        } finally {
            screenManager.restoreScreen();
        }
    }

    @Override
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

    }

    @Override
    public boolean isRunning() {
        return frameTimer.isRunning();
    }

    @Override
    public void stop() {
        frameTimer.stopTimer();
    }

    @Override
    public void update() {
        Graphics2D graphics = screenManager.getGraphics();
        draw(graphics);
        graphics.dispose();
        screenManager.update();
    }

    public abstract void draw(Graphics2D graphics);

    @Override
    public void onLoopStart() {
    }

    @Override
    public void onLoopEnd() {
    }

    private void startGame() {
        frameTimer.startTimer();
    }

    private class InfiniteLoopFrameTimer extends FrameTimerImpl {

        public InfiniteLoopFrameTimer(int sleepTime) {
            super(sleepTime);
        }

        @Override
        public void renderFrame() {
            onLoopStart();
            update();
            onLoopEnd();
        }
    }

}
