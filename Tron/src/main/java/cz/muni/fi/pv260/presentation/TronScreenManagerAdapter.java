package cz.muni.fi.pv260.presentation;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.model.Player;
import cz.muni.fi.pv260.presentation.awt.AWTScreenManager;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics2D;
import java.awt.Window;
import java.util.List;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class TronScreenManagerAdapter {

    private static final int PLAYER_SIZE = 10;
    private static final Point UPPER_LEFT_CORNER = new Point(0, 0);

    private ScreenManager<DisplayMode, Window> screenManager = new AWTScreenManager();

    public Window getWindow() {
        return screenManager.getWindowManager().getWindow();
    }

    public void restoreUserEnvironment() {
        screenManager.getWindowManager().restoreWindow();
        screenManager.getDisplayManager().restoreScreen();
    }

    public void updateWindow(List<Player> players) {
        fillBackgroundAndDrawPlayers(players);
        screenManager.getWindowManager().updateWindow();
    }

    private void fillBackgroundAndDrawPlayers(List<Player> players) {
        Graphics2D graphics = getGraphics();
        fillBackgroundWithBlackColor(graphics);
        drawPlayerPaths(players, graphics);
        graphics.dispose();
    }

    private void fillBackgroundWithBlackColor(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(UPPER_LEFT_CORNER.getCoordinateX(), UPPER_LEFT_CORNER.getCoordinateX(),
                getPlayerAreaWidth(), getPlayerAreaHeight());
    }

    private void drawPlayerPaths(List<Player> players, Graphics2D graphics) {
        players.forEach(player -> {
            graphics.setColor(player.getColor());
            player.getPath().getPoints().forEach(point ->
                    graphics.fillRect(point.getCoordinateX(), point.getCoordinateY(), PLAYER_SIZE, PLAYER_SIZE));
        });
    }

    private Graphics2D getGraphics() {
        return (Graphics2D) screenManager.getGraphicsProvider().getGraphics();
    }

    private int getPlayerAreaWidth() {
        return screenManager.getWindowManager().getWindowWidth();
    }

    private int getPlayerAreaHeight() {
        return screenManager.getWindowManager().getWindowHeight();
    }
}
