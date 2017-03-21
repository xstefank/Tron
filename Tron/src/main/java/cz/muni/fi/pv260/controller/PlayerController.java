package cz.muni.fi.pv260.controller;
import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.model.Player;

import java.awt.*;


/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class PlayerController {

    private static Window window;
    private static int moveLength = 5;

    public PlayerController(Window window){
        this.window = window;
    }

    public static void move(Player player){
        int moveX = player.getDirectionControl().getDirection().getMultiplierX() * moveLength;
        int moveY = player.getDirectionControl().getDirection().getMultiplierY() * moveLength;
        adjustPosition(player, moveX, moveY);
    }

    private static void adjustPosition(Player player, int moveX, int moveY){
        Point position = player.getPosition();
        int coordinateX = position.getCoordinateX() + moveX;
        int coordinateY = position.getCoordinateY() + moveY;

        coordinateX = coordinateX > window.getWidth() ? 0 : coordinateX;
        coordinateX = coordinateX < 0 ? window.getWidth() : coordinateX;

        coordinateY = coordinateY > window.getHeight() ? 0 : coordinateY;
        coordinateY = coordinateY < 0 ? window.getHeight() : coordinateY;

        player.getPath().addPointToPath(position);
        position.setCoordinates(coordinateX, coordinateY);
    }


}
