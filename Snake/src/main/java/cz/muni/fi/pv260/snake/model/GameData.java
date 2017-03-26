package cz.muni.fi.pv260.snake.model;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.controller.awt.AWTControllerFactory;
import cz.muni.fi.pv260.control.direction.Direction;
import cz.muni.fi.pv260.snake.controller.SnakeController;

import java.awt.Color;
import java.awt.Window;
import java.util.Random;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class GameData {

    private SnakeController snakeController;
    private Food currentFood;
    private Window window;

    public GameData(Window window) {
        this.window = window;

        Snake snake = new Snake(Direction.LEFT, new Point(40, 40), Color.RED);
        snakeController = new SnakeController(snake,
                AWTControllerFactory.newArrows2DController(snake.getDirectionControl()), window);
        currentFood = generateNewFood();

    }

    public void eatFood() {
        snakeController.eatFood(currentFood);
        currentFood = generateNewFood();
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

    private Food generateNewFood() {
        Random random = new Random();
        int x = random.nextInt(window.getWidth() + 1) * 10 % window.getWidth();
        int y = random.nextInt(window.getHeight() + 1) * 10 % window.getHeight();
        return new Food(new Point(x, y), randomColor(random));
    }

    private Color randomColor(Random rand) {
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b).brighter();
    }
}
