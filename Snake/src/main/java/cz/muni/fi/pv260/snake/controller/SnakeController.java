package cz.muni.fi.pv260.snake.controller;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.controller.InputController;
import cz.muni.fi.pv260.snake.model.Food;
import cz.muni.fi.pv260.snake.model.Snake;

import java.awt.Window;
import java.awt.event.KeyEvent;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class SnakeController {

    private static final int START_MOVE_SIZE = 10;

    private Snake snake;
    private InputController<KeyEvent> inputController;
    private Window window;

    private int moveSize = START_MOVE_SIZE;

    public SnakeController(Snake snake, InputController<KeyEvent> inputController, Window window) {
        this.snake = snake;
        this.inputController = inputController;
        this.window = window;
    }

    public void moveSnake() {
        int moveX = snake.getDirectionControl().getDirection().getMultiplierX() * moveSize;
        int moveY = snake.getDirectionControl().getDirection().getMultiplierY() * moveSize;
        adjustPosition(moveX, moveY);
    }

    public void processInputEvent(KeyEvent event) {
        inputController.processEvent(event);
    }

    public void eatFood(Food food) {
        snake.getBody().addPointToPath(food.getPosition());
        snake.setColor(food.getColor());
    }

    public Snake getSnake() {
        return snake;
    }

    private void adjustPosition(int moveX, int moveY) {
        Point position = snake.getPosition();
        int coordinateX = position.getCoordinateX() + moveX;
        int coordinateY = position.getCoordinateY() + moveY;

        coordinateX = coordinateX > window.getWidth() ? 0 : coordinateX;
        coordinateX = coordinateX < 0 ? window.getWidth() : coordinateX;

        coordinateY = coordinateY > window.getHeight() ? 0 : coordinateY;
        coordinateY = coordinateY < 0 ? window.getHeight() : coordinateY;

        snake.getBody().addPointToPath(new Point(coordinateX, coordinateY));
        snake.getBody().removeLastPointFromPath();
    }

}
