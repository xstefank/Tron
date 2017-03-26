package cz.muni.fi.pv260.snake.presentation;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.presentation.awt.AWTPresentationAdapter;
import cz.muni.fi.pv260.snake.model.Food;
import cz.muni.fi.pv260.snake.model.GameData;
import cz.muni.fi.pv260.snake.model.Snake;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class SnakeScreenManager extends AWTPresentationAdapter {

    private static final int PIXEL_SIZE = 10;

    public void updateWindow(GameData gameData) {
        Graphics2D graphics = getGraphics();
        fillBackgroundWithColor(graphics, Color.BLACK);
        drawPlayerAndFood(gameData);
        graphics.dispose();
        renderWindow();
    }

    private void drawPlayerAndFood(GameData gameData) {
        drawSnake(gameData.getSnake());
        drawCurrentFood(gameData.getCurrentFood());
    }

    private void drawSnake(Snake snake) {
        snake.getBody().getPoints().forEach(point -> {
            drawPixelWithColor(point, snake.getColor());
        });
    }

    private void drawPixelWithColor(Point point, Color color) {
        Graphics2D graphics = getGraphics();
        graphics.setColor(color);
        graphics.fillRect(point.getCoordinateX(), point.getCoordinateY(),
                PIXEL_SIZE, PIXEL_SIZE);
        graphics.dispose();
    }

    private void drawCurrentFood(Food currentFood) {
        drawPixelWithColor(currentFood.getPosition(), currentFood.getColor());
    }
}
