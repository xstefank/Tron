package cz.muni.fi.pv260;
import cz.muni.fi.pv260.Player.Direction;
import java.awt.*;

/**
 * Created by Marek on 19.3.2017.
 */
public class PlayerController {

    private static Window window;
    private static int moveLength = 5;

    public PlayerController(Window window){
        this.window = window;
    }

    public static void move(Player player){
        int moveX = player.getDirection().getMultiplierX() * moveLength;
        int moveY = player.getDirection().getMultiplierY() * moveLength;
        adjustPosition(player, moveX, moveY);
    }

    private static void adjustPosition(Player player, int moveX, int moveY){
        Position position = player.getPosition();
        int coordinateX = position.getCoordinateX() + moveX;
        int coordinateY = position.getCoordinateY() + moveY;

        coordinateX = coordinateX > window.getWidth() ? 0 : coordinateX;
        coordinateX = coordinateX < 0 ? window.getWidth() : coordinateX;

        coordinateY = coordinateY > window.getHeight() ? 0 : coordinateY;
        coordinateY = coordinateY < 0 ? window.getHeight() : coordinateY;

        player.appendCurrentPositionToPath();
        position.setCoordinates(coordinateX, coordinateY);
    }

    public void changeDirection(Player player, int keyCode){
        Direction newDirection = player.getKeys().getKeyCodeDirection(keyCode);
        if(newDirection != null && player.getDirection() != newDirection.getOpposite()){
            player.setDirection(newDirection);
        }

    }

}
