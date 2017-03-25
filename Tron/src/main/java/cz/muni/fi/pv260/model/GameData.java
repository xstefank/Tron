package cz.muni.fi.pv260.model;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.controller.awt.AWTControllerFactory;
import cz.muni.fi.pv260.control.controller.InputController;
import cz.muni.fi.pv260.control.controller.awt.mouse.MouseControllerBuilder;
import cz.muni.fi.pv260.control.direction.Direction;
import cz.muni.fi.pv260.control.direction.DirectionControl2D;
import cz.muni.fi.pv260.control.direction.DirectionControl2DImpl;
import cz.muni.fi.pv260.controller.PlayerController;

import java.awt.Color;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *  Class responsible for managing players
 *
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class GameData {

    private List<Player> players = new ArrayList<>();
    private List<PlayerController> keyboardControllers = new ArrayList<>();
    private List<PlayerController> mouseControllers = new ArrayList<>();

    public GameData(Window window) {
        Player player1 = createPlayer(Direction.RIGHT, 40, 40, Color.RED);
        Player player2 = createPlayer(Direction.LEFT, 600, 440, Color.BLUE);

        registerKeyboardPlayer(player1, AWTControllerFactory.newArrows2DController(player1.getDirectionControl()), window);
        registerMousePlayer(player2, AWTControllerFactory.newMouseButtonController(player2.getDirectionControl()), window);
    }

    public List<PlayerController> getPlayerControllers() {
        List<PlayerController> controllers = new ArrayList<>();
        keyboardControllers.forEach(controllers::add);
        mouseControllers.forEach(controllers::add);
        return controllers;
    }

    public List<PlayerController> getKeyboardControllers() {
        return keyboardControllers;
    }

    public List<PlayerController> getMouseControllers() {
        return mouseControllers;
    }

    private void registerMousePlayer(Player player, InputController<MouseEvent> controller, Window window) {
        players.add(player);
        mouseControllers.add(new PlayerController(player, controller, window));
    }

    private void registerKeyboardPlayer(Player player, InputController<KeyEvent> controller, Window window) {
        players.add(player);
        keyboardControllers.add(new PlayerController(player, controller, window));
    }

    private Player createPlayer(Direction startDirection, int startX, int startY, Color color) {
        return new Player(new Point(startX, startY), new DirectionControl2DImpl(startDirection), color);
    }
}
