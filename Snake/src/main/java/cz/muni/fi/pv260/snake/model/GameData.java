package cz.muni.fi.pv260.snake.model;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.controller.awt.AWTControllerFactory;
import cz.muni.fi.pv260.control.direction.Direction;
import cz.muni.fi.pv260.snake.controller.SnakeController;

import java.awt.Color;
import java.awt.Window;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class GameData {

    private SnakeController snakeController;
    private Food currentFood;

    public GameData(Window window) {
        Snake snake = new Snake(Direction.LEFT, new Point(40, 40), Color.RED);
        snakeController = new SnakeController(snake,
                AWTControllerFactory.newArrows2DController(snake.getDirectionControl()), window);
        currentFood = new Food(new Point(600, 440), Color.BLUE);

    }

    public Snake getSnake() {
        return snakeController.getSnake();
    }

    public SnakeController getSnakeController() {
        return snakeController;
    }

    public Food getCurrentFood() {
        return currentFood;
    }
}
