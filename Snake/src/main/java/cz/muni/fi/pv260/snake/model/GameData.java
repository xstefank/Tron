package cz.muni.fi.pv260.snake.model;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.direction.Direction;

import java.awt.Color;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class GameData {

    private Snake player;
    private Food currentFood;

    public GameData() {
        player = new Snake(Direction.LEFT, new Point(40, 40), Color.RED);
        currentFood = new Food(new Point(600, 440), Color.BLUE);

    }

    public Snake getPlayer() {
        return player;
    }

    public Food getCurrentFood() {
        return currentFood;
    }
}
