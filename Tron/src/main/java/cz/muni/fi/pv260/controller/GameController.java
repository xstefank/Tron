package cz.muni.fi.pv260.controller;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.controller.keyboard.KeyboardController;
import cz.muni.fi.pv260.control.controller.keyboard.KeyboardControllerBuilder;
import cz.muni.fi.pv260.control.direction.Direction;
import cz.muni.fi.pv260.control.direction.DirectionControl2D;
import cz.muni.fi.pv260.control.direction.DirectionControl2DImpl;
import cz.muni.fi.pv260.model.Player;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *  Class responsible for managing players
 *
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class GameController {

    private List<Player> players = new ArrayList<>();

    public GameController() {
        DirectionControl2D player1DirectionControl = new DirectionControl2DImpl(Direction.DIRECTION_RIGHT);
        DirectionControl2D player2DirectionControl = new DirectionControl2DImpl(Direction.DIRECTION_LEFT);

        KeyboardController controller1 = new KeyboardControllerBuilder()
                .addKeyboardEvent(KeyEvent.VK_UP, (e -> player1DirectionControl.directUp()))
                .addKeyboardEvent(KeyEvent.VK_DOWN, (e -> player1DirectionControl.directDown()))
                .addKeyboardEvent(KeyEvent.VK_RIGHT, (e -> player1DirectionControl.directRight()))
                .addKeyboardEvent(KeyEvent.VK_LEFT, (e -> player1DirectionControl.directLeft()))
                .build();

        KeyboardController controller2 = new KeyboardControllerBuilder()
                .addKeyboardEvent(KeyEvent.VK_W, (e -> player2DirectionControl.directUp()))
                .addKeyboardEvent(KeyEvent.VK_S, (e -> player2DirectionControl.directDown()))
                .addKeyboardEvent(KeyEvent.VK_D, (e -> player2DirectionControl.directRight()))
                .addKeyboardEvent(KeyEvent.VK_A, (e -> player2DirectionControl.directLeft()))
                .build();

        Player player1 = new Player((new Point(40, 40)), player1DirectionControl, controller1, Color.RED);
        Player player2 = new Player((new Point(600, 440)), player2DirectionControl, controller2, Color.BLUE);

        players.add(player1);
        players.add(player2);
    }

    public List<Player> getPlayers() {
        return players;
    }

}
