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

    private Snake snake;
    private InputController<KeyEvent> inputController;
    private Window window;

    public SnakeController(Snake snake, InputController<KeyEvent> inputController, Window window) {
        this.snake = snake;
        this.inputController = inputController;
        this.window = window;
    }

    public void moveSnake() {
        int moveX = snake.getDirectionControl().getDirection().getMultiplierX() * snake.getSpeed();
        int moveY = snake.getDirectionControl().getDirection().getMultiplierY() * snake.getSpeed();
        adjustPosition(moveX, moveY);
    }

    public void processInputEvent(KeyEvent event) {
        inputController.processEvent(event);
    }

    public void eatFood(Food food) {
        snake.getBody().addPointToPath(food.getPosition());
        snake.setColor(food.getColor());
        updateDifficulty();
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

    private void updateDifficulty() {
        if (snake.getBody().getPoints().size() % snake.getSpeed() == 0) {
            snake.increaseSpeed();
        }
    }

}
