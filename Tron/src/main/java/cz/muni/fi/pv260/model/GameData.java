package cz.muni.fi.pv260.model;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.controller.InputController;
import cz.muni.fi.pv260.control.controller.keyboard.KeyboardControllerBuilder;
import cz.muni.fi.pv260.control.controller.mouse.MouseControllerBuilder;
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
        DirectionControl2D player1DirectionControl = new DirectionControl2DImpl(Direction.RIGHT);
        DirectionControl2D player2DirectionControl = new DirectionControl2DImpl(Direction.LEFT);

        InputController<KeyEvent> controller1 = new KeyboardControllerBuilder()
                .addEvent(KeyEvent.VK_UP, (e -> player1DirectionControl.directUp()))
                .addEvent(KeyEvent.VK_DOWN, (e -> player1DirectionControl.directDown()))
                .addEvent(KeyEvent.VK_RIGHT, (e -> player1DirectionControl.directRight()))
                .addEvent(KeyEvent.VK_LEFT, (e -> player1DirectionControl.directLeft()))
                .build();

        InputController<MouseEvent> controller2 = new MouseControllerBuilder()
                .addEvent(MouseEvent.BUTTON1, (e -> player2DirectionControl.directTurnLeft()))
                .addEvent(MouseEvent.BUTTON3, (e -> player2DirectionControl.directTurnRight()))
                .build();

        Player player1 = new Player((new Point(40, 40)), player1DirectionControl, Color.RED);
        Player player2 = new Player((new Point(600, 440)), player2DirectionControl, Color.BLUE);

        players.add(player1);
        players.add(player2);

        keyboardControllers.add(new PlayerController(window, controller1, player1));
        mouseControllers.add(new PlayerController(window, controller2, player2));
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
}
