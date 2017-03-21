package cz.muni.fi.pv260.controller;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.model.Player;
import java.awt.Window;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class PlayerController {

    private static final int MOVE_LENGTH = 5;
    private Window window;

    public PlayerController(Window window) {
        this.window = window;
    }

    public void move(Player player) {
        int moveX = player.getDirectionControl().getDirection().getMultiplierX() * MOVE_LENGTH;
        int moveY = player.getDirectionControl().getDirection().getMultiplierY() * MOVE_LENGTH;
        adjustPosition(player, moveX, moveY);
    }

    private void adjustPosition(Player player, int moveX, int moveY) {
        Point position = player.getPosition();
        int coordinateX = position.getCoordinateX() + moveX;
        int coordinateY = position.getCoordinateY() + moveY;

        coordinateX = coordinateX > window.getWidth() ? 0 : coordinateX;
        coordinateX = coordinateX < 0 ? window.getWidth() : coordinateX;

        coordinateY = coordinateY > window.getHeight() ? 0 : coordinateY;
        coordinateY = coordinateY < 0 ? window.getHeight() : coordinateY;

        player.getPath().addPointToPath(new Point(position.getCoordinateX(), position.getCoordinateY()));
        position.setCoordinates(coordinateX, coordinateY);
    }


}
