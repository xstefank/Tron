package cz.muni.fi.pv260.controller;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.controller.InputController;
import cz.muni.fi.pv260.model.Player;

import java.awt.Window;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class PlayerController {

    private static final int MOVE_LENGTH = 5;
    private Window window;

    private InputController inputController;
    private Player player;

    public PlayerController(Window window, InputController inputController, Player player) {
        this.window = window;
        this.inputController = inputController;
        this.player = player;
    }

    public void move() {
        int moveX = player.getDirectionControl().getDirection().getMultiplierX() * MOVE_LENGTH;
        int moveY = player.getDirectionControl().getDirection().getMultiplierY() * MOVE_LENGTH;
        adjustPosition(moveX, moveY);
    }

    public void processInputEvent(Object event) {
        inputController.processEvent(event);
    }

    public Player getPlayer() {
        return player;
    }

    private void adjustPosition(int moveX, int moveY) {
        Point position = player.getPosition();
        int coordinateX = position.getCoordinateX() + moveX;
        int coordinateY = position.getCoordinateY() + moveY;

        coordinateX = coordinateX > window.getWidth() ? 0 : coordinateX;
        coordinateX = coordinateX < 0 ? window.getWidth() : coordinateX;

        coordinateY = coordinateY > window.getHeight() ? 0 : coordinateY;
        coordinateY = coordinateY < 0 ? window.getHeight() : coordinateY;

        player.getPath().addPointToPath(new Point(coordinateX, coordinateY));
    }

}
