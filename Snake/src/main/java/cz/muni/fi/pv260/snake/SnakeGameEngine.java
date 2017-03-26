package cz.muni.fi.pv260.snake;

import cz.muni.fi.pv260.control.collision.CollisionDetector;
import cz.muni.fi.pv260.control.collision.PathCollisionDetector;
import cz.muni.fi.pv260.control.collision.PathPointCollisionDetector;
import cz.muni.fi.pv260.engine.AbstractInfiniteLoopGameEngine;
import cz.muni.fi.pv260.snake.listener.KeyboardListener;
import cz.muni.fi.pv260.snake.model.GameData;
import cz.muni.fi.pv260.snake.presentation.SnakeScreenManager;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class SnakeGameEngine extends AbstractInfiniteLoopGameEngine {

    private GameData gameData;
    private SnakeScreenManager screenManager = new SnakeScreenManager();
    private CollisionDetector collisionDetector = new PathPointCollisionDetector();

    public static void main(String[] args) {
        new SnakeGameEngine().run();
    }

    @Override
    public void run() {
        try {
            super.run();
        } finally {
            screenManager.restoreUserEnvironment();
        }
    }

    @Override
    public void init() {
        gameData = new GameData(screenManager.getWindow());
        screenManager.getWindow().addKeyListener(new KeyboardListener(gameData));
    }

    @Override
    public void update() {
        gameData.getSnakeController().moveSnake();
        checkPlayerFoodCollision(gameData);
    }

    private void checkPlayerFoodCollision(GameData gameData) {
        if (collisionDetector.detectCollision(gameData.getSnake().getBody(), gameData.getCurrentFood().getPosition())) {
            gameData.eatFood();

        }
    }

    @Override
    public void redrawWindow() {
        screenManager.updateWindow(gameData);
    }
}
