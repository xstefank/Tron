package cz.muni.fi.pv260.presentation;

import cz.muni.fi.pv260.model.Player;
import cz.muni.fi.pv260.presentation.awt.AWTPresentationAdapter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class TronScreenManagerAdapter extends AWTPresentationAdapter {

    private static final int PLAYER_SIZE = 10;

    public void updateWindow(List<Player> players) {
        fillBackgroundAndDrawPlayers(players);
        renderWindow();
    }

    private void fillBackgroundAndDrawPlayers(List<Player> players) {
        Graphics2D graphics = getGraphics();
        fillBackgroundWithColor(graphics, Color.BLACK);
        drawPlayerPaths(players, graphics);
        graphics.dispose();
    }

    private void drawPlayerPaths(List<Player> players, Graphics2D graphics) {
        players.forEach(player -> {
            graphics.setColor(player.getColor());
            player.getPath().getPoints().forEach(point ->
                    graphics.fillRect(point.getCoordinateX(), point.getCoordinateY(), PLAYER_SIZE, PLAYER_SIZE));
        });
    }
}
